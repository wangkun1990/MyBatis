package com.learn.entity;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wangkun on 2017/4/16.
 */
@Table(name = "dept")
public class Department implements Serializable {

    private int id;

    private String name;

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


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
