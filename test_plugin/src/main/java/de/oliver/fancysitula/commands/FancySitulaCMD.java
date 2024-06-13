package de.oliver.fancysitula.commands;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;
import de.oliver.fancysitula.api.utils.FS_GameProfile;
import de.oliver.fancysitula.api.utils.entityData.TextDisplayData;
import de.oliver.fancysitula.factories.FancySitula;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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

        // Wrap the real player into an FS_Player instance
        FS_RealPlayer fsPlayer = new FS_RealPlayer(p);

        // Create a fake player
        FS_GameProfile fakeProfile = new FS_GameProfile(UUID.randomUUID(), "FakePlayer");

        // PlayerInfoUpdatePacket
//        FS_ClientboundPlayerInfoUpdatePacket.Entry entry = new FS_ClientboundPlayerInfoUpdatePacket.Entry(
//                fakeProfile.getUUID(),
//                fakeProfile,
//                true,
//                42,
//                FS_GameType.SURVIVAL,
//                Component.text("FakePlayer1123")
//        );
//
//        EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions = EnumSet.of(FS_ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER);
//        actions.add(FS_ClientboundPlayerInfoUpdatePacket.Action.UPDATE_DISPLAY_NAME);
//        actions.add(FS_ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LISTED);
//
//        FancySitula.PACKET_FACTORY
//                .createPlayerInfoUpdatePacket(actions, List.of(entry))
//                .send(fsPlayer);

        // AddEntityPacket
        FancySitula.PACKET_FACTORY
                .createAddEntityPacket(
                        420,
                        fakeProfile.getUUID(),
                        EntityType.TEXT_DISPLAY,
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


        FancySitula.PACKET_FACTORY
                .createSetEntityDataPacket(
                        420,
                        List.of(
                                new FS_ClientboundSetEntityDataPacket.EntityData(
                                        TextDisplayData.TEXT.get(),
                                        Component.text("Hello world")
                                ),
                                new FS_ClientboundSetEntityDataPacket.EntityData(
                                        TextDisplayData.BACKGROUND.get(),
                                        0xFF00FF00
                                )
                        )
                )
                .send(fsPlayer);
        return true;
    }
}
