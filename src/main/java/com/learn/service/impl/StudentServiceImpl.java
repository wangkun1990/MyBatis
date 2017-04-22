package com.learn.service.impl;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import com.learn.entity.Student2;
import com.learn.service.inner.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public Student2 getStudent2ById(int id) {
        return studentMapper.getStudent2ById(id);
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }
}
