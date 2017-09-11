package com.loan.api.controller;

import com.loan.api.consts.Constants;
import com.loan.api.service.logo.ILogoService;
import com.loan.common.beans.Result;
import com.loan.common.utils.ExceptionUtils;
import com.loan.datasource.entities.jpa.LogoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shuttle on 5/25/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/logo")
@Api(description = "logo相关")
public class LogoController extends BaseController  {

    @Autowired
    private ILogoService logoService;

    @ApiOperation(value = "获取最新的logo", notes = "获取最新的logo", response = Result.class)
    @RequestMapping(value = "/getLogo", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<LogoEntity> getHotLoan(){
        LogoEntity entity = logoService.getLastEnabledLogo();
        try {
            return successResult(entity);
        }catch (Exception e){
            ExceptionUtils.printException("getLogo controller报错：", e);
            return failResult(e);
        }
    }
}
