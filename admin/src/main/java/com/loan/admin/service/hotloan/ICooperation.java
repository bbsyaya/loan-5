package com.loan.admin.service.hotloan;

import com.loan.common.params.CooperationParam;
import com.loan.datasource.entities.jpa.CooperationEntity;
import org.springframework.data.domain.Page;

/**
 * Created by shuttle on 5/25/17.
 */
public interface ICooperation {
    Page<CooperationEntity> getCooperationByPage(int pageSize, int pageNum);

    CooperationEntity insert(CooperationParam param);

    CooperationEntity update(CooperationParam param);

    CooperationEntity findOneById(Long id);
}
