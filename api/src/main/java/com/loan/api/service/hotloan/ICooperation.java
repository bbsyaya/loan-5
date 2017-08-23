package com.loan.api.service.hotloan;

import com.loan.api.dao.jpa.CooperationEntity;
import org.springframework.data.domain.Page;

/**
 * Created by shuttle on 5/25/17.
 */
public interface ICooperation {

    /**
     * 根据类型获取合作商列表
     * @return
     */
    Page<CooperationEntity> getCooperationBeanByType(int pageNum, int pageSize);

    CooperationEntity findById(long id);
}
