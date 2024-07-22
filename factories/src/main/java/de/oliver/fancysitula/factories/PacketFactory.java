package de.oliver.fancysitula.factories;

import de.oliver.fancysitula.api.packets.*;
import de.oliver.fancysitula.api.utils.ServerVersion;
import org.bukkit.entity.EntityType;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

/**
 * Factory class for creating packet instances based on the server version
 */
public class PacketFactory {

    /**
     * Creates a new FS_ClientboundPlayerInfoUpdatePacket instance based on the server version
     *
     * @param actions EnumSet of {@link FS_ClientboundPlayerInfoUpdatePacket.Action} to perform
     * @param entries List of {@link FS_ClientboundPlayerInfoUpdatePacket.Entry} to update
     */
    public FS_ClientboundPlayerInfoUpdatePacket createPlayerInfoUpdatePacket(
            ServerVersion serverVersion, EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions,
            List<FS_ClientboundPlayerInfoUpdatePacket.Entry> entries) {
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundPlayerInfoUpdatePacketImpl(actions, entries);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoUpdatePacket instance based on the current server version
     *
     * @param actions EnumSet of {@link FS_ClientboundPlayerInfoUpdatePacket.Action} to perform
     * @param entries List of {@link FS_ClientboundPlayerInfoUpdatePacket.Entry} to update
     */
    public FS_ClientboundPlayerInfoUpdatePacket createPlayerInfoUpdatePacket(
            EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions,
            List<FS_ClientboundPlayerInfoUpdatePacket.Entry> entries) {
        return createPlayerInfoUpdatePacket(ServerVersion.getCurrentVersion(), actions, entries);
    }

    /**
     * Creates a new FS_ClientboundAddEntityPacket instance based on the server version
     *
     * @param yaw     in degrees (0 - 360)
     * @param pitch   in degrees (0 - 360)
     * @param headYaw in degrees (0 - 360)
     */
    public FS_ClientboundAddEntityPacket createAddEntityPacket(
            ServerVersion serverVersion,
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
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundAddEntityPacketImpl(entityId, entityUUID, entityType, x, y, z, yaw, pitch, headYaw, velocityX, velocityY, velocityZ, data);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundAddEntityPacket instance based on the current server version
     *
     * @param yaw     in degrees (0 - 360)
     * @param pitch   in degrees (0 - 360)
     * @param headYaw in degrees (0 - 360)
     */
    public FS_ClientboundAddEntityPacket createAddEntityPacket(
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
        return createAddEntityPacket(ServerVersion.getCurrentVersion(), entityId, entityUUID, entityType, x, y, z, yaw, pitch, headYaw, velocityX, velocityY, velocityZ, data);
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the server version
     *
     * @param uuids UUIDs of the players to remove
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(ServerVersion serverVersion, List<UUID> uuids) {
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundPlayerInfoRemovePacketImpl(uuids);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the current server version
     *
     * @param uuids UUIDs of the players to remove
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(List<UUID> uuids) {
        return createPlayerInfoRemovePacket(ServerVersion.getCurrentVersion(), uuids);
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the server version
     *
     * @param uuid UUID of the player to remove
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(ServerVersion serverVersion, UUID uuid) {
        return createPlayerInfoRemovePacket(serverVersion, List.of(uuid));
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the current server version
     *
     * @param uuid UUID of the player to remove
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(UUID uuid) {
        return createPlayerInfoRemovePacket(ServerVersion.getCurrentVersion(), uuid);
    }

    /**
     * Creates a new FS_ClientboundRemoveEntitiesPacket instance based on the server version
     *
     * @param entityIds IDs of the entities to remove
     */
    public FS_ClientboundRemoveEntitiesPacket createRemoveEntitiesPacket(ServerVersion serverVersion, List<Integer> entityIds) {
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundRemoveEntitiesPacketImpl(entityIds);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundRemoveEntitiesPacket instance based on the current server version
     *
     * @param entityIds IDs of the entities to remove
     */
    public FS_ClientboundRemoveEntitiesPacket createRemoveEntitiesPacket(List<Integer> entityIds) {
        return createRemoveEntitiesPacket(ServerVersion.getCurrentVersion(), entityIds);
    }

    /**
     * Creates a new FS_ClientboundTeleportEntityPacket instance based on the server version
     *
     * @param entityId ID of the entity to teleport
     * @param x        X coordinate
     * @param y        Y coordinate
     * @param z        Z coordinate
     * @param yaw      Yaw in degrees (0 - 360)
     * @param pitch    Pitch in degrees (0 - 360)
     * @param onGround Whether the entity is on the ground
     */
    public FS_ClientboundTeleportEntityPacket createTeleportEntityPacket(
            ServerVersion serverVersion,
            int entityId,
            double x,
            double y,
            double z,
            float yaw,
            float pitch,
            boolean onGround
    ) {
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundTeleportEntityPacketImpl(entityId, x, y, z, yaw, pitch, onGround);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundTeleportEntityPacket instance based on the current server version
     *
     * @param entityId ID of the entity to teleport
     * @param x        X coordinate
     * @param y        Y coordinate
     * @param z        Z coordinate
     * @param yaw      Yaw in degrees (0 - 360)
     * @param pitch    Pitch in degrees (0 - 360)
     * @param onGround Whether the entity is on the ground
     */
    public FS_ClientboundTeleportEntityPacket createTeleportEntityPacket(
            int entityId,
            double x,
            double y,
            double z,
            float yaw,
            float pitch,
            boolean onGround
    ) {
        return createTeleportEntityPacket(ServerVersion.getCurrentVersion(), entityId, x, y, z, yaw, pitch, onGround);
    }

    /**
     * Creates a new FS_ClientboundRotateHeadPacket instance based on the server version
     *
     * @param entityId ID of the entity to rotate the head of
     * @param headYaw  Yaw of the head in degrees (0 - 360)
     */
    public FS_ClientboundRotateHeadPacket createRotateHeadPacket(ServerVersion serverVersion, int entityId, float headYaw) {
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundRotateHeadPacketImpl(entityId, headYaw);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundRotateHeadPacket instance based on the current server version
     *
     * @param entityId ID of the entity to rotate the head of
     * @param headYaw  Yaw of the head in degrees (0 - 360)
     */
    public FS_ClientboundRotateHeadPacket createRotateHeadPacket(int entityId, float headYaw) {
        return createRotateHeadPacket(ServerVersion.getCurrentVersion(), entityId, headYaw);
    }

    /**
     * Creates a new FS_ClientboundSetEntityDataPacket instance based on the server version
     *
     * @param entityId   ID of the entity to set the data of
     * @param entityData List of {@link FS_ClientboundSetEntityDataPacket.EntityData} to set
     */
    public FS_ClientboundSetEntityDataPacket createSetEntityDataPacket(
            ServerVersion serverVersion, int entityId, List<FS_ClientboundSetEntityDataPacket.EntityData> entityData) {
        switch (serverVersion) {
            case v1_20_6, v1_21 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundSetEntityDataPacketImpl(entityId, entityData);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundSetEntityDataPacket instance based on the current server version
     *
     * @param entityId   ID of the entity to set the data of
     * @param entityData List of {@link FS_ClientboundSetEntityDataPacket.EntityData} to set
     */
    public FS_ClientboundSetEntityDataPacket createSetEntityDataPacket(int entityId, List<FS_ClientboundSetEntityDataPacket.EntityData> entityData) {
        return createSetEntityDataPacket(ServerVersion.getCurrentVersion(), entityId, entityData);
    }
}
