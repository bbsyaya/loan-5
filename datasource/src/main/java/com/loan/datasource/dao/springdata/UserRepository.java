package com.loan.datasource.dao.springdata;

import com.loan.datasource.entities.jpa.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shuttle on 6/21/17.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByLoginNameAndPassword(String loginName, String pwd);
    UserEntity findByLoginName(String loginName);
    UserEntity findByMobile(String mobile);
}
