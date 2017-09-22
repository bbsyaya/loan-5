package com.loan.api.controller;

import com.loan.api.service.gourl.IGoUrlService;
import com.loan.common.beans.Result;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-22 11:16 PM
 */
@RestController
@RequestMapping("/url")
@Api(description = "跳转url")
public class GoUrlController extends BaseController {
    @Autowired
    IGoUrlService goUrlService;

    @ApiOperation(value = "跳转url", notes = "跳转url，默认为1", response = Result.class)
    @RequestMapping(value = "/getUrl", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<String> getUrl(){
        Result<String> result = new Result<>();
        try {
            String url = goUrlService.getUrl(1l);
            return successResult(url);
        }catch (Exception e){
            e.printStackTrace();
            ExceptionUtils.printException("getUrl controller报错：", e);
            return failResult(e);
        }
    }
}
