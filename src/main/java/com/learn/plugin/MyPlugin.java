package com.learn.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.annotation.Annotation;
import java.util.Properties;

/**
 * Created by wangkun on 2017/4/22.
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class MyPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.err.println("intercept before");
        Object obj = invocation.proceed();
        System.err.println("intercept after");
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        System.err.println("plugin");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.err.println("setProperties");
    }
}
