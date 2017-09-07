package com.loan.admin.service.hotloan.impl;

import com.loan.admin.service.hotloan.ICooperation;
import com.loan.admin.utils.PageUtils;
import com.loan.common.beans.CooperationBean;
import com.loan.common.params.CooperationParam;
import com.loan.common.utils.CopyBeanUtils;
import com.loan.common.utils.DateUtils;
import com.loan.datasource.dao.springdata.CoopRepository;
import com.loan.datasource.entities.jpa.CooperationEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        BeanUtils.copyProperties(param, entity);
        entity.setId(null);
        entity.setCreateTime(DateUtils.getCurrentTimeStamp());
        entity.setUpdateTime(DateUtils.getCurrentTimeStamp());
        return coopRepository.save(entity);
    }

    @Override
    public CooperationEntity update(CooperationParam param){
        if(param == null || param.getId() == null){
            return null;
        }
        CooperationEntity e = new CooperationEntity();
        BeanUtils.copyProperties(param, e);
        coopRepository.findOne(e.getId());
        if(e == null){
            return null;
        }
        return coopRepository.save(e);
    }

    @Override
    public CooperationEntity findOneById(Long id){
        return coopRepository.findOne(id);
    }

}
