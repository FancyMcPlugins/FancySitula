package de.oliver.fancysitula.api.teams;

import de.oliver.fancysitula.api.packets.FS_Color;
import net.kyori.adventure.text.Component;

import java.util.List;

public class FS_Team {

    private String teamName;
    private Component displayName;
    private boolean allowFriendlyFire;
    private boolean canSeeFriendlyInvisibles;
    private FS_NameTagVisibility nameTagVisibility;
    private FS_CollisionRule collisionRule;
    private FS_Color color;
    private Component prefix;
    private Component suffix;
    private List<String> entities;

    public FS_Team(String teamName, Component displayName, boolean allowFriendlyFire, boolean canSeeFriendlyInvisibles, FS_NameTagVisibility nameTagVisibility, FS_CollisionRule collisionRule, FS_Color color, Component prefix, Component suffix, List<String> entities) {
        this.teamName = teamName;
        this.displayName = displayName;
        this.allowFriendlyFire = allowFriendlyFire;
        this.canSeeFriendlyInvisibles = canSeeFriendlyInvisibles;
        this.nameTagVisibility = nameTagVisibility;
        this.collisionRule = collisionRule;
        this.color = color;
        this.prefix = prefix;
        this.suffix = suffix;
        this.entities = entities;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public void setDisplayName(Component displayName) {
        this.displayName = displayName;
    }

    public boolean isAllowFriendlyFire() {
        return allowFriendlyFire;
    }

    public void setAllowFriendlyFire(boolean allowFriendlyFire) {
        this.allowFriendlyFire = allowFriendlyFire;
    }

    public boolean isCanSeeFriendlyInvisibles() {
        return canSeeFriendlyInvisibles;
    }

    public void setCanSeeFriendlyInvisibles(boolean canSeeFriendlyInvisibles) {
        this.canSeeFriendlyInvisibles = canSeeFriendlyInvisibles;
    }

    public FS_NameTagVisibility getNameTagVisibility() {
        return nameTagVisibility;
    }

    public void setNameTagVisibility(FS_NameTagVisibility nameTagVisibility) {
        this.nameTagVisibility = nameTagVisibility;
    }

    public FS_CollisionRule getCollisionRule() {
        return collisionRule;
    }

    public void setCollisionRule(FS_CollisionRule collisionRule) {
        this.collisionRule = collisionRule;
    }

    public FS_Color getColor() {
        return color;
    }

    public void setColor(FS_Color color) {
        this.color = color;
    }

    public Component getPrefix() {
        return prefix;
    }

    public void setPrefix(Component prefix) {
        this.prefix = prefix;
    }

    public Component getSuffix() {
        return suffix;
    }

    public void setSuffix(Component suffix) {
        this.suffix = suffix;
    }

    public List<String> getEntities() {
        return entities;
    }

    public void setEntities(List<String> entities) {
        this.entities = entities;
    }
}
