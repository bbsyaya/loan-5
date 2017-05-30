package com.loan.common.params;

/**
 * Created by shuttle on 5/27/17.
 */
public class LoanParam {
    public String type;
    public int limit;
    public int page;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
