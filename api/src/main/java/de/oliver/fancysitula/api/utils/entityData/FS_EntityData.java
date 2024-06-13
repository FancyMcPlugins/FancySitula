package de.oliver.fancysitula.api.utils.entityData;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;

public class FS_EntityData {

    /**
     * Use {@link Byte} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor SHARED_FLAGS = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_SHARED_FLAGS_ID");

    /**
     * Use {@link Integer} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor AIR_SUPPLY = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_AIR_SUPPLY_ID");

    /**
     * Use {@link java.util.Optional<net.kyori.adventure.text.Component>} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor CUSTOM_NAME = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_CUSTOM_NAME");

    /**
     * Use {@link Boolean} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor CUSTOM_NAME_VISIBLE = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_CUSTOM_NAME_VISIBLE");

    /**
     * Use {@link Boolean} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor SILENT = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_SILENT");

    /**
     * Use {@link Boolean} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor NO_GRAVITY = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_NO_GRAVITY");

    // TODO: Add DATA_POSE

    /**
     * Use {@link Integer} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor TICKS_FROZEN = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Entity", "DATA_TICKS_FROZEN");

}

