package com.loan.admin.service.hotloan.impl;

import com.loan.admin.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.common.params.CooperationParam;
import com.loan.datasource.dao.springdata.CoopRepository;
import com.loan.datasource.entities.jpa.CooperationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
@Service
public class CooperationImpl implements ICooperation {


    @Autowired
    private CoopRepository coopRepository;

    @Override
    public Page<CooperationEntity> getCooperationByPage(int pageSize, int pageNum){
        List<CooperationBean> beanList = new ArrayList<CooperationBean>();
        Sort sort = new Sort(Sort.Direction.DESC, "order");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<CooperationEntity> cooperationList = coopRepository.findAll(pageable);
        return cooperationList;
    }

    @Override
    public CooperationEntity insert(CooperationParam param){
        CooperationEntity entity = new CooperationEntity();
        entity.setAppName(param.getAppName());
        entity.setCheckDes(param.getCheckDes());
        entity.setCommits(param.getCommit());
        entity.setConditions(param.getCondition());
        entity.setDeadLine(param.getDeadLine());
        entity.setFlow(param.getFlow());
        entity.setLimitTime(param.getLimitTime());
        entity.setOrderBy(param.getOrder());
        entity.setLogo(param.getLogo());
        entity.setQuta(param.getQuta());
        entity.setRate(param.getRate());
        entity.setService(param.getService());
        entity.setUrl(param.getUrl());
        entity.setUsersNum(param.getUsersNum());
        return coopRepository.save(entity);
    }

    @Override
    public CooperationEntity update(CooperationParam param){
        if(param == null || param.getId() == null){
            return null;
        }
        CooperationEntity entity = new CooperationEntity();
        entity.setId(param.getId());
        entity.setAppName(param.getAppName());
        entity.setCheckDes(param.getCheckDes());
        entity.setCommits(param.getCommit());
        entity.setConditions(param.getCondition());
        entity.setDeadLine(param.getDeadLine());
        entity.setFlow(param.getFlow());
        entity.setLimitTime(param.getLimitTime());
        entity.setOrderBy(param.getOrder());
        entity.setLogo(param.getLogo());
        entity.setQuta(param.getQuta());
        entity.setRate(param.getRate());
        entity.setService(param.getService());
        entity.setUrl(param.getUrl());
        entity.setUsersNum(param.getUsersNum());
        coopRepository.findOne(entity.getId());
        if(entity == null){
            return null;
        }
        return coopRepository.save(entity);
    }

    @Override
    public CooperationEntity findOneById(Long id){
        return coopRepository.findOne(id);
    }

}
