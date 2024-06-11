package de.oliver.fancysitula.api.entities;

import de.oliver.fancysitula.api.utils.FS_GameProfile;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a player
 */
public class FS_Player {

    @NotNull
    protected FS_GameProfile gameProfile;

    /**
     * Creates a new FS_Player instance
     *
     * @param gameProfile the game profile of the player
     */
    public FS_Player(@NotNull FS_GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }

    public @NotNull FS_GameProfile getGameProfile() {
        return gameProfile;
    }
}
