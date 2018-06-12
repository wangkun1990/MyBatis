package com.learn.mybatis.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringNull2EmptyHandler implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if (StringUtils.isBlank(s)) {
            preparedStatement.setString(i, StringUtils.EMPTY);
        } else {
            preparedStatement.setString(i, s);
        }

    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
