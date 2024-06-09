package de.oliver.fancysitula.factories;

import de.oliver.fancysitula.api.packets.FS_ClientboundAddEntityPacket;
import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoRemovePacket;
import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoUpdatePacket;
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
     */
    public FS_ClientboundPlayerInfoUpdatePacket createPlayerInfoUpdatePacket(
            ServerVersion serverVersion, EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions,
            List<FS_ClientboundPlayerInfoUpdatePacket.Entry> entries) {
        switch (serverVersion) {
            case v1_20_6 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundPlayerInfoUpdatePacketImpl(actions, entries);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoUpdatePacket instance based on the current server version
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
            case v1_20_6 -> {
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
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(ServerVersion serverVersion, List<UUID> uuids) {
        switch (serverVersion) {
            case v1_20_6 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundPlayerInfoRemovePacketImpl(uuids);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the current server version
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(List<UUID> uuids) {
        return createPlayerInfoRemovePacket(ServerVersion.getCurrentVersion(), uuids);
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the server version
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(ServerVersion serverVersion, UUID uuid) {
        return createPlayerInfoRemovePacket(serverVersion, List.of(uuid));
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoRemovePacket instance based on the current server version
     */
    public FS_ClientboundPlayerInfoRemovePacket createPlayerInfoRemovePacket(UUID uuid) {
        return createPlayerInfoRemovePacket(ServerVersion.getCurrentVersion(), uuid);
    }
}
