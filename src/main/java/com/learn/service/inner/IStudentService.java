package com.learn.service.inner;

import com.learn.entity.Student;
import com.learn.entity.Student2;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface IStudentService {

    public Student getStudentById(int id);

    public Student2 getStudent2ById(int id);

    public int insertStudent(Student student);

    public List<Student> getAllStudents();

    public void insertAndDelete(Student student);

    public void delete(int id);

    public void insertAndDeleteWithoutTransaction(Student student);

    public void insertAndDeleteWithTransaction(Student student);

    public void insertAndDeleteWithTransaction1(Student student);

    public void addStudent(Student student);

    public void addStudent1(Student student);

    public void addStudent2(Student student);

    public void addStudent3(Student student);

    public void addStudent4(Student student);

    public void addStudent5(Student student);

    public void addStudent6(Student student);

    public void addStudent7(Student student);


    public void addAndDel(Student student);

    void addAndDeleteWithoutTransaction(Student student);
}
