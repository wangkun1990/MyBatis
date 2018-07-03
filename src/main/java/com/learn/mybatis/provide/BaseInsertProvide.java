package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicColumnBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import com.learn.mybatis.tool.ReflectionUtil;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.GenerationType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BaseInsertProvide {

    private Logger logger = LoggerFactory.getLogger(BaseInsertProvide.class);


    public String insert(Object object) {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        SQL insertSql = new SQL().INSERT_INTO(dynamicEntityBean.getTableName());
        for (DynamicColumnBean dynamicColumnBean : dynamicEntityBean.getInsertColumnsList()) {
            if (dynamicColumnBean.isPrimaryKey() && dynamicColumnBean.getGenerationType().equals(GenerationType.AUTO)) {
                continue;
            }
            insertSql.VALUES(dynamicColumnBean.getColumnName(), "#{" + dynamicColumnBean.getFieldName() + "}");
        }
        logger.info("insert sql = {}", insertSql);
        return insertSql.toString();
    }

    public String batchInsert(Map<?, ?> params) {
        List<?> listParams = (List<?>) params.get("list");
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        List<String> dbColumns = dynamicEntityBean.getColumns();
        StringBuilder sqlBuilder = new StringBuilder("insert into ").append(dynamicEntityBean.getTableName()).append(" (");
        sqlBuilder.append(String.join(",", dbColumns)).append(")");
        sqlBuilder.append(" values ");

        List<String> values = new ArrayList<>();
        for (Object object : listParams) {
            values.add(builderValue(object, dynamicEntityBean.getFields()));
        }

        sqlBuilder.append(String.join(",", values));


        logger.info("batchInsert sql = {}", sqlBuilder);
        return sqlBuilder.toString();
    }

    private String builderValue(Object object, List<String> javaFields) {
        StringBuilder valueBuilder = new StringBuilder("(");
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < javaFields.size(); i++) {
            for (Field field : fields) {
                if (field.getName().equals(javaFields.get(i))) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(object);
                        if (ReflectionUtil.isPrimaryKey(field)) {
                            if (value == null) {
                                if (field.getGenericType().getTypeName().equals(String.class.getName())) {
                                    value = UUID.randomUUID().toString().replace("-", "");
                                    valueBuilder.append("'").append(value).append("'").append(",");
                                } else if (field.getGenericType().getTypeName().equals(Integer.class.getName())) {
                                    value = 0;
                                    valueBuilder.append(value).append(",");
                                }
                            }

                        } else {
                            if (value instanceof Integer) {
                                valueBuilder.append(value).append(",");
                            } else if (value instanceof String) {
                                valueBuilder.append("'").append(value).append("'").append(",");
                            }
                        }

                    } catch (IllegalAccessException e) {

                    }
                }
            }
        }
        return valueBuilder.substring(0, valueBuilder.lastIndexOf(",")) + ")";
    }

}
