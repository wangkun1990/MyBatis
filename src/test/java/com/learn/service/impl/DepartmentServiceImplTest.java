package com.learn.service.impl;

import com.learn.entity.Department;
import com.learn.service.inner.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class DepartmentServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(DepartmentServiceImplTest.class);

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setId(1);
        departmentService.insertDepartment(department);
    }
}