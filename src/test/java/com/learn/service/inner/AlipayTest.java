package com.learn.service.inner;

import com.learn.entity.Department;
import com.learn.entity.Student;
import com.learn.service.impl.Alipay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class AlipayTest {

    @Autowired
    private AbstractPay pay;

    @Test
    public void testExecute() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        pay.execute(student);
    }
}
