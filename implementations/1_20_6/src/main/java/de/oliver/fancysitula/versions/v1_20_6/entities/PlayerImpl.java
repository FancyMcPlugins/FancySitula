package de.oliver.fancysitula.versions.v1_20_6.entities;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.utils.FS_GameProfile;
import de.oliver.fancysitula.versions.v1_20_6.utils.GameProfileImpl;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerImpl extends FS_Player {

    private ServerPlayer vanillaPlayer;

    public PlayerImpl(Player bukkitPlayer, FS_GameProfile gameProfile) {
        super(bukkitPlayer, gameProfile);

        this.vanillaPlayer = asVanilla(bukkitPlayer);
    }

    public PlayerImpl(Player bukkitPlayer) {
        super(bukkitPlayer, GameProfileImpl.fromBukkit(bukkitPlayer.getPlayerProfile()));

        this.vanillaPlayer = asVanilla(bukkitPlayer);
    }

    public PlayerImpl(ServerPlayer vanillaPlayer) {
        super(vanillaPlayer.getBukkitEntity(), GameProfileImpl.fromVanilla(vanillaPlayer.getGameProfile()));

        this.vanillaPlayer = vanillaPlayer;
    }

    public static ServerPlayer asVanilla(Player bukkitPlayer) {
        if (bukkitPlayer == null) {
            return null;
        }

        return ((CraftPlayer) bukkitPlayer).getHandle();
    }

    public ServerPlayer getVanillaPlayer() {
        return vanillaPlayer;
    }
}
