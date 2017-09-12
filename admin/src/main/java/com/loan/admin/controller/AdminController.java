package com.loan.admin.controller;

/**
 * @Description: 管理员用户
 * @author: shuttle
 * @date: 2017-09-12 10:26 AM
 */
import com.loan.admin.consts.Constants;
import com.loan.common.beans.Result;
import com.loan.common.utils.ExceptionUtils;
import com.loan.datasource.entities.jpa.CooperationEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.BASE_URL + "/admin")
@Api(description = "合作商相关")
public class AdminController extends BaseController {

    @ApiOperation(value = "后台登录", notes = "后台登录", response = Boolean.class)
    @RequestMapping(value = "/getAdmin", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<String> getAdmin(@RequestParam("loginName") String loginName,
                                                          @RequestParam("pwd") String pwd) {
        Result<String> result = new Result<>();
        try {
            if(loginName.equals("admin") && pwd.equals("123456")) {
                return successResult("登录成功！");
            }
        } catch (Exception e) {
            ExceptionUtils.printException("getLoanWithType controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }

        return failResult(null, "登录失败！");
    }
}
