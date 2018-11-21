package com.learn.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Student implements Serializable {

    @Column(name = "stu_id")
    @Id
    private  int id;

    private String name;

    private String sex;

    private Integer depId;

    @Column(name = "dep_id")
    private Department department;

}
