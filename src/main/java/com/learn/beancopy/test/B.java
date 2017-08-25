package com.learn.beancopy.test;

import com.learn.beancopy.annotation.Mapping;

import java.util.Date;

public class B {

    @Mapping("name")
    private String name1;

    @Mapping("age")
    private int age1;

    @Mapping("birthDay")
    private Date birthDay1;

    private String none;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public Date getBirthDay1() {
        return birthDay1;
    }

    public void setBirthDay1(Date birthDay1) {
        this.birthDay1 = birthDay1;
    }

    public String getNone() {
        return none;
    }

    public void setNone(String none) {
        this.none = none;
    }

    @Override
    public String toString() {
        return "B{" +
                "name1='" + name1 + '\'' +
                ", age1=" + age1 +
                ", birthDay1=" + birthDay1 +
                ", none='" + none + '\'' +
                '}';
    }
}
