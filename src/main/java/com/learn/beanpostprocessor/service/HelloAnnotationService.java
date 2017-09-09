package com.learn.beanpostprocessor.service;

import com.learn.beanpostprocessor.annotation.RoutingSwitch;
import com.learn.beanpostprocessor.routingenum.RoutingEnum;

//@RoutingSwitch("aa")
public interface HelloAnnotationService {

    @RoutingSwitch(RoutingEnum.B)
    void sayHello();

    void sayHi();
}
