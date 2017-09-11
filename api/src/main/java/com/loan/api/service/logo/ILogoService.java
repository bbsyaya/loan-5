package com.loan.api.service.logo;

import com.loan.api.dao.jpa.LogoEntity;

/**
 * @Description: logo服务类
 * @author: shuttle
 * @date: 2017-09-08 10:01 AM
 * @company: 北京鼎力创世科技有限公司
 */
public interface ILogoService {
    public LogoEntity getLastEnabledLogo();
}
