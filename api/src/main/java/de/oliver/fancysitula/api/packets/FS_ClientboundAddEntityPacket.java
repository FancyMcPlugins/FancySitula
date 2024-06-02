package de.oliver.fancysitula.api.packets;

import org.bukkit.entity.EntityType;

import java.util.UUID;

public abstract class FS_ClientboundAddEntityPacket implements FS_ClientboundPacket {

    protected int entityId;
    protected UUID entityUUID;
    protected EntityType entityType;

    protected double x;
    protected double y;
    protected double z;

    protected float yaw;
    protected float pitch;
    protected float headYaw;

    protected int velocityX;
    protected int velocityY;
    protected int velocityZ;

    protected int data;

    /**
     * @param pitch   in degrees (0 - 360)
     * @param headYaw in degrees (0 - 360)
     */
    public FS_ClientboundAddEntityPacket(
            int entityId,
            UUID entityUUID,
            EntityType entityType,
            double x,
            double y,
            double z,
            float yaw,
            float pitch,
            float headYaw,
            int velocityX,
            int velocityY,
            int velocityZ,
            int data) {
        this.entityId = entityId;
        this.entityUUID = entityUUID;
        this.entityType = entityType;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.headYaw = headYaw;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        this.data = data;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public UUID getEntityUUID() {
        return entityUUID;
    }

    public void setEntityUUID(UUID entityUUID) {
        this.entityUUID = entityUUID;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getHeadYaw() {
        return headYaw;
    }

    public void setHeadYaw(float headYaw) {
        this.headYaw = headYaw;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public int getVelocityZ() {
        return velocityZ;
    }

    public void setVelocityZ(int velocityZ) {
        this.velocityZ = velocityZ;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
