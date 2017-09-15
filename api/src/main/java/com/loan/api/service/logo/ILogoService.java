package com.loan.api.service.logo;


import com.loan.datasource.entities.jpa.LogoEntity;

/**
 * @Description: logo服务类
 * @author: shuttle
 * @date: 2017-09-08 10:01 AM
 */
public interface ILogoService {
    LogoEntity getLastEnabledLogo();
}
