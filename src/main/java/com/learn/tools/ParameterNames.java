package com.learn.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * 但java编译时默认是关闭的，所以使用javac -parameters进行编译即可，
 * idea中找到File->Settings->java Compiler中的Additional command line parameters添加-parameters参数即可
 */
public class ParameterNames {



    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println(parameter.isNamePresent());
            System.out.println("Parameter: " + parameter.getName());
        }


        int total = 100000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            Constant.getRefundBusinessType();
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            Constant.getRefundBusinessType1();
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            Constant.getRefundBusinessType2();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

class Constant {

    private static final String[] BUSINESS_TYPE_REFUND = {"11", "12", "13", "14", "15", "16", "17", "18", "19"};

    public static String[] getRefundBusinessType() {
        return BUSINESS_TYPE_REFUND.clone();
    }


    public static String[] getRefundBusinessType1() {
        return Arrays.copyOf(BUSINESS_TYPE_REFUND, BUSINESS_TYPE_REFUND.length);
    }


    public static String[] getRefundBusinessType2() {
        String[] result = new String[BUSINESS_TYPE_REFUND.length];
        System.arraycopy(BUSINESS_TYPE_REFUND, 0, result, 0, BUSINESS_TYPE_REFUND.length);
        return result;
    }
}
