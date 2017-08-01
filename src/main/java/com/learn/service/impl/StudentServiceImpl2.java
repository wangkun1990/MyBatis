package com.learn.service.impl;

import com.learn.dao.StudentMapper2;
import com.learn.entity.Student;
import com.learn.service.inner.IStudentService2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl2 implements IStudentService2 {

    @Resource
    private StudentMapper2 studentMapper2;

    @Override
    public void addStudent(Student student) {
        studentMapper2.addStudent(student);
    }

    @Override
    public void deleteById(int id) {
        studentMapper2.deleteById(id);
    }

    @Transactional
    @Override
    public void addStudentAndDelete(Student student) {
        studentMapper2.addStudent(student);
        studentMapper2.deleteById(student.getId());
    }

    @Override
    public List<Student> getAllStudents2() {
        return studentMapper2.getAllStudents2();
    }
}
