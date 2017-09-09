package com.learn.beanpostprocessor.service.impl;

import com.learn.beanpostprocessor.service.HelloAnnotationService;
import com.learn.beanpostprocessor.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloAnnotationServiceImplV2 implements HelloAnnotationService {
    @Override
    public void sayHello() {
        System.out.println("Hello from HelloAnnotationServiceImplV2");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from HelloAnnotationServiceImplV2");
    }
}
