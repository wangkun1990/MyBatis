package com.learn.beanpostprocessor.service.impl;

import com.learn.beanpostprocessor.service.HelloService;


public class HelloServiceImplV2 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello from V2");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from V2");
    }
}
