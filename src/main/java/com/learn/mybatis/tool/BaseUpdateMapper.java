package com.learn.mybatis.tool;

import com.learn.mybatis.provide.BaseUpdateProvide;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseUpdateMapper<T> {

    /**
     * 根据主键更新所有字段
     * @param t
     * @return
     */
    @UpdateProvider(type = BaseUpdateProvide.class, method = "updateAllColumnsByPrimary")
    int updateAllColumnsByPrimary(T t);

    /**
     * 根据主键更新不为null的字段
     * @param t
     * @return
     */
    @UpdateProvider(type = BaseUpdateProvide.class, method = "updateNotNullColumnsByPrimary")
    int updateNotNullColumnsByPrimary(T t);
}
