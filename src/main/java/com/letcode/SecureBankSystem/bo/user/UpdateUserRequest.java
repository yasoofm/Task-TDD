package com.letcode.SecureBankSystem.bo.user;

public class UpdateUserRequest {
    private long userId;
    private String status;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
