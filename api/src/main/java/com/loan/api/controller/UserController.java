package com.loan.api.controller;

import com.loan.api.consts.Constants;
import com.loan.api.dao.jpa.UserEntity;
import com.loan.api.service.user.IUserService;
import com.loan.common.beans.Result;
import com.loan.common.params.UserParam;
import com.loan.common.utils.AesUtil;
import com.loan.common.utils.DateUtils;
import com.loan.common.utils.ExceptionUtils;
import com.loan.common.utils.Md5Utils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by shuttle on 6/1/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/user")
@Api(description = "用户相关")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;
//    @Autowired
//    IUser user;
//
//    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = UserBean.class)
//    @RequestMapping(value = "/getUserList", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
//    public Result<List<UserBean>> getUserByPage(@ModelAttribute PageParam pageParam,
//                                                HttpServletRequest request, HttpServletResponse response){
//        try {
//            List<UserBean> beanList = user.getUserList(pageParam.getPageNum(), pageParam.getPageSize());
//            return successResult(beanList);
//        }catch (Exception e){
//            ExceptionUtils.printException("getUserByPage controller报错：", e);
//            return failResult(e);
//        }
//    }
//
//    @ApiOperation(value = "根据用户id获取用户信息", notes = "根据用户id获取用户信息", response = UserBean.class)
//    @RequestMapping(value = "/getUserById/{id}", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
//    public Result<UserBean> getUserById(@PathVariable long id,
//                                                HttpServletRequest request, HttpServletResponse response){
//        try {
//            UserBean bean = user.getUserById(id);
//            return successResult(bean);
//        }catch (Exception e){
//            ExceptionUtils.printException("getUserById controller报错：", e);
//            e.printStackTrace();
//            return failResult(e);
//        }
//    }
//
//    @ApiOperation(value = "根据用户id获取用户信息", notes = "根据用户id获取用户信息", response = UserBean.class)
//    @RequestMapping(value = "/getUserByCondition", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
//    public Result<List<UserBean>> getUserByCondition(@ModelAttribute UserParam param, @ModelAttribute PageParam pageParam,
//                                        HttpServletRequest request, HttpServletResponse response){
//        try {
//            UserBean bean = new UserBean();
//            bean.setMobile(param.getMobile());
//            bean.setLoginName(param.getLoginName());
//            List<UserBean> beanList = user.getUserList(bean, pageParam.getPageNum(), pageParam.getPageSize());
//            return successResult(beanList);
//        }catch (Exception e){
//            ExceptionUtils.printException("getUserById controller报错：", e);
//            e.printStackTrace();
//            return failResult(e);
//        }
//    }
//
    @ApiOperation(value = "用户注册", notes = "用户注册", response = boolean.class)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "param", value = "用户名", required = true, dataType = "UserParam"),
    })
    @RequestMapping(value = "/register", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<UserEntity> register(@RequestBody UserParam param){
        try {
            Result<UserEntity> result = userService.register(param);
            return result;
        }catch (Exception e){
            ExceptionUtils.printException("register controller报错：", e);
            e.printStackTrace();
        }
        return failResult();
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
    public Result<UserEntity> login(@RequestParam("loginName") String loginName, @RequestParam("pwd") String pwd){
        try {
            Result<UserEntity> result = new Result<>();
            UserEntity entity = userService.login(loginName, pwd);
            entity.setPassword("******");
            if(null != entity){
                result.setMessage("登录成功！");
                result.setObj(entity);
                result.setCode(1);
                return result;
            }
        }catch (Exception e){
            ExceptionUtils.printException("login controller报错：", e);
            e.printStackTrace();
        }
        return failResult(null, "登录失败！");
    }
}
