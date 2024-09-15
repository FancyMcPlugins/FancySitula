package de.oliver.fancysitula.api.packets;

import java.util.List;

/**
 * Used to remove entities from the client's world.
 */
public abstract class FS_ClientboundRemoveEntitiesPacket extends FS_ClientboundPacket {

    protected List<Integer> entityIds;

    /**
     * @param entityIds IDs of the entities to remove
     */
    public FS_ClientboundRemoveEntitiesPacket(List<Integer> entityIds) {
        this.entityIds = entityIds;
    }

    public List<Integer> getEntityIds() {
        return entityIds;
    }

    public void setEntityIds(List<Integer> entityIds) {
        this.entityIds = entityIds;
    }
}
