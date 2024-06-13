package de.oliver.fancysitula.api.packets;

import java.util.List;

public abstract class FS_ClientboundSetEntityDataPacket implements FS_ClientboundPacket {

    protected int entityId;
    protected List<EntityData> entityData;

    public FS_ClientboundSetEntityDataPacket(int entityId, List<EntityData> entityData) {
        this.entityId = entityId;
        this.entityData = entityData;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public List<EntityData> getEntityData() {
        return entityData;
    }

    public void setEntityData(List<EntityData> entityData) {
        this.entityData = entityData;
    }

    /**
     * @param accessor can be found in {@link de.oliver.fancysitula.api.utils.entityData}
     * @param value    must be the correct type for the accessor (see accessor javadoc)
     */
    public record EntityData(EntityDataAccessor accessor, Object value) {
    }

    /**
     * @param entityClassName   the class name of the entity (e.g. "net.minecraft.world.entity.Display$TextDisplay")
     * @param accessorFieldName the field name of the accessor (typically starts with "DATA_" and ends with "_ID")
     */
    public record EntityDataAccessor(String entityClassName, String accessorFieldName) {
    }
}
