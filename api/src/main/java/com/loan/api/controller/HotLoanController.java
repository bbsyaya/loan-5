package com.loan.api.controller;

import com.loan.api.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.beans.Result;
import com.loan.common.params.LoanParam;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "获取热门贷款列表", notes = "获取热门贷款列表，0 全部 1 极速放贷 2 帮你推荐 3 办信用卡 4 热门贷款", response = Boolean.class)
    @RequestMapping(value = "/getHotLoan", method = { RequestMethod.GET }, produces = "application/json;charset=utf-8")
    public Result<List<CooperationBean>> getHotLoan(@ModelAttribute LoanParam loanParam,
                                                    HttpServletRequest request, HttpServletResponse response){
        Result<List<CooperationBean>> result = new Result<List<CooperationBean>>();
        try {
            List<CooperationBean> beanList = cooperation.getCooperationBeanByType(loanParam.getType(), loanParam.getLimit(), loanParam.getPage());
            return successResult(beanList);
        }catch (Exception e){
            ExceptionUtils.printException("getHotLoan controller报错：", e);
            return failResult(e);
        }
    }
}
