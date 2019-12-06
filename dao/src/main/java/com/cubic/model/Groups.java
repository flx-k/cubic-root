package com.cubic.model;

import java.sql.Timestamp;

public class Groups {
    private String id;
    private String name;
    private Timestamp createTime;
    private String desc;

    public static Groups buidById(String id) {
        Groups g=new Groups();
        g.setId(id);
        return g;
    }
    public static Groups buidByName(String name) {
        Groups g=new Groups();
        g.setName(name);
        return g;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
