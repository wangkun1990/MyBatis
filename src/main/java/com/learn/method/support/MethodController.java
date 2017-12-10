package com.learn.method.support;

import com.alibaba.fastjson.JSON;
import com.learn.method.support.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class MethodController {

    @RequestMapping(value = "/sayhello", method = RequestMethod.POST)
    public String sayHello(@RequestParam(type = Person.class) Person person) {
        return "hello, i am " + person.getName() + ", i am " + person.getAge();
    }

    @RequestMapping(value = "/sayhi", method = RequestMethod.POST)
    public String sayHi(@RequestBody String json) {
        System.out.println(JSON.parseObject(json, Person.class));
        return json;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(11);
        person.setName("tom");
        System.out.println(JSON.toJSON(person));
    }
}
