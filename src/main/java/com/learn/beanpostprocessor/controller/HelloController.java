package com.learn.beanpostprocessor.controller;

import com.learn.beanpostprocessor.service.impl.HelloServiceImplV1;
import com.learn.beanpostprocessor.service.impl.HelloServiceImplV2;
import com.learn.beanpostprocessor.util.SwitchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller
public class HelloController {

    //@Autowired
    private HelloServiceImplV1 helloServiceImplV1;

    //@Autowired
    private HelloServiceImplV2 helloServiceImplV2;


    public void sayHello() {
        if (SwitchUtil.getHelloVersion().equals("A")) {
            helloServiceImplV1.sayHello();
        } else {
            helloServiceImplV2.sayHello();
        }
    }

    public void sayHi() {
        if (SwitchUtil.getHiVersion().equals("A")) {
            helloServiceImplV1.sayHi();
        } else {
            helloServiceImplV2.sayHi();
        }
    }
}
