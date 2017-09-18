package com.loan.api.service.hotloan.impl;

import com.loan.api.service.hotloan.ICooperation;
import com.loan.common.beans.CooperationBean;
import com.loan.datasource.dao.springdata.CoopRepository;
import com.loan.datasource.entities.jpa.CooperationEntity;
import com.sun.jndi.toolkit.dir.SearchFilter;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Operator;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuttle on 5/25/17.
 */
@Service
public class CooperationImpl implements ICooperation {

    @Autowired
    private CoopRepository cooperationRepository;

    public Page<CooperationEntity> getCooperationBeanByType(int pageNum, int pageSize){
        List<CooperationBean> beanList = new ArrayList<CooperationBean>();
        Sort sort = new Sort(Sort.Direction.DESC, "orderBy");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Specification<CooperationEntity> specification = new Specification<CooperationEntity>() {
            //构建查询条件，可扩展动态配置查询条件
            @Override
            public Predicate toPredicate(Root<CooperationEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.equal(root.get("enabled"), 1);
                return criteriaBuilder.and(predicate);
            }
        };
        Page<CooperationEntity> cooperationList = cooperationRepository.findAll(specification, pageable);
        return cooperationList;
    }

    @Override
    public CooperationEntity findById(long id) {
        return cooperationRepository.findOne(id);
    }
}
