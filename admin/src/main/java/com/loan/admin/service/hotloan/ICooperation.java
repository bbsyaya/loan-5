package com.loan.admin.service.hotloan;

import com.loan.common.beans.CooperationBean;
import com.loan.common.params.CooperationParam;
import com.loan.datasource.entities.jpa.CooperationEntity;
import com.loan.datasource.entities.jpa.ModuleEntity;
import org.springframework.data.domain.Page;

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

    public Page<CooperationEntity> getCooperationBeanByPage(long type, int pageNumber, int pageSize);

    public Page<CooperationEntity> getCooperationBeanByPage(int pageNumber, int pageSize);

    /**
     * 更新 Cooperation
     * @param param
     * @return
     */
    public void updateCooperation(CooperationParam param);

    /**
     * 插入 Cooperation
     * @param param
     * @return
     * @throws Exception
     */
    public CooperationEntity saveCooperation(CooperationParam param) throws Exception;

    /**
     * 插入合作商的类型
     * @param cid 合作商id
     * @param mid 类型id
     * @return
     * @throws Exception
     */
    public int insertCooperationType(long cid, long mid) throws Exception;

    /**
     * 根据id获取合作商户信息
     * @param id
     * @return
     */
    public CooperationEntity findById(long id);

    /**
     * 获取合作商的数量
     * @return
     */
    public int getCooperatorCount(int type);

    public Iterable<ModuleEntity> getAllModules();
}
