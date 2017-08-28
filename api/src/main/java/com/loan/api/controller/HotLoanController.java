package com.loan.api.controller;

import com.loan.api.dao.jpa.CooperationEntity;
import com.loan.api.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.beans.Result;
import com.loan.common.params.LoanParam;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
@RestController
@RequestMapping("/loan")
@Api(description = "合作商相关")
public class HotLoanController extends BaseController  {

    @Autowired
    private ICooperation cooperation;

    @ApiOperation(value = "获取热门贷款列表", notes = "获取热门贷款列表，0 全部 1 极速放贷 2 帮你推荐 3 办信用卡 4 热门贷款", response = Result.class)
    @RequestMapping(value = "/getHotLoan", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<Page<CooperationEntity>> getHotLoan(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize,
                                                      HttpServletRequest request, HttpServletResponse response){
        Result<List<CooperationBean>> result = new Result<List<CooperationBean>>();
        try {
            Page<CooperationEntity> beanList = cooperation.getCooperationBeanByType(pageNum, pageSize);
            return successResult(beanList);
        }catch (Exception e){
            ExceptionUtils.printException("getHotLoan controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "根据Id获取某个详细信息", notes = "", response = CooperationEntity.class)
    @RequestMapping(value = "/getHotLoanById", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<CooperationEntity> getHotLoan(@RequestParam("id") long id,
                                                      HttpServletRequest request, HttpServletResponse response){
        try {
            CooperationEntity bean = cooperation.findById(id);
            return successResult(bean);
        }catch (Exception e){
            ExceptionUtils.printException("getHotLoan controller报错：", e);
            return failResult(e);
        }
    }
}
