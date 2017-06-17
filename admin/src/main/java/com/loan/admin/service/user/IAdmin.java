package com.loan.admin.service.user;

import com.loan.common.beans.AdminBean;
import com.loan.common.params.AdminParam;

import java.util.List;

/**
 * Created by shuttle on 6/1/17.
 */
public interface IAdmin {

    public int insertAdmin(AdminBean adminBean) throws Exception;

    public void updateAdmin(AdminBean admin);

    public List<AdminBean> findAdminList(AdminParam admin, int skip, int page) throws InstantiationException, IllegalAccessException;

    public AdminBean getAdminById(Long id);

    public int login(String loginName, String pwd);

    public int adminCount();
}
