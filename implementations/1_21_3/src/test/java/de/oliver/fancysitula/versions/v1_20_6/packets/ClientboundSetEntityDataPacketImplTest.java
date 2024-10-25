package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.packets.FS_ClientboundSetEntityDataPacket;
import de.oliver.fancysitula.api.utils.entityData.FS_TextDisplayData;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;

import java.util.List;

class ClientboundSetEntityDataPacketImplTest {

    //TODO: Fix this test (using registry)
//    @Test
    void createPacket() {
        int entityId = 712;
        List<FS_ClientboundSetEntityDataPacket.EntityData> entityData = List.of(
                new FS_ClientboundSetEntityDataPacket.EntityData(
                        FS_TextDisplayData.TEXT,
                        "Hello, World!"
                )
        );

        ClientboundSetEntityDataPacketImpl packet = new ClientboundSetEntityDataPacketImpl(entityId, entityData);
        ClientboundSetEntityDataPacket createdPacket = (ClientboundSetEntityDataPacket) packet.createPacket();

        assert createdPacket.id() == entityId;
        assert createdPacket.packedItems().size() == 1;
    }
}