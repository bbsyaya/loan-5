package com.loan.datasource.entities.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by shuttle on 6/23/17.
 */
@Entity
@Table(name = "module", schema = "loan")
public class ModuleEntity {
    private long id;
    private String name;
    private String code;
    private Timestamp createTime;
    private Byte sort;
    private Byte enabled;
    private Byte index;
    private String logo;

    //private Set<CooperationEntity> cooperationTypeEntityList;

//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name="cooperation_type",
//            joinColumns={@JoinColumn(name="module_id",referencedColumnName="id")},
//            inverseJoinColumns ={@JoinColumn(name="cooperation_id",referencedColumnName="id")}
//    )
//    public Set<CooperationEntity> getCooperationTypeEntityList() {
//        return cooperationTypeEntityList;
//    }
//    @ManyToMany(mappedBy = "moduleEntitys")
//    public void setCooperationTypeEntityList(Set<CooperationEntity> cooperationTypeEntityList) {
//        this.cooperationTypeEntityList = cooperationTypeEntityList;
//    }

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
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "sort", nullable = true)
    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "enabled", nullable = true)
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "index", nullable = true)
    public Byte getIndex() {
        return index;
    }

    public void setIndex(Byte index) {
        this.index = index;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = 256)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleEntity that = (ModuleEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;
        if (index != null ? !index.equals(that.index) : that.index != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        return result;
    }
}
