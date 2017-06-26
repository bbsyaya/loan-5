package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.ModuleEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shuttle on 6/26/17.
 */
public interface ModuleRepository extends PagingAndSortingRepository<ModuleEntity, Long>, CrudRepository<ModuleEntity, Long>, JpaSpecificationExecutor<ModuleEntity> {
}
