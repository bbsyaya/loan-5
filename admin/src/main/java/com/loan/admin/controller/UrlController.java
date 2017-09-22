package com.loan.admin.controller;

import com.loan.admin.consts.Constants;
import com.loan.common.beans.Result;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-22 10:51 PM
 * @company: 北京鼎力创世科技有限公司
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/url")
@Api(description = "开关相关")
public class UrlController {
    @ApiOperation(value = "url开关", notes = "url开关，返回url表示需要跳转，不返回表示不需要跳转", response = String.class)
    @RequestMapping(value = "/urlSwitch", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<String> urlSwitch() {
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
