package com.cubic.model;

import sun.security.timestamp.TSRequest;

import java.sql.Timestamp;

public class Account {
    private String id;
    private String name;
    private Timestamp createTime;
    private int level;
    private Timestamp lastOnlineTime;
    private String psw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Timestamp getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(Timestamp lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
