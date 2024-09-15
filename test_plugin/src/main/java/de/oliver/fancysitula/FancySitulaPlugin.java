package de.oliver.fancysitula;

import de.oliver.fancyanalytics.logger.LogLevel;
import de.oliver.fancysitula.api.IFancySitula;
import de.oliver.fancysitula.commands.FancySitulaCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class FancySitulaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        IFancySitula.LOGGER.setCurrentLevel(LogLevel.DEBUG);

        getServer().getCommandMap().register("fancysitula", new FancySitulaCMD());
    }
}
