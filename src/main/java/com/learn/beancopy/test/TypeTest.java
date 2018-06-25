package com.learn.beancopy.test;

import com.learn.beancopy.dest.TypeB;
import com.learn.beancopy.source.TypeA;
import com.learn.tools.OrikaMapperUtil;

import java.util.ArrayList;
import java.util.List;

public class TypeTest {
    public static void main(String[] args) {
        TypeA typeA = new TypeA();
        typeA.setId("11");
        typeA.setUid(11);

        System.out.println(OrikaMapperUtil.map(typeA, TypeB.class));

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
