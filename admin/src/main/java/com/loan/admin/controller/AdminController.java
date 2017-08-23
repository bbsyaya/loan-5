package com.loan.admin.controller;

import com.loan.admin.consts.Constants;
import com.loan.admin.service.user.IAdmin;
import com.loan.common.beans.AdminBean;
import com.loan.common.beans.Result;
import com.loan.common.beans.UserBean;
import com.loan.common.params.AdminParam;
import com.loan.common.params.LoginParam;
import com.loan.common.params.PageParam;
import com.loan.common.utils.DateUtils;
import com.loan.common.utils.ExceptionUtils;
import com.loan.common.utils.SelfBeanUtils;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public Result<Page<AdminEntity>> getAdminList(@ModelAttribute PageParam pageParam,
                                                 HttpServletRequest request, HttpServletResponse response){
        try {
            if(pageParam.getPageNum() < 1){
                return failResult(null, "页码必须大于等于1.");
            }
            Page<AdminEntity> beanList = admin.getAdminListWithPaging(pageParam.getPageNum(), pageParam.getPageSize());
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
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "用户名", required = true, dataType = "AdminParam"),
    })
    public Result<Long> insertAdmin(@RequestBody AdminParam param,
                                        HttpServletRequest request, HttpServletResponse response){
        try {
            param.setId(null);
            AdminBean bean = new AdminBean();
            SelfBeanUtils.copyProperties(param, bean);
            if(admin.getAdminByName(param.getLoginName()) != null){
                return failResult(null, "该用户名已经存在！");
            }
            return successResult(admin.insertAdmin(bean));
        }catch (Exception e){
            ExceptionUtils.printException("insertAdmin controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "更新admin", notes = "更新admin", response = UserBean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "用户名", required = true, dataType = "AdminParam"),
    })
    @RequestMapping(value = "/updateAdmin", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<AdminBean> updateAdmin(@RequestBody AdminParam param,
                                         HttpServletRequest request, HttpServletResponse response){
        try {
            AdminBean bean = new AdminBean();
            BeanUtils.copyProperties(param, bean, "createTime", "updateTime");
            bean.setUpdateTime(DateUtils.getCurrentTimeStamp());
            admin.updateAdmin(bean);
            return successResult(bean);
        }catch (Exception e){
            ExceptionUtils.printException("updateAdmin controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

        @ApiOperation(value = "登录", notes = "登录", response = Boolean.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "用户名", required = true, dataType = "LoginParam"),
    })
    @RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = "application/json;charset=utf-8")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<Boolean> login(@RequestBody LoginParam param){
        try {
            boolean b = admin.login(param.getLoginName(), param.getLoginPwd()) == 1? true:false;
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
