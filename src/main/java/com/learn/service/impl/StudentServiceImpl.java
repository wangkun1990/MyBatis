package com.learn.service.impl;

import com.learn.dao.StudentMapper;
import com.learn.entity.Student;
import com.learn.entity.Student2;
import com.learn.service.inner.IStudentService;
import com.learn.service.inner.IStudentService2;
import org.springframework.aop.support.AopUtils;
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

    @Resource
    private IStudentService2 studentService2;

    @Override
    public Student getStudentById(int id) {
        System.err.println(StudentUtils.getStudent(id));
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
     *
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

    /**
     * 事务生效
     * @param student
     */
    @Override
    public void addStudent(Student student) {
        addStu(student);
    }

    public void addStu(Student student) {
        System.err.println("Student result = " + studentMapper.getAllStudents());
        studentService2.addStudentAndDelete(student);
    }


    /**
     * 事务不生效
     * @param student
     */
    @Override
    public void addStudent1(Student student) {
        privateAddStudent(student);
    }


    private void privateAddStudent(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.delete(student.getId());
    }

    /**
     * 事务不生效
     * @param student
     */
    @Override
    public void addStudent2(Student student) {
        publicAddStu(student);
    }

    public void publicAddStu(Student student) {
        System.err.println(studentService2.getAllStudents2());
        insertAndDeleteInner(student);
    }

    @Transactional
    public void insertAndDeleteInner(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.delete(student.getId());
    }

    /**
     * 事务不生效
     * @param student
     */
    @Override
    public void addStudent3(Student student) {
        self.publicAddStu(student);
    }

    @Override
    public void addStudent4(Student student) {
        System.err.println("isAopProxy = " + AopUtils.isAopProxy(self));
        System.err.println("isJdkDynamicProxy = " + AopUtils.isJdkDynamicProxy(self));
        System.err.println("isCglibProxy = " + AopUtils.isCglibProxy(self));
        System.err.println("isAopProxy = " + AopUtils.isAopProxy(studentService2));
        System.err.println("isJdkDynamicProxy = " + AopUtils.isJdkDynamicProxy(studentService2));
        System.err.println("isCglibProxy = " + AopUtils.isCglibProxy(studentService2));
        publicAddStu1(student);
    }

    public void publicAddStu1(Student student) {
        System.err.println(studentService2.getAllStudents2());
        self.insertAndDeleteInner(student);
    }

    @Override
    public void addStudent5(Student student) {
        self.addStuWithTransaction(student);
    }

    /**
     * 事务不生效
     * 1.默认修饰符
     * 2.private
     * 3.protect
     * 4.final
     * 5.static
     * @param student
     */
    @Transactional
    void addStuWithTransaction(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.delete(student.getId());
    }

    @Override
    public void addStudent6(Student student) {
        addStudent7(student);
    }

    @Override
    public void addStudent7(Student student) {
        self.publicTransaction(student);
    }

    @Transactional
    public void publicTransaction(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.delete(student.getId());
    }

    @Transactional
    @Override
    public void addAndDel(Student student) {
        studentMapper.insertStudent(student);
        studentMapper.delete(student.getId());
    }

    /**
     * 事务生效
     * @param student
     */
    public void addAndDeleteWithoutTransaction(Student student) {
        self.addAndDelete(student);
    }

    @Transactional
    public void addAndDelete(Student student) {
        addWithPrivate(student);
        studentMapper.delete(student.getId());
    }

    private void addWithPrivate(Student student) {
        studentService2.addStudent(student);
    }
}
