package de.oliver.fancysitula.api.packets;

import de.oliver.fancysitula.api.teams.FS_CollisionRule;
import de.oliver.fancysitula.api.teams.FS_NameTagVisibility;
import net.kyori.adventure.text.Component;

import java.util.List;

public abstract class FS_ClientboundCreateOrUpdateTeamPacket extends FS_ClientboundPacket {

    protected Method method;
    protected String teamName;

    protected CreateTeam createTeam;
    protected RemoveTeam removeTeam;
    protected UpdateTeam updateTeam;
    protected AddEntity addEntity;
    protected RemoveEntity removeEntity;

    public FS_ClientboundCreateOrUpdateTeamPacket(String teamName, CreateTeam createTeam) {
        this.method = Method.CREATE_TEAM;
        this.teamName = teamName;
        this.createTeam = createTeam;
    }

    public FS_ClientboundCreateOrUpdateTeamPacket(String teamName, RemoveTeam removeTeam) {
        this.method = Method.REMOVE_TEAM;
        this.teamName = teamName;
        this.removeTeam = removeTeam;
    }

    public FS_ClientboundCreateOrUpdateTeamPacket(String teamName, UpdateTeam updateTeam) {
        this.method = Method.UPDATE_TEAM;
        this.teamName = teamName;
        this.updateTeam = updateTeam;
    }

    public FS_ClientboundCreateOrUpdateTeamPacket(String teamName, AddEntity addEntity) {
        this.method = Method.ADD_ENTITY;
        this.teamName = teamName;
        this.addEntity = addEntity;
    }

    public FS_ClientboundCreateOrUpdateTeamPacket(String teamName, RemoveEntity removeEntity) {
        this.method = Method.REMOVE_ENTITY;
        this.teamName = teamName;
        this.removeEntity = removeEntity;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public CreateTeam getCreateTeam() {
        return createTeam;
    }

    public void setCreateTeam(CreateTeam createTeam) {
        this.createTeam = createTeam;
    }

    public UpdateTeam getUpdateTeam() {
        return updateTeam;
    }

    public void setUpdateTeam(UpdateTeam updateTeam) {
        this.updateTeam = updateTeam;
    }

    public AddEntity getAddEntity() {
        return addEntity;
    }

    public void setAddEntity(AddEntity addEntity) {
        this.addEntity = addEntity;
    }

    public RemoveEntity getRemoveEntity() {
        return removeEntity;
    }

    public void setRemoveEntity(RemoveEntity removeEntity) {
        this.removeEntity = removeEntity;
    }

    public enum Method {
        CREATE_TEAM,
        REMOVE_TEAM,
        UPDATE_TEAM,
        ADD_ENTITY,
        REMOVE_ENTITY;
    }

    public static class CreateTeam {
        private Component displayName;
        private boolean allowFriendlyFire;
        private boolean canSeeFriendlyInvisibles;
        private FS_NameTagVisibility nameTagVisibility;
        private FS_CollisionRule collisionRule;
        private FS_Color color;
        private Component prefix;
        private Component suffix;
        private List<String> entities;

        public CreateTeam(Component displayName, boolean allowFriendlyFire, boolean canSeeFriendlyInvisibles, FS_NameTagVisibility nameTagVisibility, FS_CollisionRule collisionRule, FS_Color color, Component prefix, Component suffix, List<String> entities) {
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

    public static class RemoveTeam {

    }

    public static class UpdateTeam {
        private Component displayName;
        private boolean allowFriendlyFire;
        private boolean canSeeFriendlyInvisibles;
        private FS_NameTagVisibility nameTagVisibility;
        private FS_CollisionRule collisionRule;
        private FS_Color color;
        private Component prefix;
        private Component suffix;

        public UpdateTeam(Component displayName, boolean allowFriendlyFire, boolean canSeeFriendlyInvisibles, FS_NameTagVisibility nameTagVisibility, FS_CollisionRule collisionRule, FS_Color color, Component prefix, Component suffix) {
            this.displayName = displayName;
            this.allowFriendlyFire = allowFriendlyFire;
            this.canSeeFriendlyInvisibles = canSeeFriendlyInvisibles;
            this.nameTagVisibility = nameTagVisibility;
            this.collisionRule = collisionRule;
            this.color = color;
            this.prefix = prefix;
            this.suffix = suffix;
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
    }

    public static class AddEntity {
        private List<String> entities;

        public AddEntity(List<String> entities) {
            this.entities = entities;
        }

        public List<String> getEntities() {
            return entities;
        }

        public void setEntities(List<String> entities) {
            this.entities = entities;
        }
    }

    public static class RemoveEntity {
        private List<String> entities;

        public RemoveEntity(List<String> entities) {
            this.entities = entities;
        }

        public List<String> getEntities() {
            return entities;
        }

        public void setEntities(List<String> entities) {
            this.entities = entities;
        }
    }

}
