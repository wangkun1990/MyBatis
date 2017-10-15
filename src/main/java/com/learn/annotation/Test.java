package com.learn.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

        String tableName = "";

        //存储数据库列名
        List<String> dataBaseColumns = new ArrayList<>();

        //Java字段名
        List<String> javaBeanFields = new ArrayList<>();

        Class<?> clazz = Student.class;

        Table table = clazz.getDeclaredAnnotation(Table.class);
        if (table == null) {
            throw new IllegalArgumentException("类注解属性值不能为空!");
        }

        tableName = table.value();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //首先获取字段上的列注解，如果获取不到，则数据库字段名和java字段名一致
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                dataBaseColumns.add(field.getName());
            } else {
                dataBaseColumns.add(column.value());
            }
            javaBeanFields.add(field.getName());
        }

        String insertSql = String.format("insert into %s (%s) values (%s)", tableName, stringJoin(dataBaseColumns, ',', ""), stringJoin(javaBeanFields, ',', "#"));

        System.out.println(insertSql);


        String selectFields = "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dataBaseColumns.size(); i++) {
            sb.append(String.format("%s as %s,", dataBaseColumns.get(i), javaBeanFields.get(i)));
        }
        selectFields = sb.toString();
        selectFields = selectFields.substring(0, selectFields.length() - 1);

        String selectSql = String.format("select %s from %s", selectFields, tableName);

        System.out.println(selectSql);
    }

    public static String stringJoin(List<String> list, char separator, String prefix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(prefix + list.get(i));
            if (i < list.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
