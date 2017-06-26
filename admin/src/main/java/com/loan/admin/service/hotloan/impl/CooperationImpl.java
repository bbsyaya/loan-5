package com.loan.admin.service.hotloan.impl;

import com.loan.admin.service.hotloan.ICooperation;
import com.loan.admin.utils.PageUtils;
import com.loan.common.beans.CooperationBean;
import com.loan.common.params.CooperationParam;
import com.loan.common.utils.DateUtils;
import com.loan.datasource.dao.CooperationDao;
import com.loan.datasource.dao.springdata.CooperationRepository;
import com.loan.datasource.dao.springdata.CooperationTypeRepository;
import com.loan.datasource.dao.springdata.ModuleRepository;
import com.loan.datasource.entities.Cooperation;
import com.loan.datasource.entities.jpa.CooperationEntity;
import com.loan.datasource.entities.jpa.ModuleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shuttle on 5/25/17.
 */
@Service
public class CooperationImpl implements ICooperation {

    @Autowired
    private CooperationDao cooperationDao;

    @Autowired
    private CooperationRepository cooperationRepository;

    @Autowired
    private CooperationTypeRepository cooperationTypeRepository;

    @Autowired
    private ModuleRepository moduleRepository;


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

    public Page<CooperationEntity> getCooperationBeanByPage(long type, int pageNumber, int pageSize){
        PageRequest request = PageUtils.buildPageRequest(pageNumber,pageSize);
        if(type == 0){
            return cooperationRepository.findAll(request);
        }
        return cooperationRepository.findAllByModules_Id(type, request);
    }

    public Page<CooperationEntity> getCooperationBeanByPage(int pageNumber, int pageSize){
        PageRequest request = PageUtils.buildPageRequest(pageNumber,pageSize);
        Page<CooperationEntity> entityList = cooperationRepository.findAll(request);
        return entityList;
    }

    public void updateCooperation(CooperationParam param){
        CooperationEntity entity = new CooperationEntity();
        BeanUtils.copyProperties(param, entity, "type");
        ModuleEntity moduleEntity = moduleRepository.findOne(param.getType());
        Set<ModuleEntity> set = new HashSet<>();
        set.add(moduleEntity);
        entity.setModules(set);
        entity.setUpdateTime(DateUtils.getCurrentTimeStamp());
        cooperationRepository.save(entity);
    }

    public CooperationEntity saveCooperation(CooperationParam param){
        CooperationEntity entity = new CooperationEntity();
        BeanUtils.copyProperties(param, entity, "type");
        ModuleEntity moduleEntity = moduleRepository.findOne(param.getType());
        Set<ModuleEntity> set = new HashSet<>();
        set.add(moduleEntity);
        entity.setModules(set);
        entity.setCreateTime(DateUtils.getCurrentTimeStamp());
        entity.setUpdateTime(DateUtils.getCurrentTimeStamp());
        cooperationRepository.save(entity);
        return cooperationRepository.save(entity);
    }

    public CooperationBean findById(long id) {
        CooperationBean bean = new CooperationBean();
        BeanUtils.copyProperties(cooperationRepository.findOne(id), bean);
        return bean;
    }

    public int insertCooperationType(long cid, long mid) throws Exception{
        return cooperationDao.insertCatagory(cid, mid);
    }


    public int getCooperatorCount(int type){
        return cooperationDao.getCooperatorCount(type);
    }

    public Iterable<ModuleEntity> getAllModules(){
        return moduleRepository.findAll();
    }
}
