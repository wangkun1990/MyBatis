package com.learn.entity;

import java.util.List;

/**
 * Created by wangkun on 2017/4/16.
 */
public class Department2 {

    private int id;

    private String name;

    private List<Student2> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student2> getStudents() {
        return students;
    }

    public void setStudents(List<Student2> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
