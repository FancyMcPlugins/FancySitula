package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.utils.FS_EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public abstract class FS_ClientboundSetEquipmentPacket implements FS_ClientboundPacket {

    protected int entityId;
    protected Map<FS_EquipmentSlot, ItemStack> equipment;

    public FS_ClientboundSetEquipmentPacket(int entityId, Map<FS_EquipmentSlot, ItemStack> equipment) {
        this.entityId = entityId;
        this.equipment = equipment;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public Map<FS_EquipmentSlot, ItemStack> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<FS_EquipmentSlot, ItemStack> equipment) {
        this.equipment = equipment;
    }
}
