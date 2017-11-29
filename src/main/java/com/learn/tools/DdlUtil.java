package com.learn.tools;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 快速生成insert和select语句的工具类
 */
public class DdlUtil {
    private DdlUtil() {

    }

    private static final String delimiter = ",";


    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static String generateInsertSql(Object object) throws Exception {
        List<String> columnNames = new ArrayList<>();
        List<String> columnValues = new ArrayList<>();
        String insertSql = "insert into %s(%s) values (%s)";
        String tableName = getTableName(object);

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            //field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                //没有注解，直接取字段名
                columnNames.add(field.getName());
            } else {
                columnNames.add(column.name());
            }
            columnValues.add(":" + field.getName());
        }
        return String.format(insertSql, tableName, String.join(",", columnNames), String.join(",", columnValues));
    }

    /**
     * 获取表名
     * @param object
     * @return
     */
    private static String getTableName(Object object) {
        Table table = object.getClass().getAnnotation(Table.class);
        if (table == null) {
            return object.getClass().getSimpleName();
        } else {
            return table.name();
        }
    }

    public static String generateSelectSql(Object object) {
        String tableName = getTableName(object);
        String selectSql = "select %s from %s";
        List<String> selectColumns = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            String fieldName = field.getName();
            if (column == null) {
                selectColumns.add(fieldName + " AS " + fieldName);
            } else {
                selectColumns.add(column.name() + " AS " + fieldName);
            }
        }
        return String.format(selectSql, String.join(",", selectColumns), tableName);
    }

}
