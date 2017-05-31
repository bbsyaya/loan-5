package com.loan.api.annotation;

import java.lang.annotation.*;

/**
 * Created by shuttle on 5/31/17.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IpLimitAnnotation {
    /**
     * 访问次数 默认20次
     *
     * @return
     */
    int visitTimes() default 20;

    /**
     * 访问频率 默认10分钟
     *
     * @return
     */
    int times() default 10;
}
