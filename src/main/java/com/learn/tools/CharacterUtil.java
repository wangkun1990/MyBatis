package com.learn.tools;


import java.io.UnsupportedEncodingException;

public class CharacterUtil {

    private CharacterUtil() {

    }

    public final static String EMPTY = "";


    public final static String ENCODING_UTF8 = "UTF-8";

    public final static String ENCODING_GBK = "GBK";


    /**
     * 判断输入的字符串在某个字符集下是否有效
     *
     * @param s
     * @param charsetName
     * @return
     */
    public static boolean isStringValidInCharset(String s, String charsetName) {
        if (charsetName == null) {
            throw new NullPointerException("charsetName");
        }
        try {
            // 获取字符串s在字符集charset下的编码
            byte[] bytes = s.getBytes(charsetName);
            // 把获得的编码按该字符集解码成新字符串
            String newStr = new String(bytes, charsetName);
            // 解码出来的新字符串应该与原来相等
            // 如果s不是该字符集下有效的字符串，解码出来的会是一堆问号
            return s.equals(newStr);
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public static String filterSpecicalCharacter(String str) {
        if (str == null || EMPTY.equals(str)) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (isStringValidInCharset(String.valueOf(c), ENCODING_GBK)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(filterSpecicalCharacter("䵧Ø㓋매䕓䂣㕦㬢䓪㭜䘵䩐0〫㛙㛤䶮䣃䔲㴝㫞㢷中文hello☆"));
    }
}
