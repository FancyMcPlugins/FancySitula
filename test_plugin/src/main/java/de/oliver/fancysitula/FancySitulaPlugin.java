package de.oliver.fancysitula;

import de.oliver.fancysitula.commands.FancySitulaCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class FancySitulaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("fancysitula", new FancySitulaCMD());
    }
}
