package de.oliver.fancysitula.api.utils;

public class AngelConverter {

    public static byte degreesToVanillaByte(float degrees) {
        return (byte) Math.floor(degrees * 256.0F / 360.0F);
    }

}
