package com.loan.datasource.entities.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shuttle on 6/23/17.
 */
@Entity
@Table(name = "relation", schema = "loan", catalog = "")
public class RelationEntity {
    private long id;
    private long userId;
    private String contactName;
    private String contactMobile;
    private Integer relationType;
    private String qq;
    private String webchart;
    private String email;
    private Timestamp createTime;
    private Timestamp updateTime;

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
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "contact_name", nullable = false, length = 32)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contact_mobile", nullable = false, length = 16)
    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    @Basic
    @Column(name = "relation_type", nullable = true)
    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    @Basic
    @Column(name = "qq", nullable = true, length = 16)
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "webchart", nullable = true, length = 32)
    public String getWebchart() {
        return webchart;
    }

    public void setWebchart(String webchart) {
        this.webchart = webchart;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 32)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = false)
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

        RelationEntity that = (RelationEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (contactName != null ? !contactName.equals(that.contactName) : that.contactName != null) return false;
        if (contactMobile != null ? !contactMobile.equals(that.contactMobile) : that.contactMobile != null)
            return false;
        if (relationType != null ? !relationType.equals(that.relationType) : that.relationType != null) return false;
        if (qq != null ? !qq.equals(that.qq) : that.qq != null) return false;
        if (webchart != null ? !webchart.equals(that.webchart) : that.webchart != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactMobile != null ? contactMobile.hashCode() : 0);
        result = 31 * result + (relationType != null ? relationType.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (webchart != null ? webchart.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
