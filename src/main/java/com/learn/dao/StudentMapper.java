package com.learn.dao;

import com.learn.entity.Student;
import com.learn.entity.Student2;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface StudentMapper {

    public Student getStudentById(int id);

    public Student2 getStudent2ById(int id);

    public int insertStudent(Student student);

    public List<Student> getAllStudents();

    public void delete(int id);
}
