package de.oliver.fancysitula.api.entities;

import de.oliver.fancysitula.api.packets.FS_ClientboundPacket;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a real player
 */
public class FS_RealPlayer {

    @NotNull
    private final Player bukkitPlayer;

    /**
     * Creates a new FS_RealPlayer instance
     * Must have a real bukkit player instance
     * Used for sending packets to the player
     *
     * @param bukkitPlayer the bukkit player instance
     */
    public FS_RealPlayer(@NotNull Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
    }

    /**
     * Sends a packet to the player
     * Must have a real bukkit player instance
     *
     * @param packet the packet to send
     */
    public void sendPacket(FS_ClientboundPacket packet) {
        packet.send(this);
    }

    public @NotNull Player getBukkitPlayer() {
        return bukkitPlayer;
    }

}
