package com.learn.service.inner;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public abstract class AbstractPay<T> {

    @Resource
    private StudentMapper studentMapper;

    public abstract T beforeExecute(T t);

    public final void execute(Student student, T t) {
        this.beforeExecute(t);

        insertAndDelete(student);

        this.afterExecute(t);
    }

    public abstract void afterExecute(T t);


    @Transactional
    public void insertAndDelete(Student student) {
        studentMapper.insertStudent(student);
        //studentMapper.delete(student.getId());
    }
}
