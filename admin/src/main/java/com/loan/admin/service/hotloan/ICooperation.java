package com.loan.admin.service.hotloan;

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
    public List<CooperationBean> getCooperationBeanByPage(int skip, int page);

    /**
     * 更新 Cooperation
     * @param bean
     * @return
     */
    public void updateCooperation(CooperationBean bean);

    /**
     * 插入 Cooperation
     * @param bean
     * @return
     * @throws Exception
     */
    public int insertCooperation(CooperationBean bean) throws Exception;

    /**
     * 根据id获取合作商户信息
     * @param id
     * @return
     */
    public CooperationBean findById(long id);

    /**
     * 获取合作商的数量
     * @return
     */
    public int getCooperatorCount();
}
