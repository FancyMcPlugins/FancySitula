package de.oliver.fancysitula.api.packets;

public enum FS_Color {
    BLACK(0),
    DARK_BLUE(1),
    DARK_GREEN(2),
    DARK_AQUA(3),
    DARK_RED(4),
    DARK_PURPLE(5),
    GOLD(6),
    GRAY(7),
    DARK_GRAY(8),
    BLUE(9),
    GREEN(10),
    AQUA(11),
    RED(12),
    LIGHT_PURPLE(13),
    YELLOW(14),
    WHITE(15);


    private final int id;

    FS_Color(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
