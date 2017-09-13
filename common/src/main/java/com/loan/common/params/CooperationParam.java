package com.loan.common.params;

import java.sql.Timestamp;

/**
 * Created by shuttle on 6/23/17.
 */
public class CooperationParam {

    private Long id;
    private String logo;
    private String appName;
    private String checkDes;
    private Long usersNum;
    private String rate;
    private String service;
    private String limitTime;
    private String deadLine;
    private Integer quta;
    private String flow;
    private String conditions;
    private String commits;
    private Integer orderBy;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getCheckDes() {
        return checkDes;
    }

    public void setCheckDes(String checkDes) {
        this.checkDes = checkDes;
    }

    public Long getUsersNum() {
        return usersNum;
    }

    public void setUsersNum(Long usersNum) {
        this.usersNum = usersNum;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public Integer getQuta() {
        return quta;
    }

    public void setQuta(Integer quta) {
        this.quta = quta;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
