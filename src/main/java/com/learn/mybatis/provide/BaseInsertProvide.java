package com.learn.mybatis.provide;

import com.learn.mybatis.bean.DynamicColumnBean;
import com.learn.mybatis.bean.DynamicEntityBean;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.GenerationType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseInsertProvide {

    private Logger logger = LoggerFactory.getLogger(BaseInsertProvide.class);


    public String insert(Object object) {
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean();
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
        DynamicEntityBean dynamicEntityBean = DynamicEntityBeanFactory.getEntityBean();
        List<DynamicColumnBean> dynamicColumnBeans = dynamicEntityBean.getInsertColumnsList();
        removeAutoIncreseId(dynamicColumnBeans);
        StringBuilder sqlBuilder = new StringBuilder("insert into ").append(dynamicEntityBean.getTableName()).append(" (");
        sqlBuilder.append(convertToInsertColumns(dynamicColumnBeans)).append(")");
        sqlBuilder.append(" values ");

        List<?> listParams = (List<?>) params.get("list");
        //List<String> values = new ArrayList<>();
        for (int i = 0; i < listParams.size(); i++) {
            sqlBuilder.append("(");
            for (int j = 0, length = dynamicColumnBeans.size(); j < length; j++) {
                sqlBuilder.append("#{list[").append(i).append("].").append(dynamicColumnBeans.get(j).getFieldName()).append("}");
                if (j != length - 1) {
                    sqlBuilder.append(",");
                }
            }
            sqlBuilder.append(")");
            if (i < listParams.size() - 1) {
                sqlBuilder.append(",");
            }
        }
        logger.info("batchInsert sql = {}", sqlBuilder);
        return sqlBuilder.toString();
    }


    private void removeAutoIncreseId(List<DynamicColumnBean> dynamicColumnBeans) {
        Iterator<DynamicColumnBean> iterator = dynamicColumnBeans.iterator();
        while (iterator.hasNext()) {
            DynamicColumnBean dynamicColumnBean = iterator.next();
            if (dynamicColumnBean.isPrimaryKey() && dynamicColumnBean.getGenerationType().equals(GenerationType.AUTO)) {
                iterator.remove();
            }
        }
    }

    private String convertToInsertColumns(List<DynamicColumnBean> dynamicColumnBeans) {
        List<String> columns = dynamicColumnBeans.stream().map(DynamicColumnBean::getColumnName).collect(Collectors.toList());
        return String.join(",", columns);
    }
}
