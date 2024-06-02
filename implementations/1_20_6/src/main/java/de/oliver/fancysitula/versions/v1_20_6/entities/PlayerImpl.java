package de.oliver.fancysitula.versions.v1_20_6.entities;

import de.oliver.fancysitula.api.entities.FS_Player;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerImpl extends FS_Player {

    private final ServerPlayer vanillaPlayer;

    public PlayerImpl(Player bukkitPlayer) {
        super(bukkitPlayer);

        this.vanillaPlayer = asVanilla(bukkitPlayer);
    }

    public static ServerPlayer asVanilla(Player bukkitPlayer) {
        return ((CraftPlayer) bukkitPlayer).getHandle();
    }

    public ServerPlayer getVanillaPlayer() {
        return vanillaPlayer;
    }
}
