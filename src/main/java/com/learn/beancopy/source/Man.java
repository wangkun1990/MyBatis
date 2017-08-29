package com.learn.beancopy.source;

import com.learn.beancopy.Person;

public class Man extends Person {

    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Man{" +
                "sex='" + sex + '\'' +
                "} " + super.toString();
    }
}
