package com.loan.admin.controller;

import com.loan.admin.consts.Constants;
import com.loan.admin.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.beans.Result;
import com.loan.common.beans.UserBean;
import com.loan.common.params.CooperationParam;
import com.loan.common.params.LoanParam;
import com.loan.common.utils.ExceptionUtils;
import com.loan.datasource.entities.jpa.CooperationEntity;
import com.loan.datasource.entities.jpa.ModuleEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shuttle on 5/25/17.
 */
@RestController
@RequestMapping(Constants.BASE_URL + "/loan")
@Api(description = "合作商相关")
public class HotLoanController extends BaseController {

    @Autowired
    private ICooperation cooperation;

    @ApiOperation(value = "根据类型获取贷款列表", notes = "根据类型获取贷款列表，type 0 全部 1 极速放贷 2 帮你推荐 3 办信用卡 4 热门贷款", response = Boolean.class)
    @RequestMapping(value = "/getHotLoanListWithType", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<Page<CooperationEntity>> getHotLoanListWithType(@RequestParam("type") long type,
                                                                  @RequestParam("pageNum") int pageNum,
                                                                  @RequestParam("pageSize") int pageSize) {
        Result<Page<CooperationEntity>> result = new Result<Page<CooperationEntity>>();
        try {
            Page<CooperationEntity> beanList = cooperation.getCooperationBeanByPage(type, pageNum, pageSize);
            return successResult(beanList);
        } catch (Exception e) {
            ExceptionUtils.printException("getLoanWithType controller报错：", e);
            e.printStackTrace();
            return failResult(e);
        }
    }

    @ApiOperation(value = "更新贷款信息", notes = "更新贷款信息", response = Boolean.class)
    @RequestMapping(value = "/updateHotLoan", method = {RequestMethod.PUT}, produces = "application/json;charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "贷款信息", required = true, dataType = "CooperationParam"),
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<Boolean> updateHotLoan(@RequestBody CooperationParam param) {
        try {
            cooperation.updateCooperation(param);
            return successResult(Boolean.TRUE);
        } catch (Exception e) {
            ExceptionUtils.printException("getHotLoan controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "获取某个商户信息", notes = "获取某个商户信息", response = Boolean.class)
    @RequestMapping(value = "/findHotLoanById/{id}", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<CooperationEntity> findHotLoanById(@PathVariable("id") long id) {
        try {
            CooperationEntity entity = cooperation.findById(id);
            return successResult(entity);
        } catch (Exception e) {
            ExceptionUtils.printException("findHotLoanById controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "插入贷款信息", notes = "插入贷款信息", response = Boolean.class)
    @RequestMapping(value = "/insertHotLoan", method = {RequestMethod.PUT}, produces = "application/json;charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param", value = "贷款信息", required = true, dataType = "CooperationParam"),
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<Boolean> insertHotLoan(@RequestBody CooperationParam param) {
        try {
            cooperation.saveCooperation(param);
            return successResult(true);
        } catch (Exception e) {
            ExceptionUtils.printException("insertHotLoan controller报错：", e);
            return failResult(e);
        }
    }

    @ApiOperation(value = "获取贷款类型", notes = "获取贷款类型", response = Boolean.class)
    @RequestMapping(value = "/getModules", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public Result<Iterable<ModuleEntity>> setHotLoan() {
        try {
            return successResult(cooperation.getAllModules());
        } catch (Exception e) {
            ExceptionUtils.printException("setHotLoan controller报错：", e);
            return failResult(e);
        }
    }
}
