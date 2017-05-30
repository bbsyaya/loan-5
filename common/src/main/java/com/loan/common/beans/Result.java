package com.loan.common.beans;

import com.loan.common.enums.ResultEnums;

/**
 * Created by shuttle on 5/25/17.
 */
public class Result<T> {

    private int code;
    private String message;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    private T obj;

    public Result(){
        this.code = ResultEnums.DEFAULT.getCode();
        this.message = ResultEnums.DEFAULT.getMessage();
    }

    public Result(int code, String message, T obj){
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
