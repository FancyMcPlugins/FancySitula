package de.oliver.fancysitula.api.utils.entityData;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;

public class FS_BlockDisplayData {

    /**
     * Use {@link org.bukkit.block.Block} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor BLOCK = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$BlockDisplay", "DATA_BLOCK_STATE_ID");

}
