package com.learn.service.inner;

import com.learn.entity.TFile;

/**
 * Created by wangkun on 2017/4/22.
 */
public interface IFileService {

    public TFile getFile();

    public Long insertFile(TFile file);
}
