package com.learn.service.inner;

import com.learn.entity.Department;
import com.learn.entity.Department2;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface IDepartmentService {

    public Department getDepartmentById(int id);

    public Department2 getDepartment2ById(int id);

    int insertDepartment(Department department);
}
