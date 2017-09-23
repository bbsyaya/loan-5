package com.loan.admin.service.hotloan;

import com.loan.datasource.entities.jpa.FilesInfoEntity;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-23 10:23 PM
 */
public interface IFilesInfoService {
    FilesInfoEntity save(String name, String path);
}
