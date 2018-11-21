package com.learn.service.inner;

import com.learn.entity.Student;
import com.learn.entity.Student2;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface IStudentService {

    Student getStudentById(int id);

    Student2 getStudent2ById(int id);

    int insertStudent(Student student);

    List<Student> getAllStudents();

    void insertAndDelete(Student student);

    void delete(int id);

    void insertAndDeleteWithoutTransaction(Student student);

    void insertAndDeleteWithTransaction(Student student);

    void insertAndDeleteWithTransaction1(Student student);

    void addStudent(Student student);

    void addStudent1(Student student);

    void addStudent2(Student student);

    void addStudent3(Student student);

    void addStudent4(Student student);

    void addStudent5(Student student);

    void addStudent6(Student student);

    void addStudent7(Student student);

    void addAndDel(Student student);

    void addAndDeleteWithoutTransaction(Student student);

    void addStudent8(Student student);

}
