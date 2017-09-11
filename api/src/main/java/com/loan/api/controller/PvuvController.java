package com.loan.api.controller;

import com.loan.api.consts.Constants;
import com.loan.api.service.user.IPvuvService;
import com.loan.common.beans.Result;
import com.loan.common.params.PuvParam;
import com.loan.common.utils.ExceptionUtils;
import com.loan.datasource.entities.jpa.PvuvEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: pvuv
 * @author: shuttle
 * @date: 2017-08-28 11:30 PM
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/puv")
@Api(description = "pvuv相关")
public class PvuvController extends BaseController {

    @Autowired
    private IPvuvService pvuvService;

    @ApiOperation(value = "埋点", notes = "", response = PuvParam.class)
    @RequestMapping(value = "/bury", method = { RequestMethod.PUT }, produces = "application/json;charset=utf-8")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<PvuvEntity> getHotLoan(@RequestBody PuvParam param,
                                         HttpServletRequest request, HttpServletResponse response){
        try {
            PvuvEntity entity = pvuvService.savePvuvEntity(param);
            return successResult(entity);
        }catch (Exception e){
            ExceptionUtils.printException("getHotLoan controller报错：", e);
            return failResult(e);
        }
    }
}
