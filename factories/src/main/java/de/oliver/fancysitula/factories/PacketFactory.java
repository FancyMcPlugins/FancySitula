package de.oliver.fancysitula.factories;

import de.oliver.fancysitula.api.packets.*;
import de.oliver.fancysitula.api.utils.FS_EquipmentSlot;
import de.oliver.fancysitula.api.utils.ServerVersion;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
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

    /**
     * Creates a new FS_ClientboundSetEquipmentPacket instance based on the server version
     *
     * @param entityId  ID of the entity to set the equipment of
     * @param equipment Map of {@link org.bukkit.inventory.EquipmentSlot} and {@link org.bukkit.inventory.ItemStack} to set
     */
    public FS_ClientboundSetEquipmentPacket createSetEquipmentPacket(ServerVersion serverVersion, int entityId, Map<FS_EquipmentSlot, ItemStack> equipment) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundSetEquipmentPacketImpl(entityId, equipment);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundSetEquipmentPacket instance based on the current server version
     *
     * @param entityId  ID of the entity to set the equipment of
     * @param equipment Map of {@link org.bukkit.inventory.EquipmentSlot} and {@link org.bukkit.inventory.ItemStack} to set
     */
    public FS_ClientboundSetEquipmentPacket createSetEquipmentPacket(int entityId, Map<FS_EquipmentSlot, ItemStack> equipment) {
        return createSetEquipmentPacket(ServerVersion.getCurrentVersion(), entityId, equipment);
    }

    /**
     * Creates a new FS_ClientboundSetPassengersPacket instance based on the server version
     *
     * @param entityId   ID of the vehicle entity
     * @param passengers List of entity IDs to set as passengers
     */
    public FS_ClientboundSetPassengersPacket createSetPassengersPacket(
            ServerVersion serverVersion, int entityId, List<Integer> passengers) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundSetPassengersPacketImpl(entityId, passengers);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundSetPassengersPacket instance based on the current server version
     *
     * @param entityId   ID of the vehicle entity
     * @param passengers List of entity IDs to set as passengers
     */
    public FS_ClientboundSetPassengersPacket createSetPassengersPacket(int entityId, List<Integer> passengers) {
        return createSetPassengersPacket(ServerVersion.getCurrentVersion(), entityId, passengers);
    }


    /**
     * Creates and returns a FS_ClientboundCreateOrUpdateTeamPacket based on the given server version and team information.
     *
     * @param serverVersion the version of the server for which the packet is to be created
     * @param teamName      the name of the team to be created or updated
     * @param createTeam    an instance of FS_ClientboundCreateOrUpdateTeamPacket.CreateTeam containing the team creation or update details
     * @return a FS_ClientboundCreateOrUpdateTeamPacket instance corresponding to the specified server version and team details
     * @throws IllegalArgumentException if the provided server version is not supported
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(ServerVersion serverVersion, String teamName, FS_ClientboundCreateOrUpdateTeamPacket.CreateTeam createTeam) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundCreateOrUpdateTeamPacketImpl(teamName, createTeam);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates an FS_ClientboundCreateOrUpdateTeamPacket for the given team name and creation details.
     *
     * @param teamName   The name of the team to create or update.
     * @param createTeam The details of the team creation or update.
     * @return An instance of FS_ClientboundCreateOrUpdateTeamPacket containing the creation or update details.
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(String teamName, FS_ClientboundCreateOrUpdateTeamPacket.CreateTeam createTeam) {
        return createCreateOrUpdateTeamPacket(ServerVersion.getCurrentVersion(), teamName, createTeam);
    }

    /**
     * Creates a packet for creating or updating a team based on the specified server version.
     *
     * @param serverVersion The version of the server.
     * @param teamName      The name of the team.
     * @param removeTeam    Information about whether to remove the team.
     * @return The packet for creating or updating the team.
     * @throws IllegalArgumentException if the server version is unsupported.
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(ServerVersion serverVersion, String teamName, FS_ClientboundCreateOrUpdateTeamPacket.RemoveTeam removeTeam) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundCreateOrUpdateTeamPacketImpl(teamName, removeTeam);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a packet to create or update a team with the specified name and removal flag.
     *
     * @param teamName   the name of the team to create or update
     * @param removeTeam the flag indicating whether to remove the team
     * @return a packet for creating or updating the team
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(String teamName, FS_ClientboundCreateOrUpdateTeamPacket.RemoveTeam removeTeam) {
        return createCreateOrUpdateTeamPacket(ServerVersion.getCurrentVersion(), teamName, removeTeam);
    }

    /**
     * Creates an instance of FS_ClientboundCreateOrUpdateTeamPacket based on the provided server version.
     *
     * @param serverVersion The server version for which the packet should be created.
     * @param teamName      The name of the team that is being created or updated.
     * @param updateTeam    The update team details which contain information about the team.
     * @return A new instance of FS_ClientboundCreateOrUpdateTeamPacket tailored for the specified server version.
     * @throws IllegalArgumentException If the provided server version is not supported.
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(ServerVersion serverVersion, String teamName, FS_ClientboundCreateOrUpdateTeamPacket.UpdateTeam updateTeam) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundCreateOrUpdateTeamPacketImpl(teamName, updateTeam);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundCreateOrUpdateTeamPacket for creating or updating a team.
     *
     * @param teamName   the name of the team to be created or updated
     * @param updateTeam the update information for the team
     * @return a new instance of FS_ClientboundCreateOrUpdateTeamPacket
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(String teamName, FS_ClientboundCreateOrUpdateTeamPacket.UpdateTeam updateTeam) {
        return createCreateOrUpdateTeamPacket(ServerVersion.getCurrentVersion(), teamName, updateTeam);
    }

    /**
     * Creates a new instance of FS_ClientboundCreateOrUpdateTeamPacket based on the given server version, team name, and addEntity parameters.
     *
     * @param serverVersion the version of the server for which the packet will be created
     * @param teamName      the name of the team to be created or updated
     * @param addEntity     the add entity information needed for packet creation
     * @return an instance of FS_ClientboundCreateOrUpdateTeamPacket appropriate for the specified server version
     * @throws IllegalArgumentException if the server version is not supported
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(ServerVersion serverVersion, String teamName, FS_ClientboundCreateOrUpdateTeamPacket.AddEntity addEntity) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundCreateOrUpdateTeamPacketImpl(teamName, addEntity);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a packet for creating or updating a team with the specified name and entity.
     *
     * @param teamName  the name of the team to create or update
     * @param addEntity the entity representing the addition details for the team
     * @return the packet representing the create or update operation on the team
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(String teamName, FS_ClientboundCreateOrUpdateTeamPacket.AddEntity addEntity) {
        return createCreateOrUpdateTeamPacket(ServerVersion.getCurrentVersion(), teamName, addEntity);
    }

    /**
     * Creates an instance of FS_ClientboundCreateOrUpdateTeamPacket based on the server version.
     *
     * @param serverVersion The version of the server.
     * @param teamName      The name of the team to create or update.
     * @param removeEntity  The entity removal configuration for the packet.
     * @return A new instance of FS_ClientboundCreateOrUpdateTeamPacket for the specified server version.
     * @throws IllegalArgumentException If the server version is unsupported.
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(ServerVersion serverVersion, String teamName, FS_ClientboundCreateOrUpdateTeamPacket.RemoveEntity removeEntity) {
        switch (serverVersion) {
            case v1_20_5, v1_20_6, v1_21, v1_21_1, v1_21_2, v1_21_3 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundCreateOrUpdateTeamPacketImpl(teamName, removeEntity);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a packet for creating or updating a team with the specified name and entity removal configuration.
     *
     * @param teamName     the name of the team to create or update
     * @param removeEntity the entity removal configuration for the team
     * @return the packet for creating or updating the team
     */
    public FS_ClientboundCreateOrUpdateTeamPacket createCreateOrUpdateTeamPacket(String teamName, FS_ClientboundCreateOrUpdateTeamPacket.RemoveEntity removeEntity) {
        return createCreateOrUpdateTeamPacket(ServerVersion.getCurrentVersion(), teamName, removeEntity);
    }
}
