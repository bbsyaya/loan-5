package com.loan.datasource.service.impl;

import com.loan.datasource.dao.UserDao;
import com.loan.datasource.service.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shuttle on 5/23/17.
 */
@Service
public class Test implements ITest {

    @Autowired
    UserDao userDao;

    public void test() {
//        Users user = new Users();
//        user.setIdCard("123");
//        user.setEmail("abd@12.com");
//        user.setLoginName("aa");
//        user.setLoginPwd("aa");
//        user.setUserName("test");
//        user.setMobile("12324234");
//        userDao.insertUser(user);
    }
}
