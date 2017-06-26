package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.CooperationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shuttle on 6/21/17.
 */
//@NoRepositoryBean
public interface CooperationRepository extends PagingAndSortingRepository<CooperationEntity, Long>, CrudRepository<CooperationEntity, Long>, JpaSpecificationExecutor<CooperationEntity> {
//    @Query("select c.*" +
//            "from cooperation c " +
//            "inner join cooperation_type t on c.id = t.cooperation_id " +
//            "where t.module_id=?1 " +
//            "and enabled=1 /*#pageable}*/"，
//            nativeQuery = true)
//    public List<CooperationEntity> findByTypePageing(long type, int pageNum, int PageSize);

    public Page<CooperationEntity> findAllByModules_Id(long moduleId, Pageable pageable);
}
