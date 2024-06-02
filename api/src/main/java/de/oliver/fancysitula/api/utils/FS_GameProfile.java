package de.oliver.fancysitula.api.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FS_GameProfile {

    private UUID uuid;
    private String name;
    private Map<String, Property> properties;

    public FS_GameProfile(UUID uuid, String name, Map<String, Property> properties) {
        this.uuid = uuid;
        this.name = name;
        this.properties = properties;
    }

    public FS_GameProfile(UUID uuid, String name) {
        this(uuid, name, new HashMap<>());
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    public record Property(String name, String value, String signature) {
    }
}
