package com.loan.api.dao.repository;

import com.loan.api.dao.jpa.CooperationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shuttle on 6/21/17.
 */
//@NoRepositoryBean
public interface CoopRepository extends PagingAndSortingRepository<CooperationEntity, Long>, CrudRepository<CooperationEntity, Long>, JpaSpecificationExecutor<CooperationEntity> {
    //Page<CooperationEntity> findAllByModuleId(long moduleId, Pageable pageable);
}
