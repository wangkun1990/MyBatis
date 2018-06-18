package com.learn.mybatis.provide;

import com.alibaba.fastjson.JSON;
import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BaseInsertProvide {

    private Logger logger = LoggerFactory.getLogger(BaseInsertProvide.class);

    public String batchInsert(List<Object> params) {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean(daoInterfaceInfo.getGenericClass());
        SQL insertSql = new SQL().INSERT_INTO(dynamicEntityBean.getTableName());
        for (Object object : params) {


        }
        logger.info("batchInsert insertSql = {}", insertSql);

        return  null;
    }

}
