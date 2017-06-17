package com.loan.api.exception;

import com.loan.common.beans.Result;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shuttle on 4/21/17.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value= MissingServletRequestParameterException.class)
    //    @ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
    //    @ExceptionHandler//处理所有异常
    public Result<String> exceptionHandler(HttpServletRequest request,
                                           MissingServletRequestParameterException exception) {
        Result<String> resp = new Result<String>();
        resp.setCode(-1);
        resp.setMessage("您的请求缺少必填参数，请检查！");
        return resp;
    }

    @ExceptionHandler(value= TypeMismatchException.class)
    //    @ExceptionHandler(value={.class,MyRuntimeException.class})
    //    @ExceptionHandler//处理所有异常
    public Result<String> exceptionErrorParamHandler(HttpServletRequest request,
                                                     TypeMismatchException exception) {
        Result<String> resp = new Result<String>();
        resp.setCode(-1);
        resp.setMessage("您请求的参数类型错误，请检查！");
        return resp;
    }
}
