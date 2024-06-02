package de.oliver.fancysitula.factories;

import de.oliver.fancysitula.api.packets.FS_ClientboundPlayerInfoUpdatePacket;
import de.oliver.fancysitula.api.utils.ServerVersion;

import java.util.EnumSet;
import java.util.List;

/**
 * Factory class for creating packet instances based on the server version
 */
public class PacketFactory {

    /**
     * Creates a new FS_ClientboundPlayerInfoUpdatePacket instance based on the server version
     */
    public FS_ClientboundPlayerInfoUpdatePacket createPlayerInfoUpdatePacket(ServerVersion serverVersion, EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions, List<FS_ClientboundPlayerInfoUpdatePacket.Entry> entries) {
        switch (serverVersion) {
            case v1_20_6 -> {
                return new de.oliver.fancysitula.versions.v1_20_6.packets.ClientboundPlayerInfoUpdatePacketImpl(actions, entries);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_ClientboundPlayerInfoUpdatePacket instance based on the current server version
     */
    public FS_ClientboundPlayerInfoUpdatePacket createPlayerInfoUpdatePacket(EnumSet<FS_ClientboundPlayerInfoUpdatePacket.Action> actions, List<FS_ClientboundPlayerInfoUpdatePacket.Entry> entries) {
        return createPlayerInfoUpdatePacket(ServerVersion.getCurrentVersion(), actions, entries);
    }

}
