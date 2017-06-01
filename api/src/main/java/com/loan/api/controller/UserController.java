package com.loan.api.controller;

import com.loan.api.service.user.IUser;
import com.loan.common.beans.Result;
import com.loan.common.beans.UserBean;
import com.loan.common.params.PageParam;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户相关")
public class UserController extends BaseController {
    @Autowired
    IUser user;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = UserBean.class)
    @RequestMapping(value = "/getUserList", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<List<UserBean>> getUserByPage(@ModelAttribute PageParam pageParam,
                                                HttpServletRequest request, HttpServletResponse response){
        try {
            List<UserBean> beanList = user.getUserList(pageParam.getLimit(), pageParam.getPage());
            return successResult(beanList);
        }catch (Exception e){
            ExceptionUtils.printException("getUserByPage controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "根据用户id获取用户信息", notes = "根据用户id获取用户信息", response = UserBean.class)
    @RequestMapping(value = "/getUserById/{id}", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<UserBean> getUserById(@PathVariable long id,
                                                HttpServletRequest request, HttpServletResponse response){
        try {
            UserBean bean = user.getUserById(id);
            return successResult(bean);
        }catch (Exception e){
            ExceptionUtils.printException("getUserById controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "插入用户", notes = "插入用户", response = UserBean.class)
    @RequestMapping(value = "/insertUser", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    public Result<UserBean> insertUser(@ModelAttribute UserBean bean,
                                        HttpServletRequest request, HttpServletResponse response){
        try {
            bean = user.insertUser(bean);
            if(null != bean.getId()){
                return successResult(bean);
            }
        }catch (Exception e){
            ExceptionUtils.printException("insertUser controller报错：", e);
            e.printStackTrace();
        }
        return null;
    }
}
