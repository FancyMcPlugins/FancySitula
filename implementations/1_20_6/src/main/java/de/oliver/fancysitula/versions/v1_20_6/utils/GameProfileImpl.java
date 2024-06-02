package de.oliver.fancysitula.versions.v1_20_6.utils;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import com.mojang.authlib.GameProfile;
import de.oliver.fancysitula.api.utils.FS_GameProfile;

import java.util.Map;

public class GameProfileImpl {

    public static GameProfile asVanilla(FS_GameProfile gameProfile) {
        GameProfile gf = new GameProfile(gameProfile.getUUID(), gameProfile.getName());

        for (Map.Entry<String, FS_GameProfile.Property> entry : gameProfile.getProperties().entrySet()) {
            FS_GameProfile.Property property = entry.getValue();

            gf.getProperties().put(entry.getKey(), new com.mojang.authlib.properties.Property(property.name(), property.value(), property.signature()));
        }

        return gf;
    }

    public static FS_GameProfile fromVanilla(GameProfile gameProfile) {
        FS_GameProfile fsGameProfile = new FS_GameProfile(gameProfile.getId(), gameProfile.getName());

        for (Map.Entry<String, com.mojang.authlib.properties.Property> entry : gameProfile.getProperties().entries()) {
            com.mojang.authlib.properties.Property property = entry.getValue();

            fsGameProfile.getProperties().put(entry.getKey(), new FS_GameProfile.Property(property.name(), property.value(), property.signature()));
        }

        return fsGameProfile;
    }

    public static FS_GameProfile fromBukkit(PlayerProfile gameProfile) {
        FS_GameProfile fsGameProfile = new FS_GameProfile(gameProfile.getId(), gameProfile.getName());

        for (ProfileProperty property : gameProfile.getProperties()) {
            fsGameProfile.getProperties().put(property.getName(), new FS_GameProfile.Property(property.getName(), property.getValue(), property.getSignature()));
        }

        return fsGameProfile;
    }
}
