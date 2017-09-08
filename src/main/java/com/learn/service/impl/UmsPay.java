package com.learn.service.impl;

import com.learn.entity.Student;
import com.learn.service.inner.AbstractPay;
import org.springframework.stereotype.Service;

@Service("umspay")
public class UmsPay extends AbstractPay<Student> {

    @Override
    public Student beforeExecute(Student student) {
        System.out.println("UmsPay beforeExecute");
        student = new Student();
        student.setName("UmsPay");
        return student;
    }

    @Override
    public void afterExecute(Student student) {
        System.out.println("UmsPay afterExecute" + beforeExecute(student));
    }
}
