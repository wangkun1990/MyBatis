package com.learn.service.inner;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Test2 {

    public static void main(String[] args) throws Exception {




        String name = "㕦";
        char[] charArray = name.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println((int)charArray[i]);
            String hexString = Integer.toHexString((int)charArray[i]);
            System.out.println(charArray[i] + "对应的unicode 16进制 = " + hexString);
        }

        byte[] iso88591 = new String(charArray).getBytes("iso-8859-1");
        System.out.println("iso88591 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(iso88591));
        byte[] gb2312 = new String(charArray).getBytes("gb2312");
        System.out.println("gb2312 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(gb2312));
        byte[] gbk = new String(charArray).getBytes("gbk");
        System.out.println("gbk 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(gbk));
        byte[] utf16 = new String(charArray).getBytes("utf-16");
        System.out.println("utf16 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(utf16));
        byte[] utf8 = new String(charArray).getBytes("utf-8");
        System.out.println("utf8 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(utf8));














    }
}
