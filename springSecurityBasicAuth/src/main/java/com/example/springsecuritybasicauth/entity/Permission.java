package com.example.springsecuritybasicauth.entity;

import lombok.Data;

public enum Permission {
    READ("read"),
    WRITE("write");
    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
