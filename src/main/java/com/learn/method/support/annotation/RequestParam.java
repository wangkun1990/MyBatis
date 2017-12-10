package com.learn.method.support.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface RequestParam {

    Class<?> type();

    boolean validate() default false;

    String contentType() default "JSON";
}
