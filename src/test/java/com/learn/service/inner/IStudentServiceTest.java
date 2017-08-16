package com.learn.service.inner;

import com.learn.dao.StudentMapper;
import com.learn.entity.Department;
import com.learn.entity.Department2;
import com.learn.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml"})
public class IStudentServiceTest {

    @Resource
    IStudentService studentService;

    @Resource
    IDepartmentService departmentService;

    @Test
    public void testInsertStudent() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        int result = studentService.insertStudent(student);
        System.err.println("result = " + student.getId());
    }

    @Test
    public void testGetStudentById() {
        Student student = studentService.getStudentById(2);
        System.out.println(student);
    }

    @Test
    public void testGetDepartment2ById() {
        Department2 department2 = departmentService.getDepartment2ById(1);
        System.out.println(department2.getName());
       // System.out.println(department2.getStudents());
    }

    @Test
    public void testGetAllStudent() {
        List<Student> students = studentService.getAllStudents();
        System.out.println("size = " + students.size());
    }

    @Test
    public void testInsertAndDelete() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.insertAndDelete(student);
    }

    @Test
    public void testInsertAndDeleteWithoutTransaction() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.insertAndDeleteWithoutTransaction(student);
    }

    @Test
    public void TestInsertAndDeleteWithTransaction() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.insertAndDeleteWithTransaction(student);
    }

    @Test
    public void TestInsertAndDeleteWithTransaction1() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.insertAndDeleteWithTransaction1(student);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.addStudent(student);
    }

    @Test
    public void testAddStudent1() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.addStudent1(student);
    }

    @Test
    public void testAddStudent2() {
        Student student = new Student();
        Department department = new Department();
        department.setId(2);
        student.setDepartment(department);
        student.setName("侯亮平");
        student.setSex("0");
        studentService.addStudent2(student);
    }

    @Test
    public void testAddStudent3() {
        studentService.addStudent3(assembleStudent());
    }

    @Test
    public void testAddStudent4() {
        studentService.addStudent4(assembleStudent());
    }

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
    public void testAddStudent5() {
        //studentService.addStudent5(assembleStudent());
        studentService.getStudentById(1);
    }

}
