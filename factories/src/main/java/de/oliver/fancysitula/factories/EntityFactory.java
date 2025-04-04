package de.oliver.fancysitula.factories;

import de.oliver.fancysitula.api.entities.FS_Entity;
import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.entities.FS_RealPlayer;

import java.util.List;

public class EntityFactory {

    public void spawnEntityFor(FS_RealPlayer player, FS_Entity entity) {
        if (entity == null) {
            return;
        }

        FancySitula.PACKET_FACTORY.createAddEntityPacket(
                entity.getId(),
                entity.getUuid(),
                entity.getType(),
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                entity.getYaw(),
                entity.getPitch(),
                entity.getHeadYaw(),
                entity.getVelocityX(),
                entity.getVelocityY(),
                entity.getVelocityZ(),
                entity.getData()
        ).send(player);

        setEntityDataFor(player, entity);
    }

    public void despawnEntityFor(FS_RealPlayer player, FS_Entity entity) {
        if (entity == null) {
            return;
        }

        FancySitula.PACKET_FACTORY.createRemoveEntitiesPacket(
                        List.of(entity.getId())
                )
                .send(player);
    }

    public void setEntityDataFor(FS_RealPlayer player, FS_Entity entity) {
        if (entity == null) {
            return;
        }

        if (entity.getEntityData().isEmpty()) {
            return;
        }

        FancySitula.PACKET_FACTORY.createSetEntityDataPacket(
                entity.getId(),
                entity.getEntityData()
        ).send(player);
    }

    public void setEntityEquipmentFor(FS_RealPlayer player, FS_Player entity) {
        if (entity == null) {
            return;
        }

        FancySitula.PACKET_FACTORY.createSetEquipmentPacket(
                entity.getId(),
                entity.getEquipment()
        ).send(player);
    }

}
