package de.oliver.fancysitula.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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

        p.sendMessage("Hello, " + p.getName() + "!");
        return true;
    }
}
