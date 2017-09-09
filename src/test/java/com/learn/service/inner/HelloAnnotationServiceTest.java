package com.learn.service.inner;

import com.learn.beanpostprocessor.annotation.RoutingInjected;
import com.learn.beanpostprocessor.service.HelloAnnotationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class HelloAnnotationServiceTest {

    @RoutingInjected
    private HelloAnnotationService helloAnnotationService;

    @Test
    public void test() {
        helloAnnotationService.sayHello();
    }
}
