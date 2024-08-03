package de.oliver.fancysitula.api.utils.entityData;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;

public class FS_ItemDisplayData {

    /**
     * Use {@link org.bukkit.inventory.ItemStack} as value
     */
    public static final FS_ClientboundSetEntityDataPacket.EntityDataAccessor ITEM = new FS_ClientboundSetEntityDataPacket.EntityDataAccessor("net.minecraft.world.entity.Display$ItemDisplay", "DATA_ITEM_STACK_ID");

}
