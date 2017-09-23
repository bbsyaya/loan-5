package com.loan.admin.service.hotloan.impl;

import com.loan.admin.service.hotloan.IFilesInfoService;
import com.loan.common.utils.DateUtils;
import com.loan.datasource.dao.springdata.FilesInfoRepository;
import com.loan.datasource.entities.jpa.FilesInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-23 10:23 PM
 */
@Service
public class FilesInfoServiceImpl implements IFilesInfoService {

    @Autowired
    FilesInfoRepository repository;

    @Override
    public FilesInfoEntity save(String name, String path) {
        FilesInfoEntity entity = new FilesInfoEntity();
        entity.setFileName(name);
        entity.setFilePath(path);
        entity.setFileType(10);
        entity.setUploadTime(DateUtils.getCurrentTimeStamp());
        return repository.save(entity);
    }
}
