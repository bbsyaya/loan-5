package com.loan.api.dao.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-08-29 4:34 PM
 */
@Entity
@Table(name = "pvuv", schema = "loan")
public class PvuvEntity {
    private long id;
    private String ip;
    private Long cooperId;
    private Timestamp createTime;
    private Long userId;
    private Integer type;
    private String url;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "cooper_id")
    public Long getCooperId() {
        return cooperId;
    }

    public void setCooperId(Long cooperId) {
        this.cooperId = cooperId;
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
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PvuvEntity that = (PvuvEntity) o;

        if (id != that.id) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (cooperId != null ? !cooperId.equals(that.cooperId) : that.cooperId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (cooperId != null ? cooperId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
