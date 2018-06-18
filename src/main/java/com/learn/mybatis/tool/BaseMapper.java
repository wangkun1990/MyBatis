package com.learn.mybatis.tool;

public interface BaseMapper<T> extends BaseSelectMapper<T>,
        BaseUpdateMapper<T>, BaseDeleteMapper<T>, BaseInsertMapper<T> {
}
