package com.loan.datasource.dao;

import com.loan.datasource.entities.Cooperation;
import com.loan.datasource.mappers.CooperationMapper;
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

    public int insertCooperation(Cooperation cooperation){
        return cooperationMapper.insert(cooperation);
    }

    public List<Cooperation> findCooperationList(String type, int skip, int page){
        return cooperationMapper.selectByTypeAndPage(type, skip, page);
    }
}
