package com.learn.tools;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

public class FastJsonUtils {


    private FastJsonUtils() {

    }


    public static void toJsonString(Object object) {
        System.err.println(JSON.toJSONString(object, new ValueFilter() {
            @Override
            public Object process(Object o, String s, Object o1) {
                if (o1 == null) {
                    return "";
                }
                return o1;
            }
        }));
    }
}
