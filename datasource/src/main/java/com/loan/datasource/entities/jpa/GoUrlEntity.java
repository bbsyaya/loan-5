package com.loan.datasource.entities.jpa;

import javax.persistence.*;

/**
 * @Description:
 * @author: shuttle
 * @date: 2017-09-22 11:09 PM
 * @company: 北京鼎力创世科技有限公司
 */
@Entity
@Table(name = "go_url", schema = "loan")
public class GoUrlEntity {
    private long id;
    private String goUrl;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "go_url")
    public String getGoUrl() {
        return goUrl;
    }

    public void setGoUrl(String goUrl) {
        this.goUrl = goUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoUrlEntity that = (GoUrlEntity) o;

        if (id != that.id) return false;
        if (goUrl != null ? !goUrl.equals(that.goUrl) : that.goUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (goUrl != null ? goUrl.hashCode() : 0);
        return result;
    }
}
