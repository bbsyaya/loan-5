package com.loan.admin.controller;

import com.loan.admin.consts.Constants;
import com.loan.admin.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.beans.Result;
import com.loan.common.params.LoanParam;
import com.loan.common.utils.ExceptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/loan")
@Api(description = "合作商相关")
public class HotLoanController extends BaseController {

    @Autowired
    private ICooperation cooperation;

    @ApiOperation(value = "获取贷款列表", notes = "获取贷款列表", response = Boolean.class)
    @RequestMapping(value = "/getLoanList", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<List<CooperationBean>> getHotLoanList(@ModelAttribute LoanParam loanParam,
                                                        HttpServletRequest request, HttpServletResponse response) {
        Result<List<CooperationBean>> result = new Result<List<CooperationBean>>();
        try {
            List<CooperationBean> beanList = cooperation.getCooperationBeanByPage(loanParam.getLimit(), loanParam.getPage());
            return successResult(beanList);
        } catch (Exception e) {
            ExceptionUtils.printException("getLoanList controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "根据类型获取贷款列表", notes = "根据类型获取贷款列表，，1 极速放贷 2 帮你推荐 3 办信用卡 4 热门贷款", response = Boolean.class)
    @RequestMapping(value = "/getLoanWithType", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<List<CooperationBean>> getHotLoanListWithNoType(@ModelAttribute LoanParam loanParam,
                                                                  HttpServletRequest request, HttpServletResponse response) {
        Result<List<CooperationBean>> result = new Result<List<CooperationBean>>();
        try {
            List<CooperationBean> beanList = cooperation.getCooperationBeanByType(loanParam.getType(), loanParam.getLimit(), loanParam.getPage());
            return successResult(beanList);
        } catch (Exception e) {
            ExceptionUtils.printException("getLoanWithType controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "更新贷款信息", notes = "更新贷款信息", response = Boolean.class)
    @RequestMapping(value = "/updateHotLoan", method = {RequestMethod.PUT}, produces = "application/json;charset=utf-8")
    public Result<CooperationBean> updateHotLoan(@ModelAttribute CooperationBean bean,
                                                 HttpServletRequest request, HttpServletResponse response) {
        try {
            cooperation.updateCooperation(bean);
            return successResult(bean);
        } catch (Exception e) {
            ExceptionUtils.printException("getHotLoan controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "获取某个商户信息", notes = "获取某个商户信息", response = Boolean.class)
    @RequestMapping(value = "/findHotLoanById/{id}", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<CooperationBean> findHotLoanById(@PathVariable("id") long id) {
        try {
            CooperationBean bean = cooperation.findById(id);
            return successResult(bean);
        } catch (Exception e) {
            ExceptionUtils.printException("findHotLoanById controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "插入贷款信息", notes = "插入贷款信息", response = Boolean.class)
    @RequestMapping(value = "/insertHotLoan", method = {RequestMethod.PUT}, produces = "application/json;charset=utf-8")
    public Result<Integer> insertHotLoan(@ModelAttribute CooperationBean bean,
                                         HttpServletRequest request, HttpServletResponse response) {
        try {
            int i = cooperation.insertCooperation(bean);
            return successResult(i);
        } catch (Exception e) {
            ExceptionUtils.printException("insertHotLoan controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "设置贷款类型", notes = "设置贷款类型", response = Boolean.class)
    @RequestMapping(value = "/setHotLoan", method = {RequestMethod.PUT}, produces = "application/json;charset=utf-8")
    public Result<Integer> setHotLoan(@ApiParam(required = true, name = "cid", value = "cid") @RequestParam("cid") long cid,
                                      @ApiParam(required = true, name = "mid", value = "mid") @RequestParam("mid") long mid) {
        try {
            int i = cooperation.insertCooperationType(cid, mid);
            return successResult(i);
        } catch (Exception e) {
            ExceptionUtils.printException("setHotLoan controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "获取合作商的总数", notes = "获取合作商的总数", response = Boolean.class)
    @RequestMapping(value = "/cooperationCount/{type}", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<Integer> cooperationCount(@PathVariable("type") int type) {
        try {
            int i = cooperation.getCooperatorCount(type);
            return successResult(i);
        } catch (Exception e) {
            ExceptionUtils.printException("cooperationCount controller报错：", e);
            return failResult(e);
        }
    }
}
