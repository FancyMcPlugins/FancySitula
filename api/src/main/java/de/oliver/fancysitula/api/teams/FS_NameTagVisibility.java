package de.oliver.fancysitula.api.teams;

public enum FS_NameTagVisibility {
    ALWAYS("always"),
    NEVER("never"),
    HIDE_FOR_OTHER_TEAMS("hideForOtherTeams"),
    HIDE_FOR_OWN_TEAM("hideForOwnTeam");

    private final String name;

    FS_NameTagVisibility(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
