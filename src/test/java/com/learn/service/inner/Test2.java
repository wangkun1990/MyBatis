package com.learn.service.inner;



public class Test2 {

    public static void printHexString(char[] chars, String charsetName) throws Exception {
        for (int i = 0; i < chars.length; i++) {
            //System.out.println((int)chars[i]);
            String hexString = Integer.toHexString((int)chars[i]);
            System.out.println(chars[i] + "对应的unicode 16进制 = " + hexString + ",对应的" + charsetName + " 16进制 = "
                    + javax.xml.bind.DatatypeConverter.printHexBinary(String.valueOf(chars[i]).getBytes(charsetName)));
        }
    }
    public static void main(String[] args) throws Exception {




        String name = "䵧";
        char[] charArray = name.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println((int)charArray[i]);
            String hexString = Integer.toHexString((int)charArray[i]);
            System.out.println(charArray[i] + "对应的unicode 16进制 = " + hexString);
        }

        //iso-8859-1编码
        byte[] iso88591 = name.getBytes("iso-8859-1");
        System.out.println("iso88591 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(iso88591));

        //gb2312编码
        byte[] gb2312 = name.getBytes("gb2312");
        System.out.println("gb2312 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(gb2312));

        //gbk编码
        byte[] gbk = name.getBytes("gbk");
        System.out.println("gbk 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(gbk));

        //utf16编码
        byte[] utf16 = name.getBytes("utf-16");
        System.out.println("utf16 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(utf16));

        //utf8编码
        byte[] utf8 = name.getBytes("utf-8");
        System.out.println("utf8 16进制 = " + javax.xml.bind.DatatypeConverter.printHexBinary(utf8));


        String message = "淘!我喜欢!";
        printHexString(message.toCharArray(), "iso-8859-1");
        byte[] iso88591Msg = message.getBytes("iso-8859-1");
        //使用ISO-8859-1进行编码时，遇到不在码值范围内的字符会统一用3f表示，这也就是通常所说的"黑洞"，所有ISO-8859-1不认识的字符都变成了"?"
        System.out.println(new String(iso88591Msg, "iso-8859-1"));











    }
}
