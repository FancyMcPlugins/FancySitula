package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoRemovePacket;
import de.oliver.fancysitula.versions.v1_20_6.entities.PlayerImpl;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoRemovePacket;

import java.util.List;
import java.util.UUID;

public class ClientboundPlayerInfoRemovePacketImpl extends FS_ClientboundPlayerInfoRemovePacket {

    public ClientboundPlayerInfoRemovePacketImpl(List<UUID> uuids) {
        super(uuids);
    }

    @Override
    public Object createPacket() {
        return new ClientboundPlayerInfoRemovePacket(uuids);
    }

    @Override
    public void send(FS_Player player) {
        ClientboundPlayerInfoRemovePacket packet = (ClientboundPlayerInfoRemovePacket) createPacket();

        ((PlayerImpl) player).getVanillaPlayer().connection.send(packet);
    }
}
