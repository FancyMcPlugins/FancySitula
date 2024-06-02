package de.oliver.fancysitula.api.factories;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.utils.ServerVersion;
import de.oliver.fancysitula.versions.v1_20_6.entities.PlayerImpl;
import org.bukkit.entity.Player;

/**
 * Factory class for creating FS_Player instances based on the server version
 */
public class PlayerFactory {

    /**
     * Creates a new FS_Player instance based on the server version
     */
    public FS_Player createPlayer(ServerVersion serverVersion, Player bukkitPlayer) {
        switch (serverVersion) {
            case ServerVersion.v1_20_6 -> {
                return new PlayerImpl(bukkitPlayer);
            }
            default -> throw new IllegalArgumentException("Unsupported server version: " + serverVersion.getVersion());
        }
    }

    /**
     * Creates a new FS_Player instance based on the current server version
     */
    public FS_Player createPlayer(Player bukkitPlayer) {
        return createPlayer(ServerVersion.getCurrentVersion(), bukkitPlayer);
    }
}
