package com.loan.api.dao.repository;

import com.loan.api.dao.jpa.LogoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description: pvuv操作
 * @author: shuttle
 * @date: 2017-08-28 11:26 PM
 */
public interface LogoRepository extends CrudRepository<LogoEntity, Long> {
    List<LogoEntity> findByEnabledAndAndTypeOrderByCreateTimeDesc(Integer enabled, Integer type);
}
