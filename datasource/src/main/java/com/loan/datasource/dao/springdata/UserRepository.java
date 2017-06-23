package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
//@NoRepositoryBean
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long>, CrudRepository<UserEntity, Long> {
    public List<UserEntity> findAll();
    public UserEntity findOne(Long id);
    public UserEntity save(UserEntity todo);
    public void delete(Long id);

}
