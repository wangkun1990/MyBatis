package com.learn.tools;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterHelper {

    public static String filterSpecialCharacters(String characters) {
        if (StringUtils.isNotEmpty(characters)) {
            String matchRule = StringUtils.EMPTY;
            String filter = StringUtils.EMPTY;
            try {
                matchRule = "\\p{Punct}\\s*|\t*|\r*|\n*";
                filter = "\\ud8\\u2022\\uba\\ua0\\u5d3\\u2006\\u30fb\\uf89\\uff1f\\u3f\\u27\\u2c\\uff0c\\u22\\u2018\\u200d\\u2005\\u2122\\uae\\ucd\\u3773\\uadc0\\uc560\\ub791\\u3b4d\\u4896\\u2795\\u436d\\u419f\\u4d67\\u34cb\\ub9e4\\u4553\\u40a3\\u3566\\u3b22\\u44ea\\u3b5c\\u4635\\u4a50\\u36d9\\u36e4\\u4dae\\u48c3\\u4532\\u3d1d\\u3ade\\u38b7\\u202c\\u302b\\u4532\\u38ae\\u43dc\\u3d93\\u3b72\\u3d6a\\u4cd2\\u3aea\\u3d19\\u200c";
                // 从SCM获取过滤的乱码字符 character.filter
                if (StringUtils.isNotBlank(filter)) {
                    return getUnioncodeCharacterFilter(filter, characters, matchRule);
                }
            } catch (Exception e) {
                // 当出现异常时忽略异常
                System.err.println(e);
            }
            return characters;
        } else {
            return StringUtils.EMPTY;
        }
    }

    public static String getUnioncodeCharacterFilter(String unioncodefilter,
                                                     String msg, String matchRule) {
        return getCharacterFilter(
                unicode2String(unioncodefilter),
                getNormalMsg(msg, matchRule));
    }

    public static String getCharacterFilter(String filter, String msg) {
        if (StringUtils.isBlank(filter)) {
            return msg;
        }

        if (StringUtils.isBlank(msg)) {
            return StringUtils.EMPTY;
        }

        for (char charString : filter.toCharArray()) {
            msg = msg.replace(String.valueOf(charString), "");
        }
        return msg;
    }

    public static String unicode2String(String unicode) {
        if (StringUtils.isNotBlank(unicode)) {
            StringBuilder string = new StringBuilder();
            String[] hex = unicode.split("\\\\u");
            for (int i = 1; i < hex.length; i++) {
                // 转换出每一个代码点
                int data = Integer.parseInt(hex[i], 16);
                // 追加成string
                string.append((char) data);
            }
            return string.toString();
        } else {
            return StringUtils.EMPTY;
        }

    }

    public static String getNormalMsg(String msg, final String matchRule) {
        if (StringUtils.isBlank(msg)) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.isBlank(matchRule)) {
            return msg;
        }
        String target = new Object() {
            public String subStr(String str) {
                String temp = "";
                for (int i = 0; i < str.length(); i++) {
                    boolean flag = isMessyCode(str.charAt(i) + "", matchRule);
                    if (!flag) {
                        temp = temp + str.charAt(i);
                    }
                }
                return temp;
            }
        }.subStr(msg);
        return target;
    }

    public static boolean isMessyCode(String strName, String matchRule) {
        String temp = StringUtils.EMPTY;
        boolean isOld = true;
        if (StringUtils.isNotBlank(matchRule)) {
            //如果存在指定规则则使用指定异常
            try {
                Pattern p = Pattern.compile(matchRule);
                Matcher m = p.matcher(strName);
                temp = m.replaceAll("");
                isOld = false;
            } catch (Exception e) {
                //异常忽略
            }
        }
        if (isOld) {
            Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
            Matcher m = p.matcher(strName);
            String after = m.replaceAll("");
            temp = after.replaceAll("\\p{P}", "");
        }

        char[] ch = temp.trim().toCharArray();
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    count = count + 1;
                }
            }
        }
        return count > 0;
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(CharacterHelper.filterSpecialCharacters("蒂佳婷去黑头毛孔细致贴套装2매*4SET"));
        System.out.println(CharacterHelper.filterSpecialCharacters("施䂣"));
        System.out.println(CharacterHelper.filterSpecialCharacters("㓋先生"));
        System.out.println(CharacterHelper.filterSpecialCharacters("䕓善棣"));
        System.out.println(CharacterHelper.filterSpecialCharacters("㕦年军"));
        System.out.println(CharacterHelper.filterSpecialCharacters("努比(Nuby)400ml两用3Dtritan360〫吸管杯（颜色图案随机）10457（颜色图案随机）"));

        System.out.println(CharacterHelper.filterSpecialCharacters("18908942632\u202C"));
        System.out.println(filterSpecialCharacters("43º红星二锅头150ml"));
        System.out.println(filterSpecialCharacters("米时代®柔系大米香皂"));
        System.out.println(filterSpecialCharacters("䏜"));
        System.out.println(filterSpecialCharacters("㶓"));
        System.out.println(filterSpecialCharacters("照烧鸡排饭            "));

        System.out.println(filterSpecialCharacters("老边区\u200C养老中心"));
    }
}
