package com.loan.common.enums;

/**
 * Created by shuttle on 5/25/17.
 */
public enum ResultEnums {
    DEFAULT("亲，您的wifi拐了好多弯...", 0),
    ERROR("亲，服务器繁忙，让我处理一会", 0),
    SUCCESS("亲，您的请求成功啦！", 1);

    private final String message;

    private final int code;

    private ResultEnums(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
