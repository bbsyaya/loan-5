package com.loan.api.dao.repository;

import com.loan.api.dao.jpa.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shuttle on 6/21/17.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByLoginNameAndPassword(String loginName, String pwd);
    UserEntity findByLoginName(String loginName);
    UserEntity findByMobile(String mobile);
}
