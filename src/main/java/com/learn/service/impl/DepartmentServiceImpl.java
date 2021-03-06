package com.learn.service.impl;

import com.learn.dao.DepartmentMapper;
import com.learn.entity.Department;
import com.learn.entity.Department2;
import com.learn.service.inner.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangkun on 2017/4/16.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Resource
    public DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public Department2 getDepartment2ById(int id) {
        return departmentMapper.getDepartment2ById(id);
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department);
    }
}
