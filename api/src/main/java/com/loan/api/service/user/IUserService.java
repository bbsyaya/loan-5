package com.loan.api.service.user;

import com.loan.common.beans.Result;
import com.loan.common.params.UserParam;
import com.loan.datasource.entities.jpa.UserEntity;

/**
 * @Description: 用户相关类
 * @author: shuttle
 * @date: 2017-08-24 1:05 AM
 */
public interface IUserService {
    UserEntity login(String loginName, String pwd);

    Result<UserEntity> register(UserParam param);

    UserEntity checkUser(String mobile);
}
