package com.learn.service.impl;

import com.learn.service.inner.AbstractPay;
import org.springframework.stereotype.Service;

@Service
public class UmsPay extends AbstractPay {

    @Override
    public void beforeExecute() {
        System.out.println("UmsPay beforeExecute");
    }

    @Override
    public void afterExecute() {
        System.out.println("UmsPay afterExecute");
    }
}
