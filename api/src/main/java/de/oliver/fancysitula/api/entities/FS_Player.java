package de.oliver.fancysitula.api.entities;

import de.oliver.fancysitula.api.packets.FS_ClientboundPacket;
import de.oliver.fancysitula.api.utils.FS_GameProfile;
import org.bukkit.entity.Player;

/**
 * Represents a player
 */
public abstract class FS_Player {

    protected Player bukkitPlayer;
    protected FS_GameProfile gameProfile;

    public FS_Player(Player bukkitPlayer, FS_GameProfile gameProfile) {
        this.bukkitPlayer = bukkitPlayer;
        this.gameProfile = gameProfile;
    }

    public void sendPacket(FS_ClientboundPacket packet) {
        packet.send(this);
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }

    public FS_GameProfile getGameProfile() {
        return gameProfile;
    }
}
