package com.loan.datasource.entities;


import com.loan.datasource.utils.DateUtils;

import java.sql.Timestamp;

public class Admin {
    private Long id;

    private String loginName;

    private String loginPwd;

    private String trueName;

    private String mobile;

    private Timestamp createTime;

    private Timestamp updateTime;

    private int enabled;

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = DateUtils.formatToTimeStamp(updateTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = DateUtils.formatToTimeStamp(createTime);
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}