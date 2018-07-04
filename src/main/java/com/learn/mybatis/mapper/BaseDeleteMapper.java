package com.learn.mybatis.mapper;

import com.learn.mybatis.provide.BaseDeleteProvide;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;

public interface BaseDeleteMapper<T> {

    /**
     * 根据主键删除记录
     * @param id
     * @return
     */
    @DeleteProvider(type = BaseDeleteProvide.class, method = "deleteByPrimary")
    int deleteByPrimary(@Param("id") Object id);
}
