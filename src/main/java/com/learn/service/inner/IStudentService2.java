package com.learn.service.inner;

import com.learn.entity.Student;
import com.learn.entity.Student2;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface IStudentService2 {

    public void addStudent(Student student);

    public void deleteById(int id);

    public void addStudentAndDelete(Student student);

    public List<Student> getAllStudents2();
}
