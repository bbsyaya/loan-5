package com.loan.admin.service.hotloan.impl;

import com.loan.admin.service.hotloan.IAdmin;
import com.loan.datasource.dao.springdata.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 管理员实现类
 * @author: shuttle
 * @date: 2017-09-15 2:19 PM
 */
public class AdminImpl implements IAdmin {
    @Autowired
    public AdminRepository adminRepository;
}
