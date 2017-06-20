package com.loan.admin.service.user.impl;

import com.loan.admin.service.user.IAdmin;
import com.loan.common.beans.AdminBean;
import com.loan.common.params.AdminParam;
import com.loan.common.utils.CopyBeanUtils;
import com.loan.datasource.dao.AdminDao;
import com.loan.datasource.entities.Admin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
@Service
public class AdminImpl implements IAdmin {

    @Autowired
    AdminDao adminDao;

    @Override
    public long insertAdmin(AdminBean adminBean) throws Exception {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminBean, admin);
        return adminDao.insertAdmin(admin);
    }

    @Override
    public void updateAdmin(AdminBean adminBean) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminBean, admin);
        adminDao.updateAdmin(admin);
    }

    @Override
    public List<AdminBean> findAdminList(AdminParam adminParam, int skip, int page)
            throws InstantiationException, IllegalAccessException {
        com.loan.datasource.params.AdminParam admin = new com.loan.datasource.params.AdminParam();
        BeanUtils.copyProperties(adminParam, admin);
        CopyBeanUtils<AdminBean> copyBeanUtils = new CopyBeanUtils<>();
        List<Admin> adminList = adminDao.findAdminList(admin, skip, page);
        return copyBeanUtils.copyBeanUtils(AdminBean.class, adminList);
    }

    @Override
    public AdminBean getAdminById(Long id) {
        AdminBean bean = new AdminBean();
        Admin admin = adminDao.getAdminById(id);
        BeanUtils.copyProperties(admin, bean);
        return bean;
    }

    @Override
    public int login(String loginName, String pwd) {
        return adminDao.login(loginName, pwd);
    }

    @Override
    public int adminCount(){
        return adminDao.adminCount();
    }
}
