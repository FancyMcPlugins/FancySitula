package de.oliver.fancysitula;

import de.oliver.fancysitula.api.packets.FS_ClientboundPacket;
import de.oliver.fancysitula.commands.FancySitulaCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class FancySitulaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        FS_ClientboundPacket.enableDebugLogs();

        getServer().getCommandMap().register("fancysitula", new FancySitulaCMD());
    }
}
