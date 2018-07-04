package com.learn.mybatis.bean;

import lombok.Data;

import java.util.List;

@Data
public class DynamicEntityBean {

    /**
     * Java对象字段名
     */
    private List<String> fields;

    /**
     * 数据库对应字段
     */
    private List<String> columns;

    /**
     * 要查询的数据库列
     */
    private String selectColumns;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 数据库主键字段
     */
    private String primaryKeyColumn;

    /**
     * java对象主键字段
     */
    private String primaryKeyField;

    /**
     * insert语句用到的字段
     */
    private List<DynamicColumnBean> insertColumnsList;

    /**
     * 更新sql用到的字段
     */
    private List<DynamicColumnBean> updateColumnsList;
}
