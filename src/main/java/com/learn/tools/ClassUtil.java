package com.learn.tools;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class ClassUtil {

    private ClassUtil() {

    }

    static Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashedMap(8);

    static {
        primitiveWrapperTypeMap.put(Integer.class, int.class);
        primitiveWrapperTypeMap.put(Double.class, double.class);
        primitiveWrapperTypeMap.put(Float.class, float.class);
        primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
        primitiveWrapperTypeMap.put(Character.class, char.class);
        primitiveWrapperTypeMap.put(Long.class, long.class);
        primitiveWrapperTypeMap.put(Byte.class, byte.class);
        primitiveWrapperTypeMap.put(Short.class, short.class);
    }


    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive();
    }

    public static boolean isPrimitiveWrapper(Class<?> clazz) {
        return primitiveWrapperTypeMap.containsKey(clazz);
    }

    public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        return (clazz.isPrimitive() || isPrimitiveWrapper(clazz));
    }

    public static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }

}
