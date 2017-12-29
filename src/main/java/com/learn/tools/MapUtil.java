package com.learn.tools;

import com.alibaba.fastjson.annotation.JSONField;
import com.learn.entity.RefundRequest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

public class MapUtil {
    private MapUtil() {

    }

    /**
     *
     * @param params key1=value1&key2=value2&key3=value3
     * @return
     */
    public static Map<String, String> string2Map(String params) {
        Map<String, String> map = new TreeMap<>();
        if (isNotBlank(params)) {
            String[] keyValue = params.split("&");
            for (String str : keyValue) {
                String[] keyAndValue = str.split("=");
                map.put(keyAndValue[0], keyValue[1]);
            }
        }

        return map;
    }

    /**
     * 对象转换成map,如果对象值为空，不加入到map中，map中的key按字典升序排序
     * @param object
     * @return
     */
    public static Map<String, String> object2Map(Object object) {
        Map<String, String> treeMap = new TreeMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                JSONField jsonField = field.getAnnotation(JSONField.class);
                String key;
                if (jsonField != null) {
                    key = jsonField.name();
                } else {
                    key = field.getName();
                }
                Object result = field.get(object);
                if (result instanceof String) {
                    String str = (String) result;
                    if (isNotBlank(str)) {
                        treeMap.put(key, str);
                    }
                }
            }
        } catch (Exception e) {
        }
        return treeMap;
    }


    /**
     * map转换成string，格式:key1=value1&key2=value2&key3=value3
     * @param map
     * @return
     */
    public static String map2String(Map<String, String> map) {
        Map<String, String> treeMap = new TreeMap<>(map);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            result.append(key).append("=").append(value).append("&");
        }
        return result.substring(0, result.length() - 1);
    }


    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    /**
     * 生成 HMACSHA256
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }


    public static boolean isNotBlank(CharSequence sc) {
        return !isBlank(sc);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setStoreType("S");
        refundRequest.setAppid("wxd930ea5d5a258f4f");
        refundRequest.setMchId("10000100");
        refundRequest.setTransactionId("");
        refundRequest.setOutTradeNo("");
        refundRequest.setOutRefundNo("");
        refundRequest.setTotalFee("10");
        refundRequest.setRefundFee("10");
        refundRequest.setRefundDesc("");
        refundRequest.setRefundAccount("10");
        System.out.println(object2Map(refundRequest));
        System.out.println(map2String(object2Map(refundRequest)));
        System.out.println(MD5(map2String(object2Map(refundRequest))));

    }

}
