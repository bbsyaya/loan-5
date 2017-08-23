package com.loan.api.service.hotloan.impl;

import com.loan.api.dao.jpa.CooperationEntity;
import com.loan.api.dao.repository.CoopRepository;
import com.loan.api.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
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
    private CoopRepository cooperationRepository;

    public Page<CooperationEntity> getCooperationBeanByType(int pageNum, int pageSize){
        List<CooperationBean> beanList = new ArrayList<CooperationBean>();
        Sort sort = new Sort(Sort.Direction.DESC, "order");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<CooperationEntity> cooperationList = cooperationRepository.findAll(pageable);
        return cooperationList;
    }

    @Override
    public CooperationEntity findById(long id) {
        return cooperationRepository.findOne(id);
    }
}
