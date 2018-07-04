package com.learn.mybatis.util;

import javax.persistence.Id;
import java.lang.reflect.Field;

public class ReflectionUtils {

    private ReflectionUtils() {

    }

    /**
     * 判断是否是主键
     * @param field
     * @return true:主键字段;false:非主键字段
     */
    public static boolean isPrimaryKey(Field field) {
        return field.getAnnotation(Id.class) != null;
    }
}
