package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;

public interface FS_ClientboundPacket {
    Object createPacket();

    void send(FS_RealPlayer player);
}
