package com.loan.admin.utils;

import org.springframework.data.domain.PageRequest;

/**
 * Created by shuttle on 6/23/17.
 */
public class PageUtils {
    //构建PageRequest
    public static PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }
}
