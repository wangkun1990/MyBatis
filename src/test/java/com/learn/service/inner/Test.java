package com.learn.service.inner;

import java.io.UnsupportedEncodingException;

public class Test {

    /*
     * 判断输入的字符串在某个字符集下是否有效
     */
    public static boolean isStringValidInCharset(String s, String charset) {
        try {
            // 获取字符串s在字符集charset下的编码
            byte[] bytes = s.getBytes(charset);
            // 把获得的编码按该字符集解码成新字符串
            String ss = new String(bytes, charset);
            // 解码出来的新字符串应该与原来相等
            // 如果s不是该字符集下有效的字符串，解码出来的会是一堆问号
            return s.equals(ss);
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String a = "中文";
        String b = "䣃";

        try {
            //System.out.println (System.getenv("LC_CTYPE"));

            System.out.println (isStringValidInCharset(a, "GBK"));
            System.out.println (isStringValidInCharset(b, "GBK"));
            System.out.println (isStringValidInCharset(b, "CP936"));

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
