package com.learn.service.impl;

import com.learn.service.inner.AbstractPay;
import org.springframework.stereotype.Service;

@Service
public class Alipay extends AbstractPay {

    @Override
    public void beforeExecute() {
        System.out.println("Alipay beforeExecute");
    }

    @Override
    public void afterExecute() {
        System.out.println("Alipay afterExecute");
    }
}
