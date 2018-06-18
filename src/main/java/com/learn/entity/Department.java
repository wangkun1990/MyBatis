package com.learn.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by wangkun on 2017/4/16.
 */
@Table(name = "dept")
@Data
public class Department implements Serializable {

    @Column(name = "department_id")
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    //private String sex;

}
