package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.entities.FS_Player;

public interface FS_ClientboundPacket {
    Object createPacket();

    void send(FS_Player player);
}
