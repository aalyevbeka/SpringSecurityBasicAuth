package com.example.springsecuritybasicauth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
//    USER(Set.of(Permission.READ)),
//    MODERATOR(Set.of(Permission.WRITE)),
//    ADMIN(Set.of(Permission.READ, Permission.WRITE));
//
//
//    private final Set<Permission> permissions;
//
//    Role(Set<Permission> permissions) {
//        this.permissions = permissions;
//    }
//
//    public Set<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public Set<SimpleGrantedAuthority> getAuthority(){
//    return getPermissions().stream().map(permission ->
//            new SimpleGrantedAuthority(permission.getPermission())).
//            collect(Collectors.toSet());
//    }

    USER,
    MODERATOR,
    ADMIN;


}
