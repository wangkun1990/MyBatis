package com.learn.tools;


import java.math.BigDecimal;

public class BigdecimalUtil {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(1.01);
        System.out.println(b1);
        b1 = new BigDecimal("1.01");
        System.out.println(b1);
        b1 = new BigDecimal(0.00);
        System.out.println(b1);
    }

}
