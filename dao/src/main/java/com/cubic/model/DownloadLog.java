package com.cubic.model;

public class DownloadLog {
    private String id;
    private String accountId;
    private String accountName;
    private String projectId;
    private String projectName;
    private String downloadTimes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(String downloadTimes) {
        this.downloadTimes = downloadTimes;
    }
}
