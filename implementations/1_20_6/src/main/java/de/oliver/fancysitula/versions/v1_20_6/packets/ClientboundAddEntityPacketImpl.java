package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.packets.FS_ClientboundAddEntityPacket;
import de.oliver.fancysitula.api.utils.AngelConverter;
import de.oliver.fancysitula.versions.v1_20_6.entities.PlayerImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.phys.Vec3;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;
import org.bukkit.entity.EntityType;

import java.util.UUID;

public class ClientboundAddEntityPacketImpl extends FS_ClientboundAddEntityPacket {

    public ClientboundAddEntityPacketImpl(int entityId, UUID entityUUID, EntityType entityType, double x, double y, double z, float yaw, float pitch, float headYaw, int velocityX, int velocityY, int velocityZ, int data) {
        super(entityId, entityUUID, entityType, x, y, z, yaw, pitch, headYaw, velocityX, velocityY, velocityZ, data);
    }

    @Override
    public Object createPacket() {
        net.minecraft.world.entity.EntityType<?> vanillaType = BuiltInRegistries.ENTITY_TYPE.get(CraftNamespacedKey.toMinecraft(entityType.getKey()));

        return new ClientboundAddEntityPacket(
                entityId,
                entityUUID,
                x,
                y,
                z,
                AngelConverter.degreesToVanillaByte(pitch),
                AngelConverter.degreesToVanillaByte(yaw),
                vanillaType,
                data,
                new Vec3(velocityX, velocityY, velocityZ),
                AngelConverter.degreesToVanillaByte(headYaw)
        );
    }

    @Override
    public void send(FS_Player player) {
        ClientboundAddEntityPacket packet = (ClientboundAddEntityPacket) createPacket();

        ((PlayerImpl) player).getVanillaPlayer().connection.send(packet);
    }
}
