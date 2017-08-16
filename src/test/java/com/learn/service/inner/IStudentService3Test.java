package com.learn.service.inner;

import com.learn.entity.Department;
import com.learn.entity.Department2;
import com.learn.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.learn.service.impl.StudentServiceImpl3;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class IStudentService3Test {

    @Resource
    private StudentServiceImpl3 studentServiceImpl3;

    private Student assembleStudent() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        return student;
    }

    @Test
    public void testAddStudent() {
        ReflectionTestUtils.invokeMethod(studentServiceImpl3, "addStudent",assembleStudent());
    }

}
