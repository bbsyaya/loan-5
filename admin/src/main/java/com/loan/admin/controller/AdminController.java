package com.loan.admin.controller;

import com.loan.admin.consts.Constants;
import com.loan.admin.service.user.IAdmin;
import com.loan.common.beans.AdminBean;
import com.loan.common.beans.Result;
import com.loan.common.beans.UserBean;
import com.loan.common.params.AdminParam;
import com.loan.common.params.PageParam;
import com.loan.common.utils.ExceptionUtils;
import com.loan.common.utils.SelfBeanUtils;
import com.loan.datasource.entities.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by shuttle on 6/1/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/admin")
@Api(description = "用户相关")
public class AdminController extends BaseController {
    @Autowired
    IAdmin admin;

    @ApiOperation(value = "获取Admin列表", notes = "获取Admin列表", response = Admin.class)
    @RequestMapping(value = "/getAdminList", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<List<AdminBean>> getAdminList(@ModelAttribute AdminParam bean, @ModelAttribute PageParam pageParam,
                                                 HttpServletRequest request, HttpServletResponse response){
        try {
            List<AdminBean> beanList = admin.findAdminList(bean, pageParam.getLimit(), pageParam.getPage());
            return successResult(beanList);
        }catch (Exception e){
            ExceptionUtils.printException("getAdminList controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "根据admin id获取admin", notes = "根据admin id获取admin", response = AdminBean.class)
    @RequestMapping(value = "/getAdmin/{id}", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<AdminBean> getUserById(@PathVariable long id,
                                                HttpServletRequest request, HttpServletResponse response){
        try {
            AdminBean bean = admin.getAdminById(id);
            return successResult(bean);
        }catch (Exception e){
            ExceptionUtils.printException("getAdmin controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "插入admin", notes = "插入admin", response = UserBean.class)
    @RequestMapping(value = "/insertAdmin", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    public Result<Long> insertAdmin(@ModelAttribute AdminParam param,
                                        HttpServletRequest request, HttpServletResponse response){
        try {
            AdminBean bean = new AdminBean();
            SelfBeanUtils.copyProperties(param, bean);
            return successResult(admin.insertAdmin(bean));
        }catch (Exception e){
            ExceptionUtils.printException("insertAdmin controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "更新admin", notes = "更新admin", response = UserBean.class)
    @RequestMapping(value = "/updateAdmin", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    public Result<AdminBean> updateAdmin(@ModelAttribute AdminBean bean,
                                         HttpServletRequest request, HttpServletResponse response){
        try {
            admin.updateAdmin(bean);
            return successResult(bean);
        }catch (Exception e){
            ExceptionUtils.printException("updateAdmin controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "登录", notes = "登录", response = UserBean.class)
    @RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = "application/json;charset=utf-8")
    public Result<Boolean> login(@RequestBody Map<String, String> map){
        try {
            boolean b = admin.login(map.get("loginName"), map.get("pwd")) == 1? true:false;
            return successResult(b);
        }catch (Exception e){
            ExceptionUtils.printException("login controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "获取用户数量", notes = "获取用户数量", response = UserBean.class)
    @RequestMapping(value = "/adminCount", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<Integer> login(){
        try {
            int count = admin.adminCount();
            return successResult(count);
        }catch (Exception e){
            ExceptionUtils.printException("adminCount controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }
}
