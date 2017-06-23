package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by shuttle on 6/22/17.
 */
//@NoRepositoryBean
public interface AdminDaoRepository extends PagingAndSortingRepository<AdminEntity, Long>, CrudRepository<AdminEntity, Long> {
}
