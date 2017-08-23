package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.CooperationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shuttle on 6/21/17.
 */
@NoRepositoryBean
public interface CooperationRepository extends PagingAndSortingRepository<CooperationEntity, Long>, CrudRepository<CooperationEntity, Long>, JpaSpecificationExecutor<CooperationEntity> {
    Page<CooperationEntity> findAllByModuleId(long moduleId, Pageable pageable);
}
