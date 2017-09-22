package com.loan.api.service.gourl.impl;

import com.loan.api.service.gourl.IGoUrlService;
import com.loan.datasource.dao.springdata.GoUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-22 11:12 PM
 */
@Service
public class GoUrlImpl implements IGoUrlService {

    @Autowired
    GoUrlRepository goUrlRepository;

    @Override
    public String getUrl(Long id) {
        if(null == id) id = 1L;
        return goUrlRepository.findOne(id).getGoUrl();
    }
}
