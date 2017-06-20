package com.loan.admin.service.hotloan.impl;

import com.loan.admin.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.utils.DateUtils;
import com.loan.datasource.dao.CooperationDao;
import com.loan.datasource.entities.Cooperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
            beanList.add(bean);
        }
        return beanList;
    }

    public List<CooperationBean> getCooperationBeanByPage(int skip, int page){
        List<CooperationBean> beanList = new ArrayList<CooperationBean>();
        List<Cooperation> cooperationList = cooperationDao.findCooperationListByPage(skip, page);
        for(Cooperation entity : cooperationList){
            CooperationBean bean = new CooperationBean();
            BeanUtils.copyProperties(entity, bean);
            if(bean.getUpdateTime() != null) {
                bean.setUpdateTimeString(DateUtils.formatTimeStampToString(bean.getUpdateTime()));
            }

            if(bean.getCreateTime() != null) {
                bean.setCreateTimeString(DateUtils.formatTimeStampToString(bean.getCreateTime()));
            }
            beanList.add(bean);
        }
        return beanList;
    }

    public void updateCooperation(CooperationBean bean){
        Cooperation cooperation = new Cooperation();
        BeanUtils.copyProperties(bean, cooperation);
        bean.setUpdateTime(DateUtils.formatToTimeStamp(new Date()));
        cooperationDao.updateCooperation(cooperation);
    }

    public int insertCooperation(CooperationBean bean) throws Exception {
        Cooperation cooperation = new Cooperation();
        BeanUtils.copyProperties(bean, cooperation);
        Date date = new Date();
        bean.setCreateTime(DateUtils.formatToTimeStamp(date));
        bean.setUpdateTime(DateUtils.formatToTimeStamp(date));
        return cooperationDao.insertCooperation(cooperation);
    }

    public CooperationBean findById(long id) {
        CooperationBean bean = new CooperationBean();
        BeanUtils.copyProperties(cooperationDao.findById(id), bean);
        if(bean.getUpdateTime() != null) {
            bean.setUpdateTimeString(DateUtils.formatTimeStampToString(bean.getUpdateTime()));
        }
        if(bean.getCreateTime() != null) {
            bean.setCreateTimeString(DateUtils.formatTimeStampToString(bean.getCreateTime()));
        }
        return bean;
    }

    public int insertCooperationType(long cid, long mid) throws Exception{
        return cooperationDao.insertCatagory(cid, mid);
    }


    public int getCooperatorCount(int type){
        return cooperationDao.getCooperatorCount(type);
    }
}
