package de.oliver.fancysitula.commands;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoUpdatePacket;
import de.oliver.fancysitula.api.utils.FS_GameProfile;
import de.oliver.fancysitula.api.utils.FS_GameType;
import de.oliver.fancysitula.factories.FancySitula;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class FancySitulaCMD extends Command {

    public FancySitulaCMD() {
        super("fancysitula");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage("You must be a player to execute this command!");
            return true;
        }

        FS_Player fsPlayer = FancySitula.PLAYER_FACTORY.createPlayer(p, FS_GameProfile.fromBukkit(p.getPlayerProfile()));

        FS_GameProfile fakeProfile = new FS_GameProfile(UUID.randomUUID(), "FakePlayer");
        FS_Player fakePlayer = FancySitula.PLAYER_FACTORY.createPlayer(null, fakeProfile);

        FS_ClientboundPlayerInfoUpdatePacket.Entry entry = new FS_ClientboundPlayerInfoUpdatePacket.Entry(
                fakePlayer,
                fakeProfile.getUUID(),
                fakeProfile,
                true,
                42,
                FS_GameType.SURVIVAL,
                Component.text("FakePlayer1123")
        );

        EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions = EnumSet.of(FS_ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER);
        actions.add(FS_ClientboundPlayerInfoUpdatePacket.Action.UPDATE_DISPLAY_NAME);
        actions.add(FS_ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LISTED);

        FancySitula.PACKET_FACTORY
                .createPlayerInfoUpdatePacket(actions, List.of(entry))
                .send(fsPlayer);

        FancySitula.PACKET_FACTORY
                .createAddEntityPacket(
                        420,
                        fakeProfile.getUUID(),
                        EntityType.PLAYER,
                        p.getLocation().getX(),
                        p.getLocation().getY(),
                        p.getLocation().getZ(),
                        p.getLocation().getYaw(),
                        p.getLocation().getPitch(),
                        0,
                        0,
                        0,
                        0,
                        0
                )
                .send(fsPlayer);

        return true;
    }
}
