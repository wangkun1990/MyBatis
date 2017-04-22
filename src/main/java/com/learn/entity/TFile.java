package com.learn.entity;

import org.apache.ibatis.type.Alias;

/**
 * Created by wangkun on 2017/4/22.
 */
@Alias("file")
public class TFile {

    private Long id;

    //用来保存BLOB字段
    private byte[] file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
