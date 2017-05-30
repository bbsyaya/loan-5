package com.loan.api.service.modules.impl;

import com.loan.api.service.modules.IModules;
import com.loan.common.beans.ModuleBean;
import com.loan.common.utils.CopyBeanUtils;
import com.loan.common.utils.ExceptionUtils;
import com.loan.datasource.dao.ModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shuttle on 5/30/17.
 */
@Service
public class ModuleImpl implements IModules {

    @Autowired
    ModuleDao moduleDao;

    @Override
    public List<ModuleBean> getIndexModule() {
        CopyBeanUtils<ModuleBean> copyBeanUtils = new CopyBeanUtils<ModuleBean>();
        try {
            return copyBeanUtils.copyBeanUtils(ModuleBean.class, moduleDao.getIndexModule());
        } catch (IllegalAccessException e) {
            ExceptionUtils.printException("getIndexModule出错：", e);
        } catch (InstantiationException e) {
            ExceptionUtils.printException("getIndexModule出错：", e);
            e.printStackTrace();
        }
        return null;
    }
}
