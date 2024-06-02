package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.entities.FS_Player;
import de.oliver.fancysitula.api.utils.FS_GameProfile;
import de.oliver.fancysitula.api.utils.FS_GameType;
import net.kyori.adventure.text.Component;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public abstract class FS_ClientboundPlayerInfoUpdatePacket implements FS_ClientboundPacket {

    protected EnumSet<Action> actions;
    protected List<Entry> entries;

    public FS_ClientboundPlayerInfoUpdatePacket(EnumSet<Action> actions, List<Entry> entries) {
        this.actions = actions;
        this.entries = entries;
    }

    public FS_ClientboundPlayerInfoUpdatePacket(EnumSet<Action> actions, Entry entry) {
        this.actions = actions;
        this.entries = List.of(entry);
    }

    public FS_ClientboundPlayerInfoUpdatePacket(Action action, Entry entry) {
        this.actions = EnumSet.of(action);
        this.entries = List.of(entry);
    }

    public EnumSet<Action> getActions() {
        return actions;
    }

    public void setActions(EnumSet<Action> actions) {
        this.actions = actions;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public enum Action {
        ADD_PLAYER,
        INITIALIZE_CHAT,
        UPDATE_GAME_MODE,
        UPDATE_LISTED,
        UPDATE_LATENCY,
        UPDATE_DISPLAY_NAME,
    }

    public record Entry(FS_Player player,
                        UUID uuid,
                        @Nullable FS_GameProfile profile,
                        boolean listed,
                        int latency,
                        FS_GameType gameMode,
                        @Nullable Component displayName) {

    }

}
