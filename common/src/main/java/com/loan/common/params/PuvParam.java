package com.loan.common.params;

/**
 * @Description: puv参数
 * @author: shuttle
 * @date: 2017-08-28 11:39 PM
 */
public class PuvParam {
    private Long userId;
    private Long cooperId;
    private String ip;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCooperId() {
        return cooperId;
    }

    public void setCooperId(Long cooperId) {
        this.cooperId = cooperId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
