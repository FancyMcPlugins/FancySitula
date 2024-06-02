package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.entities.FS_Player;

public interface FS_ClientboundPacket {
    void send(FS_Player player);
}
