package com.learn.service.inner;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public abstract class AbstractPay {

    @Resource
    private StudentMapper studentMapper;

    public abstract void beforeExecute();

    public final void execute(Student student) {
        this.beforeExecute();

        insertAndDelete(student);

        this.afterExecute();
    }

    public abstract void afterExecute();


    @Transactional
    public void insertAndDelete(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.delete(student.getId());
    }
}
