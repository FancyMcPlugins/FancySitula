package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.utils.AngelConverter;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import org.junit.jupiter.api.Test;

class ClientboundTeleportEntityPacketImplTest {

    @Test
    void createPacket() {
        int entityId = 4313;
        double x = 15.0;
        double y = 57.0;
        double z = -27.0;
        float yaw = 90.0f;
        float pitch = 45.0f;
        boolean onGround = true;

        ClientboundTeleportEntityPacketImpl packet = new ClientboundTeleportEntityPacketImpl(entityId, x, y, z, yaw, pitch, onGround);
        ClientboundTeleportEntityPacket createdPacket = (ClientboundTeleportEntityPacket) packet.createPacket();

        assert createdPacket != null;
        assert createdPacket.getId() == entityId;
        assert createdPacket.getX() == x;
        assert createdPacket.getY() == y;
        assert createdPacket.getZ() == z;
        assert createdPacket.getyRot() == AngelConverter.degreesToVanillaByte(yaw);
        assert createdPacket.getxRot() == AngelConverter.degreesToVanillaByte(pitch);
        assert createdPacket.isOnGround() == onGround;
    }
}