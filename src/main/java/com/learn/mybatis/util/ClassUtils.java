package com.learn.mybatis.util;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassUtils {

    private ClassUtils() {

    }

    public static Class<?>[] getAllInterfacesForClass(Class<?> clazz, ClassLoader classLoader) {
        Set<Class<?>> ifcs = getAllInterfacesForClassAsSet(clazz, classLoader);
        return ifcs.toArray(new Class<?>[ifcs.size()]);
    }

    public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz, ClassLoader classLoader) {
        if (clazz == null) {
            throw new IllegalArgumentException("Class must not be null");
        }
        if (clazz.isInterface() && isVisible(clazz, classLoader)) {
            return Collections.singleton(clazz);
        }
        Set<Class<?>> interfaces = new LinkedHashSet<>();
        while (clazz != null) {
            Class<?>[] ifcs = clazz.getInterfaces();
            for (Class<?> ifc : ifcs) {
                interfaces.addAll(getAllInterfacesForClassAsSet(ifc, classLoader));
            }
            clazz = clazz.getSuperclass();
        }
        return interfaces;
    }


    public static boolean isVisible(Class<?> clazz, ClassLoader classLoader) {
        if (classLoader == null) {
            return true;
        }
        try {
            Class<?> actualClass = classLoader.loadClass(clazz.getName());
            return (actualClass == clazz);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
