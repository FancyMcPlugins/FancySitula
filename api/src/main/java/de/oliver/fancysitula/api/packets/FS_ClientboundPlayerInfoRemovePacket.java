package de.oliver.fancysitula.api.packets;

import java.util.List;
import java.util.UUID;

/**
 * Used to remove players from the client's player list.
 */
public abstract class FS_ClientboundPlayerInfoRemovePacket implements FS_ClientboundPacket {

    protected List<UUID> uuids;

    public FS_ClientboundPlayerInfoRemovePacket(List<UUID> uuids) {
        this.uuids = uuids;
    }

    public List<UUID> getUuids() {
        return uuids;
    }

    public void setUuids(List<UUID> uuids) {
        this.uuids = uuids;
    }
}
