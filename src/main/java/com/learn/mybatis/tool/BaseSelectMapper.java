package com.learn.mybatis.tool;

import com.learn.mybatis.provide.BaseSelectProvide;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

public interface BaseSelectMapper<T> {

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @SelectProvider(type = BaseSelectProvide.class, method = "selectByPrimaryKey")
    T selectByPrimaryKey(@Param("id") Object id);

    /**
     * 根据条件查询记录总数
     * @param object
     * @return
     */
    @SelectProvider(type = BaseSelectProvide.class, method = "selectAllCountByParams")
    int selectAllCountByParams(T object);
}
