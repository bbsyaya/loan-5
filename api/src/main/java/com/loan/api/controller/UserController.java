package com.loan.api.controller;

import com.loan.api.consts.Constants;
import com.loan.api.service.user.IUser;
import com.loan.common.beans.Result;
import com.loan.common.beans.UserBean;
import com.loan.common.params.PageParam;
import com.loan.common.params.UserParam;
import com.loan.common.utils.ExceptionUtils;
import com.loan.common.utils.Md5Utils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/user")
@Api(description = "用户相关")
public class UserController extends BaseController {
    @Autowired
    IUser user;

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = UserBean.class)
    @RequestMapping(value = "/getUserList", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<List<UserBean>> getUserByPage(@ModelAttribute PageParam pageParam,
                                                HttpServletRequest request, HttpServletResponse response){
        try {
            List<UserBean> beanList = user.getUserList(pageParam.getPageNum(), pageParam.getPageSize());
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
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "根据用户id获取用户信息", notes = "根据用户id获取用户信息", response = UserBean.class)
    @RequestMapping(value = "/getUserByCondition", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<List<UserBean>> getUserByCondition(@ModelAttribute UserParam param, @ModelAttribute PageParam pageParam,
                                        HttpServletRequest request, HttpServletResponse response){
        try {
            UserBean bean = new UserBean();
            bean.setMobile(param.getMobile());
            bean.setLoginName(param.getLoginName());
            List<UserBean> beanList = user.getUserList(bean, pageParam.getPageNum(), pageParam.getPageSize());
            return successResult(beanList);
        }catch (Exception e){
            ExceptionUtils.printException("getUserById controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "用户注册", notes = "用户注册", response = boolean.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "param", value = "用户名", required = true, dataType = "UserParam"),
    })
    @RequestMapping(value = "/register", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<Boolean> register(@RequestBody UserParam param){
        try {
            UserBean bean = new UserBean();
            bean.setLoginName(param.getLoginName());
            bean.setPassword(Md5Utils.stringMD5(param.getPassword()));
            bean = user.insertUser(bean);
            if(null != bean){
                return successResult(Boolean.TRUE);
            }else{
                return failResult(Boolean.FALSE, "该用户已经存在！");
            }
        }catch (Exception e){
            ExceptionUtils.printException("register controller报错：", e);
            e.printStackTrace();
        }
        return failResult(Boolean.FALSE, "注册失败！");
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", response = boolean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pwd", value = "密码", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/login", method = { RequestMethod.POST}, produces = "application/json;charset=utf-8")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<Boolean> login(@RequestParam("loginName") String loginName, @RequestParam("pwd") String pwd){
        try {
            if(user.login(loginName, Md5Utils.stringMD5(pwd))){
                return successResult(Boolean.TRUE, "登录成功！");
            }
        }catch (Exception e){
            ExceptionUtils.printException("login controller报错：", e);
            e.printStackTrace();
        }
        return failResult(Boolean.FALSE, "登录失败！");
    }
}
