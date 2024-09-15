package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.entities.FS_RealPlayer;
import de.oliver.fancysitula.api.packets.FS_ClientboundTeleportEntityPacket;
import de.oliver.fancysitula.api.utils.AngelConverter;
import de.oliver.fancysitula.api.utils.reflections.ReflectionUtils;
import de.oliver.fancysitula.versions.v1_20_6.utils.VanillaPlayerAdapter;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.server.level.ServerPlayer;

public class ClientboundTeleportEntityPacketImpl extends FS_ClientboundTeleportEntityPacket {

    public ClientboundTeleportEntityPacketImpl(int entityId, double x, double y, double z, float yaw, float pitch, boolean onGround) {
        super(entityId, x, y, z, yaw, pitch, onGround);
    }

    @Override
    public Object createPacket() {
        ClientboundTeleportEntityPacket packet = null;

        try {
            packet = ReflectionUtils.createUnsafeInstance(ClientboundTeleportEntityPacket.class);
            ReflectionUtils.setFinalField(packet, "id", entityId);
            ReflectionUtils.setFinalField(packet, "x", x);
            ReflectionUtils.setFinalField(packet, "y", y);
            ReflectionUtils.setFinalField(packet, "z", z);
            ReflectionUtils.setFinalField(packet, "yRot", AngelConverter.degreesToVanillaByte(yaw));
            ReflectionUtils.setFinalField(packet, "xRot", AngelConverter.degreesToVanillaByte(pitch));
            ReflectionUtils.setFinalField(packet, "onGround", onGround);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packet;
    }

    @Override
    public void sendPacketTo(FS_RealPlayer player) {
        ClientboundTeleportEntityPacket packet = (ClientboundTeleportEntityPacket) createPacket();

        ServerPlayer vanillaPlayer = VanillaPlayerAdapter.asVanilla(player.getBukkitPlayer());
        vanillaPlayer.connection.send(packet);
    }
}
