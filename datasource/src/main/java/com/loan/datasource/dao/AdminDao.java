package com.loan.datasource.dao;

import com.loan.datasource.entities.Admin;
import com.loan.datasource.mappers.AdminMapper;
import com.loan.datasource.params.AdminParam;
import com.loan.datasource.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shuttle on 6/6/17.
 */
@Repository
public class AdminDao {

    @Autowired
    AdminMapper adminMapper;

    public long insertAdmin(Admin admin) throws Exception {
        adminMapper.insertAdmin(admin);
        return admin.getId();
    }

    public void updateAdmin(Admin admin){
        admin.setUpdateTime(DateUtils.getCurrentSystem());
        adminMapper.updateAdmin(admin);
    }

    public List<Admin> findAdminList(AdminParam admin, int skip, int page) {
        if(admin == null){
            admin = new AdminParam();
        }
        return adminMapper.findAdminListByPage(admin, skip, page);
    }

    public int adminCount(){
        return adminMapper.adminCount();
    }


    public Admin getAdminById(@Param("id") Long id){
        return adminMapper.getAdminById(id);
    }

    public int login(@Param("loginName") String loginName, @Param("pwd") String pwd){
        return adminMapper.login(loginName, pwd);
    }

}
