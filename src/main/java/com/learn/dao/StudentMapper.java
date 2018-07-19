package com.learn.dao;

import com.learn.entity.Student;
import com.learn.entity.Student2;
import com.learn.mybatis.mapper.BaseMapper;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface StudentMapper extends BaseMapper<Student> {

    Student getStudentById(int id);

    Student2 getStudent2ById(int id);

    int insertStudent(Student student);

    List<Student> getAllStudents();

    int delete(Integer id);

}
