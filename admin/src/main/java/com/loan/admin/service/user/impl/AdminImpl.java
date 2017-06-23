package com.loan.admin.service.user.impl;

import com.loan.admin.service.user.IAdmin;
import com.loan.admin.utils.PageUtils;
import com.loan.common.beans.AdminBean;
import com.loan.common.params.AdminParam;
import com.loan.common.utils.CopyBeanUtils;
import com.loan.common.utils.DateUtils;
import com.loan.datasource.dao.AdminDao;
import com.loan.datasource.dao.springdata.AdminDaoRepository;
import com.loan.datasource.entities.Admin;
import com.loan.datasource.entities.jpa.AdminEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
@Service
public class AdminImpl implements IAdmin {

    @Autowired
    AdminDao adminDao;

    @Autowired
    AdminDaoRepository adminJpaDao;

    @Override
    public Page<AdminEntity> getAdminListWithPaging(int pageNumber, int pageSize){
        PageRequest request = PageUtils.buildPageRequest(pageNumber,pageSize);
        Page<AdminEntity> adminEntityPage= adminJpaDao.findAll(request);
        return adminEntityPage;
    }



    @Override
    public long insertAdmin(AdminBean adminBean) throws Exception {
        return adminJpaDao.save(this.copyProperties(adminBean)).getId();
    }

    @Override
    public void updateAdmin(AdminBean adminBean) {
        adminJpaDao.save(this.copyProperties(adminBean));
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
        AdminEntity admin = adminJpaDao.findOne(id);
        return copyProperties(admin);
    }

    @Override
    public AdminBean getAdminByName(String loginName) {
        AdminEntity entity = adminJpaDao.findByLoginName(loginName);
        if(entity == null){
            return null;
        }
        return copyProperties(entity);
    }

    @Override
    public int login(String loginName, String pwd) {
        return adminDao.login(loginName, pwd);
    }

    @Override
    public int adminCount(){
        return adminDao.adminCount();
    }

    private AdminBean copyProperties(AdminEntity admin){
        AdminBean bean = new AdminBean();
        BeanUtils.copyProperties(admin, bean);
        return bean;
    }

    private AdminEntity copyProperties(AdminBean adminBean){
        AdminEntity admin = new AdminEntity();
        BeanUtils.copyProperties(adminBean, admin, "createTime", "updateTime");
        if(adminBean.getCreateTime() != null) {
            admin.setCreateTime(DateUtils.formatToTimeStamp(adminBean.getCreateTime()));
        }
        else{
            admin.setCreateTime(DateUtils.getCurrentTimeStamp());
        }
        if(adminBean.getUpdateTime() != null) {
            admin.setUpdateTime(DateUtils.formatToTimeStamp(adminBean.getUpdateTime()));
        }else{
            admin.setUpdateTime(DateUtils.getCurrentTimeStamp());
        }
        return admin;
    }
}
