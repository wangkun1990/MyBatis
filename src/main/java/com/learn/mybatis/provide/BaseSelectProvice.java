package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DaoInterfaceBean;
import com.learn.mybatis.interceptor.DaoMethodInterceptor;
import org.apache.ibatis.jdbc.SQL;

import javax.persistence.Table;

public class BaseSelectProvice {

    public static String selectByPrimaryKey() {
        DaoInterfaceBean daoInterfaceInfo = DaoMethodInterceptor.getDaoInterfaceInfo();
        Table table = daoInterfaceInfo.getGenericClass().getAnnotation(Table.class);
        if (table == null) {
            throw new RuntimeException("没有配置table注解");
        }
        String tableName = table.name();
        SQL sql = new SQL().SELECT("name").FROM(tableName).WHERE("department_id = " + "#{id}");

        return sql.toString();
    }
}
