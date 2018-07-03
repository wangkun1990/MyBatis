package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DynamicColumnBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicEntityBeanFactory {


    private DynamicEntityBeanFactory() {

    }

    private static Map<String, DynamicEntityBean> dynamicEntityBeanMap = new ConcurrentHashMap<>();

    /**
     *
     * @param genericClazz 泛型class
     * @return
     */
    public static DynamicEntityBean getEntityBean(Class<?> genericClazz) {
        DynamicEntityBean dynamicEntityBean = dynamicEntityBeanMap.get(genericClazz.getName());
        if (dynamicEntityBean == null) {
            dynamicEntityBean = new DynamicEntityBean();
            // 获取实体类注解
            Table table = genericClazz.getAnnotation(Table.class);
            if (table != null) {
                dynamicEntityBean.setTableName(table.name());
            } else {
                dynamicEntityBean.setTableName(genericClazz.getSimpleName());
            }
            List<String> javaFields = new ArrayList<>();
            List<String> dbColumns = new ArrayList<>();
            List<DynamicColumnBean> dynamicColumnBeans = new ArrayList<>();
            Field[] fields = genericClazz.getDeclaredFields();
            boolean primaryKey = true;
            DynamicColumnBean dynamicColumnBean;
            for (Field field : fields) {
                dynamicColumnBean = new DynamicColumnBean();
                // 获取字段注解
                Column column = field.getAnnotation(Column.class);
                // 获取主键注解
                Id id = field.getAnnotation(Id.class);
                if (id != null && primaryKey) {
                    dynamicColumnBean.setPrimaryKey(true);
                    dynamicColumnBean.setNullable(false);
                    dynamicEntityBean.setPrimaryKeyField(field.getName());
                    if (column != null) {
                        dynamicColumnBean.setColumnName(column.name());
                        dynamicEntityBean.setPrimaryKeyColumn(column.name());
                    } else {
                        dynamicColumnBean.setColumnName(field.getName());
                        dynamicEntityBean.setPrimaryKeyColumn(field.getName());
                    }
                    primaryKey = false;
                }
                dynamicColumnBean.setFieldName(field.getName());
                dynamicColumnBean.setJavaType(field.getType());
                javaFields.add(field.getName());
                if (column != null && StringUtils.isNotBlank(column.name())) {
                    dbColumns.add(column.name());
                    dynamicColumnBean.setColumnName(column.name());
                } else {
                    dynamicColumnBean.setColumnName(field.getName());
                    dbColumns.add(field.getName());
                }
                dynamicColumnBeans.add(dynamicColumnBean);
            }
            dynamicEntityBean.setInsertColumnsList(dynamicColumnBeans);
            dynamicEntityBean.setFields(javaFields);
            dynamicEntityBean.setColumns(dbColumns);
            dynamicEntityBean.setSelectColumns(convertSelectColumns(dbColumns, javaFields));
            dynamicEntityBeanMap.put(genericClazz.getName(), dynamicEntityBean);
        }
        return dynamicEntityBean;
    }

    public static String convertSelectColumns(List<String> dbColumns, List<String> javaFields) {
        checkSize(dbColumns, javaFields);
        StringBuilder select = new StringBuilder();
        for (int i = 0; i < dbColumns.size(); i++) {
            select.append(dbColumns.get(i)).append(" as ").append(javaFields.get(i)).append(", ");
        }
        return select.substring(0, select.lastIndexOf(","));
    }

    private static void checkSize(List<String> dbColumns, List<String> javaFields) {
        if (dbColumns == null || javaFields == null) {
            throw new IllegalArgumentException("");
        }
        if (dbColumns.size() != javaFields.size()) {
            throw new IllegalArgumentException("size not same");
        }
    }
}
