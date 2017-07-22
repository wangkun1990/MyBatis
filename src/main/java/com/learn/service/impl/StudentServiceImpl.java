package com.learn.service.impl;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import com.learn.entity.Student2;
import com.learn.service.inner.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentServiceImpl self;

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

    @Transactional
    @Override
    public void insertAndDelete(Student student) {
        insertStudent(student);
        delete(student.getId());
    }

    @Override
    public void delete(int id) {
        studentMapper.delete(id);
    }

    /**
     * 有异常不会回滚
     * @param student
     */
    @Override
    public void insertAndDeleteWithoutTransaction(Student student) {
        insertAndDelete(student);
    }

    @Transactional
    @Override
    public void insertAndDeleteWithTransaction(Student student) {
        insertAndDelete(student);
    }

    @Override
    public void insertAndDeleteWithTransaction1(Student student) {
        self.insertAndDelete(student);
    }
}
