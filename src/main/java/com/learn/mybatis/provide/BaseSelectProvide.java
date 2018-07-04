package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicColumnBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import com.learn.mybatis.util.BeanUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseSelectProvide {

    private static Logger logger = LoggerFactory.getLogger(BaseSelectProvide.class);

    public static String selectByPrimaryKey() {
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean();
        SQL sql = new SQL().SELECT(dynamicEntityBean.getSelectColumns()).FROM(dynamicEntityBean.getTableName()).WHERE(dynamicEntityBean.getPrimaryKeyColumn() + " = #{id}");
        logger.info("selectByPrimaryKey sql = {}", sql);
        return sql.toString();
    }

    public static String selectAllCountByParams(Object object) {
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean();
        SQL countSql = new SQL().SELECT("count(*)").FROM(dynamicEntityBean.getTableName());
        appendSelectParams(object, countSql, dynamicEntityBean);
        logger.info("selectAllCountByParams countSql = {}", countSql);
        return countSql.toString();
    }

    private static void appendSelectParams(Object object, SQL sql, DynamicEntityBean dynamicEntityBean) {
        for (DynamicColumnBean dynamicColumnBean : dynamicEntityBean.getAllColumnsList()) {
            String javaField = dynamicColumnBean.getFieldName();
            Object value = BeanUtils.getPropertyValue(object, javaField);
            if (value != null) {
                sql.WHERE(dynamicColumnBean.getColumnName() + " = #{" + javaField + "}");
            }
        }
        //sql.WHERE("1=1");
    }
}
