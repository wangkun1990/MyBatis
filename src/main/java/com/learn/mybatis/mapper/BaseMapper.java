package com.learn.mybatis.mapper;

public interface BaseMapper<T> extends BaseSelectMapper<T>,
        BaseUpdateMapper<T>, BaseDeleteMapper<T>, BaseInsertMapper<T> {
}
