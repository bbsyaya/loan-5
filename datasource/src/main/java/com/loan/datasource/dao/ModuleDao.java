package com.loan.datasource.dao;

import com.loan.datasource.entities.Module;
import com.loan.datasource.mappers.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuttle on 5/30/17.
 */
@Repository
public class ModuleDao {

    @Autowired
    ModuleMapper moduleMapper;

    /**
     * 获取可用的显示在首页的module
     * @return
     */
    public List<Module> getIndexModule(){
        return moduleMapper.getModuleIndex(1, 1);
    }
}
