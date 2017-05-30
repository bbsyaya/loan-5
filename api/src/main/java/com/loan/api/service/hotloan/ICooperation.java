package com.loan.api.service.hotloan;

import com.loan.common.beans.CooperationBean;

import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
public interface ICooperation {

    /**
     * 根据类型获取合作商列表
     * @param type
     * @return
     */
    public List<CooperationBean> getCooperationBeanByType(String type, int skip, int page);
}
