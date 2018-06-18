package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDeleteProvide {

    private static Logger logger = LoggerFactory.getLogger(BaseDeleteProvide.class);

    public static String deleteByPrimary() {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        SQL deleteSql = new SQL().DELETE_FROM(dynamicEntityBean.getTableName())
                .WHERE(dynamicEntityBean.getPrimaryKeyColumn() + " = " + "#{id}");
        logger.info("deleteByPrimary sq; = {}", deleteSql);
        return deleteSql.toString();
    }
}
