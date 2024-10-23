package de.oliver.fancysitula.api.utils;

import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.List;

public enum ServerVersion {

    v1_21_3("1.21.3", 768),
    v1_21_2("1.21.2", 768),
    v1_21_1("1.21.1", 767),
    v1_21("1.21", 767),
    v1_20_6("1.20.6", 766),
    v1_20_5("1.20.5", 766),
    ;

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

    public static List<String> getSupportedVersions() {
        return Arrays.stream(values())
                .map(ServerVersion::getVersion)
                .toList();
    }

    public static boolean isVersionSupported(String version) {
        return getByVersion(version) != null;
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
