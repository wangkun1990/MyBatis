package com.learn.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    @AfterThrowing(value = "execution(* com.learn.dao.StudentMapper.*(..))", throwing = "ex")
    public void around(JoinPoint joinPoint, Exception ex) {
        System.out.println("method name = " + joinPoint.getSignature());
        System.out.println("method args = " + JSON.toJSONString(joinPoint.getArgs()));
        System.out.println("Exception = "  + ex.getCause());

    }
}
