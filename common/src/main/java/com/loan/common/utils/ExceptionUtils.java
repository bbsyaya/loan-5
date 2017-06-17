package com.loan.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shuttle on 5/30/17.
 */
public class ExceptionUtils {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtils.class);

    public static void printException(String pre, Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement element : stackTrace) {
                LOGGER.error(pre + ":" + element.getClassName()
                        + "   " + element.getClassName()
                        + "   " + element.getFileName()
                        + "   " + element.getMethodName()
                        + "   " + element.getLineNumber() + "");
            }
        }
    }
}
