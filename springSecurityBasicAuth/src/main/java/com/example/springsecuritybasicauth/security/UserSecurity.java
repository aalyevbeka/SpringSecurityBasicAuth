package com.example.springsecuritybasicauth.security;

import com.example.springsecuritybasicauth.entity.Role;
import com.example.springsecuritybasicauth.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserSecurity implements UserDetails {

    private String userName;
    private String password;
    private List<SimpleGrantedAuthority> authorities;

    public UserSecurity(String userName, String password, List<SimpleGrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public static UserDetails from(User user){
        return new org.springframework.security.core.userdetails.User(
            user.getUserName(),
                user.getPassword(),
                user.getRole().getAuthority()
        );
    }
}
