package com.learn.beancopy.test;

import com.learn.beancopy.annotation.Mapping;
import com.learn.beancopy.dest.Woman;
import com.learn.beancopy.source.Man;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) throws  Exception {
        A a = new A();
        a.setAge(20);
        a.setName("zhangsan");
        a.setBirthDay(new Date());
        System.out.println(OrikaMapperFactory.map(a, B.class));


        Man man = new Man();
        man.setSex("male");
        man.setAge(20);
        man.setName("lilei");

        System.out.println(OrikaMapperFactory.map(man, Woman.class));
    }


}
