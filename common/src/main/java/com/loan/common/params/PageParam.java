package com.loan.common.params;

/**
 * Created by shuttle on 5/31/17.
 * 分页通用参数
 */
public class PageParam {

    public int limit = 0;
    public int page = 10;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
