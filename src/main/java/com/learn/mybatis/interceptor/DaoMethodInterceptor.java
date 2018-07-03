package com.learn.mybatis.interceptor;

import com.alibaba.fastjson.JSON;
import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.util.AopTargetUtils;
import org.apache.ibatis.binding.MapperProxy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * dao方法拦截器
 */
@Component
@Aspect
public class DaoMethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(DaoMethodInterceptor.class);

    private DaoMethodInterceptor() {

    }

    private static ThreadLocal<DaoInterfaceBean> daoInterfaceInfoThreadLocal = new ThreadLocal<>();

    private static volatile Map<String, DynamicEntityBean> dynamicEntityBeanMap = new HashMap<>();

    @Pointcut(value = "execution(* com.learn.dao.*.*(..))")
    private void daoMethod() {

    }


    public static DaoInterfaceBean getDaoInterfaceInfo() {
        return daoInterfaceInfoThreadLocal.get();
    }

    @Before(value = "daoMethod()")
    public void before(JoinPoint joinPoint) {
        Class<?> clazz = joinPoint.getThis().getClass();
        Class<?>[] targetInterfaces = ClassUtils.getAllInterfacesForClass(clazz, clazz.getClassLoader());
        Class<?> mapperClazz = targetInterfaces[0];
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("method name = " + methodSignature.getName());
        logger.info("name space = " + mapperClazz.getName());


        Type[] genType = mapperClazz.getGenericInterfaces();


        // 这里约定，只取第一个继承的接口泛型。
        Type[] genericType = ((ParameterizedType) genType[0]).getActualTypeArguments();
        Class<?> genericClazz = (Class<?>) genericType[0];
        logger.info("泛型类型 = " + genericClazz.getName());
        logger.info("参数 = " + JSON.toJSONString(joinPoint.getArgs()));

        DaoInterfaceBean daoInterfaceInfo = new DaoInterfaceBean();
        daoInterfaceInfo.setGenericClass(genericClazz);
        daoInterfaceInfo.setMethodName(methodSignature.getName());
        daoInterfaceInfo.setMapperInterface(mapperClazz);
        daoInterfaceInfo.setParameters(joinPoint.getArgs());
        daoInterfaceInfoThreadLocal.set(daoInterfaceInfo);
    }

    @After(value = "daoMethod()")
    public void after() {
        daoInterfaceInfoThreadLocal.remove();
    }
}
