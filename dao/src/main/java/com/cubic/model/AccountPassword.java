package com.cubic.model;

import java.sql.Timestamp;
import java.util.Date;

public class AccountPassword {
    public class ChangePassword{
        public String oldPassword;
        public String newPassword;
    }
    private String id;
    private String name;
    private String pwd;
    private Timestamp updateTime;

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public AccountPassword() {

    }

    public AccountPassword(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public static AccountPassword buildByName(String name) {
        AccountPassword accountPassword = new AccountPassword();
        accountPassword.setName(name);
        return accountPassword;
    }

    public AccountPassword(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.pwd = account.getPwd();
        this.updateTime=new Timestamp(new Date().getTime());
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
