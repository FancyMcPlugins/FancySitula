package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import org.jetbrains.annotations.ApiStatus;

public interface FS_ClientboundPacket {

    /**
     * Creates the packet object.
     * For internal use only.
     */
    @ApiStatus.Internal
    Object createPacket();

    /**
     * Sends the packet to the player.
     *
     * @param player the player to send the packet to
     */
    void send(FS_RealPlayer player);
}
