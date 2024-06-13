package de.oliver.fancysitula.api.utils.entityData;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;

public enum TextDisplayData {
    /**
     * Use {@link net.kyori.adventure.text.Component} as value
     */
    TEXT(new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_TEXT_ID")),

    /**
     * Use {@link Integer} as value
     */
    LINE_WIDTH(new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_LINE_WIDTH_ID")),

    /**
     * Use {@link Integer} as value
     */
    BACKGROUND(new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_BACKGROUND_COLOR_ID")),

    /**
     * Use {@link Byte} as value
     */
    TEXT_OPACITY(new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_TEXT_OPACITY_ID")),

    /**
     * Use {@link Byte} as value
     */
    STYLE_FLAGS(new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$TextDisplay", "DATA_STYLE_FLAGS_ID")),
    ;

    private final FS_ClientboundSetEntityDataPacket.EntityDataAccessor accessor;

    TextDisplayData(FS_ClientboundSetEntityDataPacket.EntityDataAccessor accessor) {
        this.accessor = accessor;
    }

    public FS_ClientboundSetEntityDataPacket.EntityDataAccessor get() {
        return accessor;
    }
}
