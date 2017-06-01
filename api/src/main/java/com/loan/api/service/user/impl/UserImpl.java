package com.loan.api.service.user.impl;

import com.loan.api.service.user.IUser;
import com.loan.common.beans.UserBean;
import com.loan.common.utils.CopyBeanUtils;
import com.loan.datasource.dao.UserDao;
import com.loan.datasource.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
@Service
public class UserImpl implements IUser {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserBean> getUserList(long limit, int page)
            throws InstantiationException, IllegalAccessException {
        CopyBeanUtils<UserBean> copyBeanUtils = new CopyBeanUtils();
        return copyBeanUtils.copyBeanUtils(UserBean.class, userDao.getUserByPage(limit, page));
    }

    @Override
    public List<UserBean> getUserList(UserBean bean, long limit, int page)
            throws InstantiationException, IllegalAccessException {
        User user = new User();
        BeanUtils.copyProperties(bean, user);
        CopyBeanUtils<UserBean> copyBeanUtils = new CopyBeanUtils();
        return copyBeanUtils.copyBeanUtils(UserBean.class, userDao.getUserByPage(user, limit, page));
    }

    @Override
    public UserBean getUserById(long id) {
        UserBean bean = new UserBean();
        BeanUtils.copyProperties(userDao.getUserById(id), bean);
        return bean;
    }

    @Override
    public UserBean insertUser(UserBean bean) throws Exception {
        User user = new User();
        BeanUtils.copyProperties(bean, user);
        BeanUtils.copyProperties(userDao.insertUser(user), bean);
        return bean;
    }
}
