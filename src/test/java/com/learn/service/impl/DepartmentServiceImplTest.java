package com.learn.service.impl;

import com.learn.dao.DepartmentMapper;
import com.learn.entity.Department;
import com.learn.service.inner.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class DepartmentServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImplTest.class);

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setId(1);
        departmentService.insertDepartment(department);
    }

    @Test
    public void selectByPrimaryKey() {
        Department department = departmentMapper.selectByPrimaryKey(1);
        logger.info("result = " + department);
    }

    @Test
    public void updateAllColumnsByPrimary() {
        Department department = new Department();
        department.setId(1);
        department.setName("化学系");
        int rows = departmentMapper.updateAllColumnsByPrimary(department);
        logger.info("rows = " + rows);
    }

    @Test
    public void updateNotNullColumnsByPrimary() {
        Department department = new Department();
        department.setId(1);
        //department.setSex("男");
        department.setName("物理系");
        int rows = departmentMapper.updateNotNullColumnsByPrimary(department);
        logger.info("rows = " + rows);
    }

    @Test
    public void deleteByPrimary() {
        int row = departmentMapper.deleteByPrimary(10);
        logger.info("delete row = " + row);
    }

    @Test
    public void selectAllCountByParams() {
        Department department = new Department();
        int count = departmentMapper.selectAllCountByParams(department);
        logger.info("count = " + count);
    }

    @Test
    public void batchInsert() {
        List<Department> departments = new ArrayList<>();
        Department department = new Department();
        department.setId(3);
        department.setName("计算机系");
        departments.add(department);
        department = new Department();
        department.setId(4);
        department.setName("中文系");
        departments.add(department);
        department = new Department();
        department.setId(5);
        department.setName("化学系");
        departments.add(department);
        int rows = departmentMapper.batchInsert(departments);
        logger.info("rows = " + rows);
    }

    @Test
    public void insert() {
        Department department = new Department();
        department.setName("计算机系");
        departmentMapper.insert(department);
        System.out.println("id = " + department.getId());
    }
}