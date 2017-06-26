package com.loan.api.service.hotloan.impl;

import com.loan.api.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.utils.DateUtils;
import com.loan.datasource.dao.CooperationDao;
import com.loan.datasource.entities.Cooperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
@Service
public class CooperationImpl implements ICooperation {

    @Autowired
    private CooperationDao cooperationDao;

    public List<CooperationBean> getCooperationBeanByType(String type, int skip, int page){
        List<CooperationBean> beanList = new ArrayList<CooperationBean>();
        List<Cooperation> cooperationList = cooperationDao.findCooperationList(type, skip, page);
        for(Cooperation entity : cooperationList){
            CooperationBean bean = new CooperationBean();
            BeanUtils.copyProperties(entity, bean);
            if(bean.getUpdateTime() != null) {
                bean .setUpdateTimeString(DateUtils.formatTimeStampToString(bean.getUpdateTime()));
            }

            if(bean.getCreateTime() != null) {
                bean.setCreateTimeString(DateUtils.formatTimeStampToString(bean.getCreateTime()));
            }
            beanList.add(bean);
        }
        return beanList;
    }
}
