package com.loan.api.controller;

import com.loan.common.beans.Result;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
public class BaseController {

    @ApiIgnore
    public <T> Result<List<T>> successResult(List<T> t){
        Result<List<T>> result = new Result<>();
        result.setCode(1);
        result.setMessage("请求成功!");
        result.setObj(t);
        return result;
    }

    @ApiIgnore
    public <T> Result<T> successResult(T t){
        Result<T> result = new Result<>();
        result.setCode(1);
        result.setMessage("请求成功!");
        result.setObj(t);
        return result;
    }

    @ApiIgnore
    public Result failResult(){
        Result result = new Result<>();
        result.setCode(0);
        result.setMessage("请求失败!");
        return result;
    }

    @ApiIgnore
    public Result failResult(Exception e){
        Result<StringBuilder> result = new Result<>();
        result.setCode(0);
        result.setMessage("请求失败!");
        StackTraceElement[] trace = e.getStackTrace();
        StringBuilder errMsg = new StringBuilder();
        for (StackTraceElement s : trace) {
            errMsg.append(s + "\\t");
        }
        result.setObj(errMsg);
        return result;
    }

    @ApiIgnore
    public <T> Result<T> failResult(T t){
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMessage("请求失败!");
        result.setObj(t);
        return result;
    }
}
