package com.learn.beanpostprocessor.service;

import com.learn.beanpostprocessor.annotation.RoutingSwitch;

@RoutingSwitch("hello.switch")
public interface HelloAnnotationService {

    @RoutingSwitch("A")
    void sayHello();

    void sayHi();
}
