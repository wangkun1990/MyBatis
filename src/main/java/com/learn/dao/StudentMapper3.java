package com.learn.dao;

import com.learn.entity.Student;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public interface StudentMapper3 {

    /**
     *
     * @return
     */
    List<Student> getAllStudents();

    /**
     *
     * @return
     */
    List<Student> getAllStudents1();
}
