package com.loan.api.dao.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-08-22 9:16 PM
 * @company: 北京鼎力创世科技有限公司
 */
@Entity
@Table(name = "cooperation", schema = "loan", catalog = "")
public class CooperationEntity {
    private long id;
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
    private String condition;
    private String commit;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer order;
    private String url;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "check_des")
    public String getCheckDes() {
        return checkDes;
    }

    public void setCheckDes(String checkDes) {
        this.checkDes = checkDes;
    }

    @Basic
    @Column(name = "users_num")
    public Long getUsersNum() {
        return usersNum;
    }

    public void setUsersNum(Long usersNum) {
        this.usersNum = usersNum;
    }

    @Basic
    @Column(name = "rate")
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "service")
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Basic
    @Column(name = "limit_time")
    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    @Basic
    @Column(name = "dead_line")
    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    @Basic
    @Column(name = "quta")
    public Integer getQuta() {
        return quta;
    }

    public void setQuta(Integer quta) {
        this.quta = quta;
    }

    @Basic
    @Column(name = "flow")
    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    @Basic
    @Column(name = "conditions")
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Basic
    @Column(name = "commits")
    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CooperationEntity that = (CooperationEntity) o;

        if (id != that.id) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) return false;
        if (checkDes != null ? !checkDes.equals(that.checkDes) : that.checkDes != null) return false;
        if (usersNum != null ? !usersNum.equals(that.usersNum) : that.usersNum != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (limitTime != null ? !limitTime.equals(that.limitTime) : that.limitTime != null) return false;
        if (deadLine != null ? !deadLine.equals(that.deadLine) : that.deadLine != null) return false;
        if (quta != null ? !quta.equals(that.quta) : that.quta != null) return false;
        if (flow != null ? !flow.equals(that.flow) : that.flow != null) return false;
        if (condition != null ? !condition.equals(that.condition) : that.condition != null) return false;
        if (commit != null ? !commit.equals(that.commit) : that.commit != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + (checkDes != null ? checkDes.hashCode() : 0);
        result = 31 * result + (usersNum != null ? usersNum.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (service != null ? service.hashCode() : 0);
        result = 31 * result + (limitTime != null ? limitTime.hashCode() : 0);
        result = 31 * result + (deadLine != null ? deadLine.hashCode() : 0);
        result = 31 * result + (quta != null ? quta.hashCode() : 0);
        result = 31 * result + (flow != null ? flow.hashCode() : 0);
        result = 31 * result + (condition != null ? condition.hashCode() : 0);
        result = 31 * result + (commit != null ? commit.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "order_by")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
