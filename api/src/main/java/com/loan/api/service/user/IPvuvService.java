package com.loan.api.service.user;

import com.loan.common.params.PuvParam;
import com.loan.datasource.entities.jpa.PvuvEntity;

/**
 * @Description: pvuv接口
 * @author: shuttle
 * @date: 2017-08-28 11:27 PM
 */
public interface IPvuvService {
    PvuvEntity savePvuvEntity(PuvParam param);
}
