package com.loan.datasource.dao;

import com.loan.datasource.entities.User;
import com.loan.datasource.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuttle on 5/22/17.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserByPage(long limit, int page){
       return userMapper.getUserListByPage(limit, page);
    }

    public User getUserById(long id){
        return userMapper.getUserById(id);
    }

    public boolean login(String loginName, String pwd){
        return userMapper.login(loginName, pwd) == 1 ? true:false;
    }
}
