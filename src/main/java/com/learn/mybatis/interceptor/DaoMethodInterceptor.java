package com.learn.mybatis.interceptor;

import com.learn.mybatis.bean.DaoInterfaceBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * dao方法拦截器
 */
@Component
@Aspect
public class DaoMethodInterceptor {


    private static ThreadLocal<DaoInterfaceBean> daoInterfaceInfoThreadLocal = new ThreadLocal<>();

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
        System.out.println("method name = " + methodSignature.getName());
        System.out.println("name space = " + mapperClazz.getName());



        Type[] genType = mapperClazz.getGenericInterfaces();


        // 这里约定，只取第一个继承的接口泛型。
        Type[] genericType = ((ParameterizedType) genType[0]).getActualTypeArguments();
        Class<?> genericClazz = (Class<?>) genericType[0];
        System.out.println("泛型类型 = " + genericClazz.getName());

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
