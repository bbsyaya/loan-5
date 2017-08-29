package com.loan.api.service.user.impl;

import com.loan.api.dao.jpa.PvuvEntity;
import com.loan.api.dao.repository.PvuvRepository;
import com.loan.api.service.user.IPvuvService;
import com.loan.common.params.PuvParam;
import com.loan.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 实现
 * @author: shuttle
 * @date: 2017-08-28 11:27 PM
 * @company: 北京鼎力创世科技有限公司
 */
@Service
public class PvuvService implements IPvuvService {

    @Autowired
    PvuvRepository pvuvRepository;

    @Override
    public PvuvEntity savePvuvEntity(PuvParam param){
        PvuvEntity entity = new PvuvEntity();
        entity.setCooperId(param.getCooperId());
        entity.setIp(param.getIp());
        entity.setUserId(param.getUserId());
        entity.setCreateTime(DateUtils.getCurrentTimeStamp());
        return pvuvRepository.save(entity);
    }
}
