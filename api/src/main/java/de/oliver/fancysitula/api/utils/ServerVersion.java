package de.oliver.fancysitula.api.utils;

import org.bukkit.Bukkit;

public enum ServerVersion {

    v1_21("1.21", 767),
    v1_20_6("1.20.6", 766);

    private final String version;
    private final int protocolVersion;

    ServerVersion(String version, int protocolVersion) {
        this.version = version;
        this.protocolVersion = protocolVersion;
    }

    public static ServerVersion getByProtocolVersion(int protocolVersion) {
        for (ServerVersion version : values()) {
            if (version.getProtocolVersion() == protocolVersion) {
                return version;
            }
        }

        return null;
    }

    public static ServerVersion getByVersion(String version) {
        for (ServerVersion serverVersion : values()) {
            if (serverVersion.getVersion().equals(version)) {
                return serverVersion;
            }
        }

        return null;
    }

    /**
     * @return the current server version of the server the plugin is running on
     */
    public static ServerVersion getCurrentVersion() {
        return getByVersion(Bukkit.getMinecraftVersion());
    }

    public String getVersion() {
        return version;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }
}
