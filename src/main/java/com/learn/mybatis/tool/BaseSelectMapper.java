package com.learn.mybatis.tool;

import com.learn.mybatis.provide.BaseSelectProvice;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface BaseSelectMapper<T> {

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @SelectProvider(type = BaseSelectProvice.class, method = "selectByPrimaryKey")
    T selectByPrimaryKey(Object id);
}
