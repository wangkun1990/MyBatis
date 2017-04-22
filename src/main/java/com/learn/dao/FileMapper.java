package com.learn.dao;

import com.learn.entity.TFile;

/**
 * Created by wangkun on 2017/4/22.
 */
public interface FileMapper {

    public TFile getFile();

    public Long insertFile(TFile file);
}
