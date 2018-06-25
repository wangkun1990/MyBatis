package com.learn.mybatis.util;

import java.lang.reflect.Field;

public class BeanUtils {
    private BeanUtils() {

    }


    /**
     * 获取对象属性的值
     * @param object
     * @param fieldName
     * @return
     */
    public static Object getPropertyValue(Object object, String fieldName) {
        Field[] fields = object.getClass().getDeclaredFields();
        Field field = null;
        for (Field f : fields) {
            if (f.getName().equals(fieldName)) {
                field = f;
                break;
            }
        }
        if (field != null) {
            try {
                field.setAccessible(true);
                return field.get(object);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

}
