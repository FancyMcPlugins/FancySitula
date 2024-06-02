package de.oliver.fancysitula.api.entities;

import de.oliver.fancysitula.api.packets.FS_ClientboundPacket;
import org.bukkit.entity.Player;

/**
 * Represents a player
 */
public abstract class FS_Player {

    protected Player bukkitPlayer;

    public FS_Player(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }

    public void sendPacket(FS_ClientboundPacket packet) {
        packet.send(this);
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }
}
