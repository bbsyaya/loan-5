package com.loan.api.controller;

import com.loan.api.service.modules.IModules;
import com.loan.common.beans.ModuleBean;
import com.loan.common.beans.Result;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shuttle on 5/30/17.
 */
@RestController
@RequestMapping("/module")
@Api(description = "模块相关")
public class ModuleController extends BaseController{
    @Autowired
    IModules modules;

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    /**
     * 获取首页显示的模块
     * @return
     */
    @ApiOperation(value = "获取首页显示的模块", notes = "获取首页显示的模块", response = ModuleBean.class)
    @RequestMapping(value = "/getIndexModule", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<List<ModuleBean>> getIndexModule(){
        try {
            List<ModuleBean> beanList = modules.getIndexModule();
            return successResult(beanList);
        }catch (Exception e){
            ExceptionUtils.printException("getIndexModule controller报错：", e);
            return failResult(e);

        }
    }
}
