package com.learn.mybatis.tool;

import com.learn.mybatis.provide.BaseInsertProvide;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseInsertMapper<T> {

    @InsertProvider(type = BaseInsertProvide.class, method = "batchInsert")
    int batchInsert(@Param("params") List<T> t);
}
