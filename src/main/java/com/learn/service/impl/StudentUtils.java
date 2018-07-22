package com.learn.service.impl;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StudentUtils {
    private static StudentMapper staticStudentMapper;

    @Resource
    public void setStudentMapper(StudentMapper studentMapper) {
        StudentUtils.staticStudentMapper = studentMapper;
    }

    public static Student getStudent(int id) {
        return staticStudentMapper.selectByPrimaryKey(id);
    }
}
