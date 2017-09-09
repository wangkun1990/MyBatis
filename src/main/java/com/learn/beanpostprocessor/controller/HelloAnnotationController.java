package com.learn.beanpostprocessor.controller;

import com.learn.beanpostprocessor.annotation.RoutingInjected;
import com.learn.beanpostprocessor.service.HelloAnnotationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping
@Controller
public class HelloAnnotationController {

    @RoutingInjected
    private HelloAnnotationService helloService;


    @RequestMapping("/hello")
    public void sayHello() {
        helloService.sayHello();
    }

    @RequestMapping("/hi")
    public void sayHi() {
        helloService.sayHi();
    }
}
