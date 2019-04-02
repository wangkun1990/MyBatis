package com.learn.beancopy.test;

import com.learn.beancopy.dest.TypeB;
import com.learn.beancopy.source.TypeA;
import com.learn.tools.OrikaMapperUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TypeTest {
    public static void main(String[] args) {
        TypeA typeA = new TypeA();
        typeA.setId("11");
        typeA.setUid(11);
        //typeA.setDate("2019-04-02");
        typeA.setDate1(new Date());
        typeA.setDate2(System.currentTimeMillis());

        System.out.println(OrikaMapperUtil.map(typeA, TypeB.class));

        /*TypeB typeB = new TypeB();
        typeB.setDate(new Date());
        typeB.setDate1("2017-08-01");
        typeB.setDate2(new Date());
        typeB.setId(123);
        typeB.setUid("456");
        System.out.println(OrikaMapperUtil.map(typeB, TypeA.class));*/

        List<TypeA> typeAList = new ArrayList<>();
        TypeA typeA1 = new TypeA();
        typeA1.setUid(112);
        typeA1.setId("152");
        typeAList.add(typeA1);
        typeA1 = new TypeA();
        typeA1.setUid(11112);
        typeA1.setId("15112");
        typeAList.add(typeA1);

        System.out.println(OrikaMapperUtil.mapAsList(typeAList, TypeB.class));
    }
}
