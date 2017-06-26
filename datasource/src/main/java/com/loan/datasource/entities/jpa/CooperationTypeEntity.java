package com.loan.datasource.entities.jpa;

import javax.persistence.*;

/**
 * Created by shuttle on 6/23/17.
 */
@Entity
@Table(name = "cooperation_type", schema = "loan", catalog = "")
public class CooperationTypeEntity {

    private long id;
    private long cooperationId;
    private long moduleId;

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
    @Column(name = "cooperation_id", nullable = false)
    public long getCooperationId() {
        return cooperationId;
    }

    public void setCooperationId(long cooperationId) {
        this.cooperationId = cooperationId;
    }

    @Basic
    @Column(name = "module_id", nullable = false)
    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CooperationTypeEntity that = (CooperationTypeEntity) o;

        if (cooperationId != that.cooperationId) return false;
        if (moduleId != that.moduleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cooperationId ^ (cooperationId >>> 32));
        result = 31 * result + (int) (moduleId ^ (moduleId >>> 32));
        return result;
    }
}
