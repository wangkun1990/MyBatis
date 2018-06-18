package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;

public class BaseUpdateProvice {

    private static Logger logger = LoggerFactory.getLogger(BaseUpdateProvice.class);

    public static String updateAllColumnsByPrimary() {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        String updateColumns = updateColumns(daoInterfaceInfo.getParameters()[0], true);
        SQL updateSql = new SQL().UPDATE(dynamicEntityBean.getTableName()).SET(updateColumns)
                .WHERE(dynamicEntityBean.getPrimaryKeyColumn() + " = #{" + dynamicEntityBean.getPrimaryKeyField() + "}");
        logger.info("updateAllColumnsByPrimary updateSql = {}", updateSql);
        return updateSql.toString();
    }


    public static String updateNotNullColumnsByPrimary() {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        String updateColumns = updateColumns(daoInterfaceInfo.getParameters()[0], false);
        SQL updateSql = new SQL().UPDATE(dynamicEntityBean.getTableName()).SET(updateColumns)
                .WHERE(dynamicEntityBean.getPrimaryKeyColumn() + " = #{" + dynamicEntityBean.getPrimaryKeyField() + "}");
        logger.info("updateNotNullColumnsByPrimary updateSql = {}", updateSql);
        return updateSql.toString();
    }


    /**
     * 组装更新字段
     *
     * @param object
     * @param updateAllColumns
     * @return
     */
    private static String updateColumns(Object object, boolean updateAllColumns) {
        Field[] fields = object.getClass().getDeclaredFields();
        StringBuilder updateColumns = new StringBuilder();
        boolean first = false;
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(object);
            } catch (Exception e) {

            }

            Column column = field.getAnnotation(Column.class);
            Id id = field.getAnnotation(Id.class);
            //主键不更新
            if (id != null) {
                continue;
            }
            if (column != null && StringUtils.isNotBlank(column.name())) {

                //取注解中的字段作为数据库字段
                if (updateAllColumns) {
                    updateColumns.append(column.name()).append(" = ").append("'").append(value).append("'").append(",");
                } else {
                    if (value != null) {
                        updateColumns.append(column.name()).append(" = ").append("'").append(value).append("'").append(",");
                    }
                }

            } else {
                if (updateAllColumns) {
                    updateColumns.append(field.getName()).append(" = ").append("'").append(value).append("'").append(",");
                } else {
                    if (value != null) {
                        updateColumns.append(field.getName()).append(" = ").append("'").append(value).append("'").append(",");
                    }
                }

            }
        }
        return updateColumns.substring(0, updateColumns.lastIndexOf(","));
    }
}
