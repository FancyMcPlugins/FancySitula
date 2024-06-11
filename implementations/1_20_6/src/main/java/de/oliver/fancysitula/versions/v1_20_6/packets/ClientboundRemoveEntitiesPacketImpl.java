package de.oliver.fancysitula.versions.v1_20_6.packets;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.packets.FS_ClientboundRemoveEntitiesPacket;
import de.oliver.fancysitula.versions.v1_20_6.entities.PlayerImpl;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;

import java.util.List;

public class ClientboundRemoveEntitiesPacketImpl extends FS_ClientboundRemoveEntitiesPacket {

    /**
     * @param entityIds IDs of the entities to remove
     */
    public ClientboundRemoveEntitiesPacketImpl(List<Integer> entityIds) {
        super(entityIds);
    }

    @Override
    public Object createPacket() {
        int[] ids = new int[this.entityIds.size()];
        for (int i = 0; i < this.entityIds.size(); i++) {
            ids[i] = this.entityIds.get(i);
        }

        return new ClientboundRemoveEntitiesPacket(ids);
    }

    @Override
    public void send(FS_Player player) {
        ClientboundRemoveEntitiesPacket packet = (ClientboundRemoveEntitiesPacket) createPacket();

        ((PlayerImpl) player).getVanillaPlayer().connection.send(packet);
    }
}
