package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.CooperationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shuttle on 6/21/17.
 */
//@NoRepositoryBean
public interface CooperationRepository extends PagingAndSortingRepository<CooperationEntity, Long>, CrudRepository<CooperationEntity, Long> {

//    @Query(value = "select c.* from cooperation c inner join cooperation_type t on c.id = t.cooperation_id where t.module_id=?1 and enabled=1 limit ?2,?3", nativeQuery = true)
//    public List<Cooperation> getCooperationByTypeAndPage(int moduleId, long skip, int page);
}
