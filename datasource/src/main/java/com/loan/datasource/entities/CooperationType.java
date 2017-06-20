package com.loan.datasource.entities;

/**
 * Created by shuttle on 6/19/17.
 */
public class CooperationType {
    public long cooperationId;
    public long moduleId;

    public long getCooperationId() {
        return cooperationId;
    }

    public void setCooperationId(long cooperationId) {
        this.cooperationId = cooperationId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }
}
