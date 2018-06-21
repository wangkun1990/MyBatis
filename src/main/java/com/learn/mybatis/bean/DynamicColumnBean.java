/**
 * 
 */
package com.learn.mybatis.bean;

import com.learn.mybatis.enums.QueryTypeEnum;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import javax.persistence.GenerationType;

@Data
public class DynamicColumnBean {


	/**
     * 数据库字段名称
     */
    private String columnName;
    
    /**
     * java对象属性名称
     */
    private String fieldName;
    
    /**
     * Java数据类型
     */
    private Class<?> javaType;
    
    /**
     * 数据库数据类型
     */
    private JdbcType jdbcType;
    
    /**
     * 主键生成策略
     */
    private GenerationType generationType = GenerationType.AUTO;
    
    /**
     * 匹配方式
     */
    private QueryTypeEnum queryType = QueryTypeEnum.EQUALS;
    
    /**
     * 是否持久化
     */
    private boolean persistence = true;
    /**
     * 是否为主键
     */
    private boolean primaryKey = false;
    
    /**
     * 是否是唯一键
     */
    private boolean uniqueKey = false;
    
    /**
     * 字段长度
     */
    private int length = 0;
    
    /**
     * 可否为空
     */
    private boolean nullable = true;
    
    /**
     * 是否参与插入
     */
    private boolean insertable = true;
    
    /**
     * 是否参与更新
     */
    private boolean updatable = true;

}
