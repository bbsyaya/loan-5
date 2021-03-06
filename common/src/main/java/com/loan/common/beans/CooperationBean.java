package com.loan.common.beans;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.sql.Timestamp;

public class CooperationBean {
    private Long id;

    private String appName;

    private String logo;

    private String rate;

    private String serviceCharge;

    private Integer topQota;

    private Integer bottomQota;

    private String outTime;

    @Ignore
    private Timestamp createTime;

    @Ignore
    private Timestamp updateTime;

    private Integer orderNo;

    private Byte enabled;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge == null ? null : serviceCharge.trim();
    }

    public Integer getTopQota() {
        return topQota;
    }

    public void setTopQota(Integer topQota) {
        this.topQota = topQota;
    }

    public Integer getBottomQota() {
        return bottomQota;
    }

    public void setBottomQota(Integer bottomQota) {
        this.bottomQota = bottomQota;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

}