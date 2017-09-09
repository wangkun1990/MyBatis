package com.learn.beanpostprocessor.service.impl;

import com.learn.beanpostprocessor.service.HelloService;


public class HelloServiceImplV1 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello from V1");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from V1");
    }
}
