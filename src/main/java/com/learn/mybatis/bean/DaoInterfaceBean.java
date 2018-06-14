package com.learn.mybatis.bean;

public class DaoInterfaceBean {

    /**
     * mapper接口类型
     */
    private Class<?> mapperInterface;


    /**
     * 方法名
     */
    private String methodName;

    /**
     * 接口泛型类型
     */
    private Class<?> genericClass;

    /**
     * 方法参数
     */
    private Object[] parameters;

    public Class<?> getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class<?> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?> getGenericClass() {
        return genericClass;
    }

    public void setGenericClass(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
