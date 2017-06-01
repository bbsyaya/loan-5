package com.loan.api.service.user;

import com.loan.common.beans.UserBean;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
public interface IUser {
    public List<UserBean> getUserList(long limit, int page) throws InstantiationException, IllegalAccessException;

    public List<UserBean> getUserList(UserBean bean, long limit, int page) throws InstantiationException, IllegalAccessException;

    public UserBean getUserById(long id);

    public UserBean insertUser(UserBean user) throws Exception;
}
