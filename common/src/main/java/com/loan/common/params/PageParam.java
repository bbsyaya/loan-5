package com.loan.common.params;

/**
 * Created by shuttle on 5/31/17.
 * 分页通用参数
 */
public class PageParam {

    private int pageNum = 0;
    private int pageSize = 10;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
