package com.loan.api.service.logo.impl;

import com.loan.api.service.logo.ILogoService;
import com.loan.datasource.dao.springdata.LogoRepository;
import com.loan.datasource.entities.jpa.LogoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: logo类
 * @author: shuttle
 * @date: 2017-09-08 10:02 AM
 */
@Service
public class LogoServiceImpl implements ILogoService {
    @Autowired
    LogoRepository logoRepository;

    /**
     * 获取Logo信息
     * @return
     */
    @Override
    public LogoEntity getLastEnabledLogo() {
        List<LogoEntity> list = logoRepository.findByEnabledAndAndTypeOrderByCreateTimeDesc(1, 0);
        if(null != list && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
