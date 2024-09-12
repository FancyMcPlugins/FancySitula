package de.oliver.fancysitula.api.entities;

import de.oliver.fancysitula.api.utils.FS_EquipmentSlot;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FS_Player extends FS_Entity {

    protected Map<FS_EquipmentSlot, ItemStack> equipment;

    public FS_Player() {
        super(EntityType.PLAYER);

        this.equipment = new ConcurrentHashMap<>();
    }

    public Map<FS_EquipmentSlot, ItemStack> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<FS_EquipmentSlot, ItemStack> equipment) {
        this.equipment = equipment;
    }

    public void setEquipment(FS_EquipmentSlot slot, ItemStack item) {
        this.equipment.put(slot, item);
    }
}
