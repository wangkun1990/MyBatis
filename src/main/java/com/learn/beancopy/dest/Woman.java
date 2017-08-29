package com.learn.beancopy.dest;

import com.learn.beancopy.Person;

public class Woman extends Person {

    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Woman{" +
                "sex='" + sex + '\'' +
                "} " + super.toString();
    }
}
