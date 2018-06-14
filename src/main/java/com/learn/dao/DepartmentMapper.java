package com.learn.dao;

import com.learn.entity.Department;
import com.learn.entity.Department2;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface DepartmentMapper {

    Department getDepartmentById(int id);


    Department2 getDepartment2ById(int id);

    /**
     * @param department
     * @return
     */
    int insertDepartment(Department department);
}
