package com.learn.aspect;

import com.learn.service.impl.StudentServiceImpl;
import com.learn.service.inner.IDepartmentService;
import com.learn.service.inner.IStudentService;
import com.learn.service.inner.IStudentService2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeAspect.class);

    @Around(value = "execution(* com.learn.service.impl.StudentServiceImpl.*(..)) && args(id) && target(studentService)")
    public Object around(ProceedingJoinPoint pjp, int id, StudentServiceImpl studentService) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String methodName = methodSignature.getMethod().getName();
        LOGGER.error("methodName = {}, id = {}", methodName, id);
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            LOGGER.error("cost time = {} ms", (System.currentTimeMillis() - start));
        }

    }
}
