package com.loan.datasource;

import com.loan.datasource.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
/**
 * Created by shuttle on 5/22/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@TestPropertySource(locations = "file:/Users/shuttle/develop/loan/datasource/src/main/resources/jdbc.properties")
public class DatasourceTest {

    @Autowired
    UserDao dao;

    @Test
    public void checkUser() {
//        Users user = new Users();
//        user.setIdCard("123");
//        user.setEmail("abd@12.com");
//        user.setLoginName("aa");
//        user.setLoginPwd("aa");
//        user.setUserName("test");
//        dao.insertUser(user);
    }
}