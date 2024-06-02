package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoUpdatePacket;
import de.oliver.fancysitula.versions.v1_20_6.entities.PlayerImpl;
import io.papermc.paper.adventure.PaperAdventure;
import net.minecraft.Optionull;
import net.minecraft.network.chat.RemoteChatSession;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ClientboundPlayerInfoUpdatePacketImpl extends FS_ClientboundPlayerInfoUpdatePacket {

    public ClientboundPlayerInfoUpdatePacketImpl(EnumSet<Action> actions, List<Entry> entries) {
        super(actions, entries);
    }

    @Override
    public void send(FS_Player player) {
        EnumSet<ClientboundPlayerInfoUpdatePacket.Action> actions = EnumSet.noneOf(ClientboundPlayerInfoUpdatePacket.Action.class);
        for (ClientboundPlayerInfoUpdatePacket.Action action : actions) {
            actions.add(ClientboundPlayerInfoUpdatePacket.Action.valueOf(action.name()));
        }

        List<ClientboundPlayerInfoUpdatePacket.Entry> entries = new ArrayList<>();
        for (Entry entry : this.entries) {
            ServerPlayer serverPlayer = PlayerImpl.asVanilla(entry.player());

            entries.add(new ClientboundPlayerInfoUpdatePacket.Entry(
                    entry.uuid(),
                    serverPlayer.gameProfile,
                    entry.listed(),
                    entry.latency(),
                    GameType.byId(entry.gameMode().getId()),
                    PaperAdventure.asVanilla(entry.displayName()),
                    Optionull.map(serverPlayer.getChatSession(), RemoteChatSession::asData)
            ));
        }

        ClientboundPlayerInfoUpdatePacket packet = new ClientboundPlayerInfoUpdatePacket(actions, entries);
        ((PlayerImpl) player).getVanillaPlayer().connection.send(packet);
    }
}
