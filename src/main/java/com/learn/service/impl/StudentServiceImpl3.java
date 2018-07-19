package com.learn.service.impl;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl3 {

    @Resource
    private StudentMapper studentMapper;


    private void addStudent(Student student) {
       add(student);
    }

    @Transactional
    public void add(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.deleteByPrimary(student.getId());
    }

}