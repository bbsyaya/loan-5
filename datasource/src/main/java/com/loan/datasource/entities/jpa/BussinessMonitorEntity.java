package com.loan.datasource.entities.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shuttle on 6/23/17.
 */
@Entity
@Table(name = "bussiness_monitor", schema = "loan", catalog = "")
public class BussinessMonitorEntity {
    private long id;
    private Long appId;
    private Timestamp visitTime;
    private Integer clientIp;
    private Integer userId;
    private Double charge;
    private String moduleCode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "app_id", nullable = true)
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "visit_time", nullable = true)
    public Timestamp getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Timestamp visitTime) {
        this.visitTime = visitTime;
    }

    @Basic
    @Column(name = "client_ip", nullable = true)
    public Integer getClientIp() {
        return clientIp;
    }

    public void setClientIp(Integer clientIp) {
        this.clientIp = clientIp;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "charge", nullable = true, precision = 0)
    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    @Basic
    @Column(name = "module_code", nullable = true, length = 10)
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BussinessMonitorEntity that = (BussinessMonitorEntity) o;

        if (id != that.id) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (visitTime != null ? !visitTime.equals(that.visitTime) : that.visitTime != null) return false;
        if (clientIp != null ? !clientIp.equals(that.clientIp) : that.clientIp != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (charge != null ? !charge.equals(that.charge) : that.charge != null) return false;
        if (moduleCode != null ? !moduleCode.equals(that.moduleCode) : that.moduleCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (visitTime != null ? visitTime.hashCode() : 0);
        result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (charge != null ? charge.hashCode() : 0);
        result = 31 * result + (moduleCode != null ? moduleCode.hashCode() : 0);
        return result;
    }
}
