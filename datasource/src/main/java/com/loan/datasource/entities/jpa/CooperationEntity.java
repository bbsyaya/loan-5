package com.loan.datasource.entities.jpa;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Created by shuttle on 6/23/17.
 */
@Entity
@Table(name = "cooperation", schema = "loan", catalog = "")
public class CooperationEntity {

    @Id
    @GeneratedValue
    private long id;
    private String appName;
    private String logo;
    private String rate;
    private String serviceCharge;
    private Integer topQota;
    private Integer bottomQota;
    private String outTime;
    private Timestamp createTime;
    private String loanTime;
    private Timestamp updateTime;
    private Integer orderNo;
    private Byte enabled;
    private Integer deadline;

    @Basic
    @Column(name = "deadline", nullable = true)
    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }
//    @OneToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name="cooperation_type",
//            joinColumns={@JoinColumn(name="cooperation_id",referencedColumnName="id")},
//            inverseJoinColumns ={@JoinColumn(name="module_id",referencedColumnName="id")}
//    )
//    private List<ModuleEntity> cooperationTypeEntityList;

    private Set<ModuleEntity> modules;

    @ManyToMany
    @JoinTable(name="cooperation_type",
            joinColumns={@JoinColumn(name="cooperation_id",referencedColumnName="id")},
            inverseJoinColumns ={@JoinColumn(name="module_id",referencedColumnName="id")}
    )
    public Set<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(Set<ModuleEntity> modules) {
        this.modules = modules;
    }

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
    @Column(name = "app_name", nullable = true, length = 32)
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = 256)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "rate", nullable = true, length = 32)
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "service_charge", nullable = true, length = 32)
    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Basic
    @Column(name = "top_qota", nullable = true)
    public Integer getTopQota() {
        return topQota;
    }

    public void setTopQota(Integer topQota) {
        this.topQota = topQota;
    }

    @Basic
    @Column(name = "bottom_qota", nullable = true)
    public Integer getBottomQota() {
        return bottomQota;
    }

    public void setBottomQota(Integer bottomQota) {
        this.bottomQota = bottomQota;
    }

    @Basic
    @Column(name = "out_time", nullable = true, length = 32)
    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "create_time", nullable = true, updatable=false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "loan_time", nullable = true, length = 32)
    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "order_no", nullable = true)
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "enabled", nullable = true)
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CooperationEntity that = (CooperationEntity) o;

        if (id != that.id) return false;
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (serviceCharge != null ? !serviceCharge.equals(that.serviceCharge) : that.serviceCharge != null)
            return false;
        if (topQota != null ? !topQota.equals(that.topQota) : that.topQota != null) return false;
        if (bottomQota != null ? !bottomQota.equals(that.bottomQota) : that.bottomQota != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (loanTime != null ? !loanTime.equals(that.loanTime) : that.loanTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (serviceCharge != null ? serviceCharge.hashCode() : 0);
        result = 31 * result + (topQota != null ? topQota.hashCode() : 0);
        result = 31 * result + (bottomQota != null ? bottomQota.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (loanTime != null ? loanTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        return result;
    }
}
