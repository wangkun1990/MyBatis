package com.learn.service.impl;

import com.learn.dao.FileMapper;
import com.learn.entity.TFile;
import com.learn.service.inner.IFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wangkun on 2017/4/22.
 */
@Service
public class FileServiceImpl implements IFileService {

    @Resource
    private FileMapper fileMapper;

    @Override
    public TFile getFile() {
        return fileMapper.getFile();
    }

    @Override
    public Long insertFile(TFile file) {
        return fileMapper.insertFile(file);
    }
}
