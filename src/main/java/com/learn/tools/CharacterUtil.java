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
        if (s == null || EMPTY.equals(s)) {
            return false;
        }
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

    /**
     * 过滤掉非指定字符集编码的字符
     * @param str
     * @param charsetName
     * @return
     */
    public static String filterSpecicalCharacter(String str, String charsetName) {
        if (str == null || EMPTY.equals(str)) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            if (isStringValidInCharset(String.valueOf(c), charsetName)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 过滤非GBK字符集中的字符
     * @param str
     * @return
     */
    public static String filterGbkSpecialCharacter(String str) {
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
        System.out.println(filterGbkSpecialCharacter("Ø•º ד ・ྉ？?',，\"‘\u200D ™®Í㝳귀애랑㭍䢖➕䍭䆟䵧㓋매䕓䂣㕦㬢䓪㭜䘵䩐㛙㛤䶮䣃䔲㴝㫞㢷\u202C〫䔲㢮"));
        System.out.println(filterGbkSpecialCharacter("43º红星二锅头150ml"));
        System.out.println(filterGbkSpecialCharacter("米时代®柔系大米香皂"));
        System.out.println(filterGbkSpecialCharacter("18908942632\u202C"));
        System.out.println(filterGbkSpecialCharacter("䏜"));
        System.out.println(filterGbkSpecialCharacter("㶓"));
        System.out.println(filterGbkSpecialCharacter("䃼"));
        System.out.println(filterGbkSpecialCharacter("㵪"));
        System.out.println(filterGbkSpecialCharacter("䳒"));
        System.out.println(filterSpecicalCharacter("䳒", "utf-8"));

        System.out.println(filterGbkSpecialCharacter("老边区\u200C养老中心"));
        System.out.println(filterGbkSpecialCharacter("䧏"));
        System.out.println(filterGbkSpecialCharacter("梁䂂"));
        System.out.println(filterGbkSpecialCharacter("䧻青平"));
        System.out.println(filterGbkSpecialCharacter("北京凯诺奥森实业\u206E有限公司"));
        System.out.println(filterGbkSpecialCharacter("䅇袁园"));
        System.out.println(filterGbkSpecialCharacter("梁䂂"));
        System.out.println(filterGbkSpecialCharacter("崔㚞国"));
        System.out.println(filterGbkSpecialCharacter("天•城上城"));
        System.out.println(filterGbkSpecialCharacter("0; 陇海路与华山路交叉口向西51米路南工商;郑州市;中原区;主城区"));
        System.out.println(filterGbkSpecialCharacter("intermail单反相机包 SLR-618 蓝"));
        System.out.println(filterGbkSpecialCharacter("熊䃼妮"));
        System.out.println(filterGbkSpecialCharacter("张䜭"));
        System.out.println(filterGbkSpecialCharacter("路店4-D−7号"));
        System.out.println(filterGbkSpecialCharacter("沈春㬌"));
        System.out.println(filterGbkSpecialCharacter("中山市泰龙塑㬵制品有限公司"));
    }
}
