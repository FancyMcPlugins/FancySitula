package de.oliver.fancysitula.api.packets;

public abstract class FS_ClientboundRotateHeadPacket implements FS_ClientboundPacket {

    protected int entityId;
    protected float headYaw;

    public FS_ClientboundRotateHeadPacket(int entityId, float headYaw) {
        this.entityId = entityId;
        this.headYaw = headYaw;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public float getHeadYaw() {
        return headYaw;
    }

    public void setHeadYaw(float headYaw) {
        this.headYaw = headYaw;
    }
}
