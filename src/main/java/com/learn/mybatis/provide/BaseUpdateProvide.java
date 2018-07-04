package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicColumnBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import com.learn.mybatis.util.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.List;

public class BaseUpdateProvide {

    private static Logger logger = LoggerFactory.getLogger(BaseUpdateProvide.class);

    public static String updateAllColumnsByPrimary(Object target) {
       return getUpdateSql(target, true);
    }


    public static String updateNotNullColumnsByPrimary(Object target) {
        return getUpdateSql(target, false);
    }


    /**
     * 组装更新字段
     *
     * @param object
     * @param updateAllColumns
     * @return
     */
    private static String getUpdateSql(Object object, boolean updateAllColumns) {
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean();
        SQL updateSql = new SQL().UPDATE(dynamicEntityBean.getTableName());
        List<DynamicColumnBean> dynamicColumnBeans = dynamicEntityBean.getUpdateColumnsList();
        for (DynamicColumnBean dynamicColumnBean : dynamicColumnBeans) {
            if (!updateAllColumns) {
                Object result = BeanUtils.getPropertyValue(object, dynamicColumnBean.getFieldName());
                if (result == null) {
                    continue;
                }
            }
            updateSql.SET(dynamicColumnBean.getColumnName() + " = #{" + dynamicColumnBean.getFieldName() + "}");
        }
        updateSql.WHERE(dynamicEntityBean.getPrimaryKeyColumn() + " = #{" + dynamicEntityBean.getPrimaryKeyField() + "}");
        logger.info("updateSql = {}", updateSql);
        return updateSql.toString();
    }
}
