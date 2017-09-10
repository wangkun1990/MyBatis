package com.learn.beanpostprocessor.controller;

import com.learn.beanpostprocessor.annotation.RoutingInjected;
import com.learn.beanpostprocessor.service.HelloAnnotationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping
@RestController
public class HelloAnnotationController {

    @RoutingInjected
    private HelloAnnotationService helloService;


    @RequestMapping("/hello")
    public String sayHello() {
        helloService.sayHello();
        return "hello";
    }

    @RequestMapping("/hi")
    public void sayHi() {
        helloService.sayHi();
    }
}
