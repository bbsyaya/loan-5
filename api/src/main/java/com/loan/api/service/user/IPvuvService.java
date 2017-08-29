package com.loan.api.service.user;

import com.loan.api.dao.jpa.PvuvEntity;
import com.loan.common.params.PuvParam;

/**
 * @Description: pvuv接口
 * @author: shuttle
 * @date: 2017-08-28 11:27 PM
 */
public interface IPvuvService {
    public PvuvEntity savePvuvEntity(PuvParam param);
}
