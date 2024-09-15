package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import org.jetbrains.annotations.ApiStatus;

public abstract class FS_ClientboundPacket {

    protected static boolean enableDebugLogs = false;

    /**
     * Enables debug logs for all packets.
     */
    public static void enableDebugLogs() {
        enableDebugLogs = true;
    }

    /**
     * Creates the packet object.
     * For internal use only.
     */
    @ApiStatus.Internal
    public abstract Object createPacket();

    /**
     * Sends the packet to the player.
     * For internal use only.
     */
    @ApiStatus.Internal
    protected abstract void sendPacketTo(FS_RealPlayer player);

    /**
     * Sends the packet to the player.
     */
    public final void send(FS_RealPlayer player) {
        if (enableDebugLogs) {
            System.out.println("Sending packet '" + this.getClass().getSimpleName() + "' to " + player.getBukkitPlayer().getName());
        }

        sendPacketTo(player);
    }
}
