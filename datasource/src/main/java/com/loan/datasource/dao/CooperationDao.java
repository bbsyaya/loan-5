package com.loan.datasource.dao;

import com.loan.datasource.entities.Cooperation;
import com.loan.datasource.mappers.CooperationMapper;
import com.loan.datasource.mappers.CooperationTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuttle on 5/25/17.
 */
@Repository
public class CooperationDao {
    @Autowired
    CooperationMapper cooperationMapper;

    @Autowired
    CooperationTypeMapper cooperationTypeMapper;

    public int insertCooperation(Cooperation cooperation) throws Exception {
        return cooperationMapper.insert(cooperation);
    }

    public void updateCooperation(Cooperation cooperation){
        cooperationMapper.update(cooperation);
    }

    public List<Cooperation> findCooperationList(String type, int skip, int page){
        return cooperationMapper.selectByTypeAndPage(type, skip, page);
    }

    public List<Cooperation> findCooperationListByPage(int skip, int page){
        return cooperationMapper.selectByPage(skip, page);
    }

    public int insertCatagory(long cid, long mid) throws Exception {
        return cooperationTypeMapper.insert(cid, mid);
    }

    public Cooperation findById(long id){
        return cooperationMapper.findById(id);
    }

    public int getCooperatorCount(int type){
       return cooperationMapper.cooperationCount(type);
    }

}
