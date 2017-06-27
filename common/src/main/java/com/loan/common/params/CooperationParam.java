package com.loan.common.params;

/**
 * Created by shuttle on 6/23/17.
 */
public class CooperationParam {

    private long id;
    private String appName;
    private String logo;
    private String rate;
    private String serviceCharge;
    private Integer topQota;
    private Integer bottomQota;
    private String outTime;
    private String loanTime;
    private Integer orderNo;
    private Byte enabled;
    private Integer deadline;
    private String visitUrl; //访问的url

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    private long type;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
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
        this.outTime = outTime;
    }


    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
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
