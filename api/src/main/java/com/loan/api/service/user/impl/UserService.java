package com.loan.api.service.user.impl;

import com.loan.api.service.user.IUserService;
import com.loan.common.beans.Result;
import com.loan.common.params.UserParam;
import com.loan.common.utils.DateUtils;
import com.loan.common.utils.DesUtils;
import com.loan.datasource.dao.springdata.UserRepository;
import com.loan.datasource.entities.jpa.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户实现类
 * @author: shuttle
 * @date: 2017-08-24 1:06 AM
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity login(String loginName, String pwd) {
        UserEntity entity = userRepository.findByLoginName(loginName);
        try {
            String up = DesUtils.decrypt(entity.getPassword());
            if(up.equals(pwd)){
                return entity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Result<UserEntity> register(UserParam param) {
        Result<UserEntity> result = new Result<>();
        UserEntity old = userRepository.findByLoginName(param.getLoginName());
        if(null != old){
            result.setCode(2);
            result.setMessage("该用户名已经注册！");
            return result;
        }
        UserEntity bean = new UserEntity();
        bean.setLoginName(param.getLoginName());
        try {
            String pwd = DesUtils.encrypt(param.getPassword());
            bean.setPassword(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bean.setEnabled((byte)1);
        bean.setEmail(param.getEmail());
        bean.setMobile(param.getMobile());
        bean.setPetName(param.getPetName());
        bean.setRegTime(DateUtils.getCurrentTimeStamp());

        UserEntity entity = userRepository.save(bean);
        if(null != entity) {
            result.setCode(1);
            result.setObj(entity);
            entity.setPassword("******");
            result.setMessage("注册成功！");
        }else{
            result.setCode(0);
            result.setObj(bean);
            result.setMessage("注册失败！");
        }
        return result;
    }

    @Override
    public UserEntity checkUser(String mobile) {
        return null;
    }
}
