package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.CooperationEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shuttle on 6/21/17.
 */
//@NoRepositoryBean
public interface CoopRepository extends PagingAndSortingRepository<CooperationEntity, Long>, CrudRepository<CooperationEntity, Long>, JpaSpecificationExecutor<CooperationEntity> {
    //Page<CooperationEntity> findAllByModuleId(long moduleId, Pageable pageable);
    CooperationEntity findByAppName(String appName);
}
