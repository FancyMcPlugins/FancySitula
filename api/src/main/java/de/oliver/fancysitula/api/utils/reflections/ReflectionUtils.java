package de.oliver.fancysitula.api.utils.reflections;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionUtils {

    private static Unsafe getUnsafe() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }

    public static <T> T createUnsafeInstance(Class<T> clazz) throws Exception {
        Unsafe unsafe = getUnsafe();
        return (T) unsafe.allocateInstance(clazz);
    }

    public static <T> T createInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    public static Object getField(Object object, String fieldName) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    public static void setField(Object object, String fieldName, Object value) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    public static void setFinalField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        // Use Unsafe to modify the final field
        Unsafe unsafe = getUnsafe();
        long offset = unsafe.objectFieldOffset(field);
        if (field.getType() == int.class) {
            unsafe.putInt(target, offset, (int) value);
        } else if (field.getType() == long.class) {
            unsafe.putLong(target, offset, (long) value);
        } else if (field.getType() == double.class) {
            unsafe.putDouble(target, offset, (double) value);
        } else if (field.getType() == float.class) {
            unsafe.putFloat(target, offset, (float) value);
        } else if (field.getType() == boolean.class) {
            unsafe.putBoolean(target, offset, (boolean) value);
        } else if (field.getType() == byte.class) {
            unsafe.putByte(target, offset, (byte) value);
        } else if (field.getType() == short.class) {
            unsafe.putShort(target, offset, (short) value);
        } else if (field.getType() == char.class) {
            unsafe.putChar(target, offset, (char) value);
        } else {
            unsafe.putObject(target, offset, value);
        }
    }
}
