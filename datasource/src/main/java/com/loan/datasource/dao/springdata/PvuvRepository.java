package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.PvuvEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description: pvuv操作
 * @author: shuttle
 * @date: 2017-08-28 11:26 PM
 */
public interface PvuvRepository extends CrudRepository<PvuvEntity, Long> {
}
