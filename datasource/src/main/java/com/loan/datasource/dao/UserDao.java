package com.loan.datasource.dao;

import com.loan.datasource.entities.Users;
import com.loan.datasource.mappers.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by shuttle on 5/22/17.
 */
@Repository
public class UserDao {
    @Autowired
    private UsersMapper usersMapper;

    public int insertUser(Users users){
        return usersMapper.insert(users);
    }
}
