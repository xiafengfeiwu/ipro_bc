package com.pro.entity;

public class TenantUser {
    private String userId;

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userDisable;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserDisable() {
        return userDisable;
    }

    public void setUserDisable(String userDisable) {
        this.userDisable = userDisable;
    }
}