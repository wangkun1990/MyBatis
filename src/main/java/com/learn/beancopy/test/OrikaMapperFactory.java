package com.learn.beancopy.test;

import com.learn.beancopy.annotation.Mapping;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrikaMapperFactory {

    private OrikaMapperFactory() {

    }
    private static MapperFactory mapperFactory;
    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public static <A, B> B map(A source, Class<B> destClazz) throws Exception {
        Field[] fields = destClazz.getDeclaredFields();
        List<String> sourceFields = new ArrayList<>();
        List<String> destFields = new ArrayList<>();
        for (Field field : fields) {
            Mapping mapping = field.getAnnotation(Mapping.class);
            if (mapping != null) {
                destFields.add(field.getName());
                sourceFields.add(mapping.value());
            }
        }
        if (!sourceFields.isEmpty()) {
            ClassMapBuilder<?, B> classMapBuilder = mapperFactory.classMap(source.getClass(), destClazz).field(sourceFields.get(0), destFields.get(0));
            for (int i = 1; i < sourceFields.size(); i++) {
                classMapBuilder = classMapBuilder.field(sourceFields.get(i), destFields.get(i));
            }
            classMapBuilder.byDefault().register();
        }
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(source, destClazz);
    }
}
