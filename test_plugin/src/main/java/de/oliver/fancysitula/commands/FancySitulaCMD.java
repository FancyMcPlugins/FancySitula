package de.oliver.fancysitula.commands;

import de.oliver.fancysitula.api.entities.FS_BlockDisplay;
import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoUpdatePacket;
import de.oliver.fancysitula.api.utils.FS_GameProfile;
import de.oliver.fancysitula.api.utils.FS_GameType;
import de.oliver.fancysitula.factories.FancySitula;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

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

        // Wrap the real player into an FS_Player instance
        FS_RealPlayer fsPlayer = new FS_RealPlayer(p);

//        FS_TextDisplay fakeTextDisplay = new FS_TextDisplay();
//        fakeTextDisplay.setBillboardRenderConstraints((byte) 3);
//        fakeTextDisplay.setScale(new Vector3f(5f));
//        fakeTextDisplay.setLocation(p.getLocation());
//        fakeTextDisplay.setText(Component.text("Hello, World!"));
//        fakeTextDisplay.setBackground(0xFF00C8FF);
//        FancySitula.ENTITY_FACTORY.spawnEntityFor(fsPlayer, fakeTextDisplay);

//        FS_ItemDisplay fakeItemDisplay = new FS_ItemDisplay();
//        fakeItemDisplay.setBillboardRenderConstraints((byte) 3);
//        fakeItemDisplay.setScale(new Vector3f(5f));
//        fakeItemDisplay.setLocation(p.getLocation());
//        fakeItemDisplay.setItem(p.getInventory().getItemInMainHand());
//        FancySitula.ENTITY_FACTORY.spawnEntityFor(fsPlayer, fakeItemDisplay);

        FS_BlockDisplay fakeBlockDisplay = new FS_BlockDisplay();
        fakeBlockDisplay.setBillboardRenderConstraints((byte) 3);
        fakeBlockDisplay.setScale(new Vector3f(5f));
        fakeBlockDisplay.setLocation(p.getLocation());
        fakeBlockDisplay.setBlock(Material.DIAMOND_BLOCK.createBlockData().createBlockState());
        FancySitula.ENTITY_FACTORY.spawnEntityFor(fsPlayer, fakeBlockDisplay);

        return true;
    }

    private void fakeTablistEntries(Player to) {
// Wrap the real player into an FS_Player instance
        FS_RealPlayer fsPlayer = new FS_RealPlayer(to);


        UUID uuid1 = UUID.randomUUID();
        FS_ClientboundPlayerInfoUpdatePacket.Entry entry1 = new FS_ClientboundPlayerInfoUpdatePacket.Entry(
                uuid1,
                new FS_GameProfile(uuid1, ""),
                true,
                69,
                FS_GameType.SURVIVAL,
                Component.text("player1")
        );

        UUID uuid2 = UUID.randomUUID();
        FS_ClientboundPlayerInfoUpdatePacket.Entry entry2 = new FS_ClientboundPlayerInfoUpdatePacket.Entry(
                uuid2,
                new FS_GameProfile(uuid2, ""),
                true,
                69,
                FS_GameType.SURVIVAL,
                Component.text("player2")
        );

        FS_ClientboundPlayerInfoUpdatePacket playerInfoUpdatePacket = FancySitula.PACKET_FACTORY.createPlayerInfoUpdatePacket(
                EnumSet.of(FS_ClientboundPlayerInfoUpdatePacket.Action.ADD_PLAYER, FS_ClientboundPlayerInfoUpdatePacket.Action.UPDATE_LISTED, FS_ClientboundPlayerInfoUpdatePacket.Action.UPDATE_DISPLAY_NAME),
                List.of(entry1, entry2)
        );
        playerInfoUpdatePacket.send(fsPlayer);
    }
}
