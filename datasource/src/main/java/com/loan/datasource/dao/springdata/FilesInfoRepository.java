package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.FilesInfoEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-23 10:22 PM
 */
public interface FilesInfoRepository extends CrudRepository<FilesInfoEntity, Long> {
}
