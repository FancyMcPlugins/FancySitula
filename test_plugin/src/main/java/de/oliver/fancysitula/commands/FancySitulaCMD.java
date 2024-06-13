package de.oliver.fancysitula.commands;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import de.oliver.fancysitula.api.entities.FS_TextDisplay;
import de.oliver.fancysitula.factories.FancySitula;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

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

        FS_TextDisplay fakeTextDisplay = new FS_TextDisplay();
        fakeTextDisplay.setBillboardRenderConstraints((byte) 3);
        fakeTextDisplay.setScale(new Vector3f(5f));
        fakeTextDisplay.setLocation(p.getLocation());
        fakeTextDisplay.setText(Component.text("Hello, World!"));
        fakeTextDisplay.setBackground(0xFF00C8FF);

        FancySitula.ENTITY_FACTORY.spawnEntityFor(fsPlayer, fakeTextDisplay);

        return true;
    }
}
