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
    private Role role;

    public UserSecurity(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
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
        return new UserSecurity(
            user.getUserName(),
                user.getPassword(),
                user.getRole()
        );
    }
}
