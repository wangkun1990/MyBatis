package com.learn.service.inner;

import java.io.UnsupportedEncodingException;

public class Test {


    public static void main(String[] args) {

        String a = "中文";
        String b = "䣃";

        try {
            byte[] aa = a.getBytes("GBK");
            System.out.println (javax.xml.bind.DatatypeConverter.printHexBinary(aa));
            System.out.println (new String(aa, "GBK"));

            byte[] ab = a.getBytes("UTF-8");
            System.out.println (javax.xml.bind.DatatypeConverter.printHexBinary(ab));
            System.out.println (new String(ab, "UTF-8"));

            System.out.println (javax.xml.bind.DatatypeConverter.printHexBinary(a.getBytes("UTF-16BE")));

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
