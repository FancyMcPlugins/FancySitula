package de.oliver.fancysitula.versions.v1_20_6.utils;

import net.minecraft.server.level.ServerPlayer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class VanillaPlayerAdapter {

    public static ServerPlayer asVanilla(Player p) {
        return ((CraftPlayer) p).getHandle();
    }
}
