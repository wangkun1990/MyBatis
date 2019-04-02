package com.learn.tools;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class OrikaMapperUtil {

    private static MapperFacade mapperFacade;
    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    public static <A, B> B map(A source, Class<B> destClazz) {
        if (source == null || destClazz == null) {
            return null;
        }
        return mapperFacade.map(source, destClazz);
    }

    public static <S, D> List<D> mapAsList(Iterable<S> iterable, Class<D> destClass) {
        if (iterable == null || destClass == null) {
            return new ArrayList<>();
        }
        return mapperFacade.mapAsList(iterable, destClass);
    }
}
