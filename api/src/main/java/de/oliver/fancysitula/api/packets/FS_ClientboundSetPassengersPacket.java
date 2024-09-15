package de.oliver.fancysitula.api.packets;

import java.util.List;

public abstract class FS_ClientboundSetPassengersPacket extends FS_ClientboundPacket {

    protected int entityId;
    protected List<Integer> passengers;

    public FS_ClientboundSetPassengersPacket(int entityId, List<Integer> passengers) {
        this.entityId = entityId;
        this.passengers = passengers;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public List<Integer> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Integer> passengers) {
        this.passengers = passengers;
    }
}
