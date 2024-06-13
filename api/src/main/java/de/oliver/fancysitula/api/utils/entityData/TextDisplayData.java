package de.oliver.fancysitula.api.utils.entityData;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;

public class TextDisplayData {

    /**
     * Use {@link net.kyori.adventure.text.Component} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor TEXT = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_TEXT_ID");

    /**
     * Use {@link Integer} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor LINE_WIDTH = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_LINE_WIDTH_ID");

    /**
     * Use {@link Integer} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor BACKGROUND = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_BACKGROUND_COLOR_ID");

    /**
     * Use {@link Byte} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor TEXT_OPACITY = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_TEXT_OPACITY_ID");

    /**
     * Use {@link Byte} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor STYLE_FLAGS = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_STYLE_FLAGS_ID");
}
