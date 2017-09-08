package com.learn.service.impl;

import com.learn.entity.Student;
import com.learn.service.inner.AbstractPay;
import org.springframework.stereotype.Service;

@Service
public class Alipay extends AbstractPay<String> {

    @Override
    public String beforeExecute(String str) {
        System.out.println("Alipay beforeExecute");
        return str;
    }

    @Override
    public void afterExecute(String str) {
        System.out.println("Alipay afterExecute = " + beforeExecute(str));
    }
}
