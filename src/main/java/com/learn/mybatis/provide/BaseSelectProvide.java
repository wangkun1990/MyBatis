package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseSelectProvide {

    private static Logger logger = LoggerFactory.getLogger(BaseSelectProvide.class);

    public static String selectByPrimaryKey() {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        SQL sql = new SQL().SELECT(dynamicEntityBean.getSelectColumns()).FROM(dynamicEntityBean.getTableName()).WHERE(dynamicEntityBean.getPrimaryKeyColumn() + " = #{id}");
        logger.info("selectByPrimaryKey sql = {}", sql);
        return sql.toString();
    }

    public static String selectAllCountByParams() {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        SQL countSql = new SQL().SELECT("count(*)").FROM(dynamicEntityBean.getTableName()).WHERE("1=1");
        logger.info("selectAllCountByParams countSql = {}", countSql);
        return countSql.toString();
    }
}
