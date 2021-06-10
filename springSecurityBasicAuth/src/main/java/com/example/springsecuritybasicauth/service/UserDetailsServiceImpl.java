package com.example.springsecuritybasicauth.service;

import com.example.springsecuritybasicauth.entity.User;
import com.example.springsecuritybasicauth.repository.UserRepository;
import com.example.springsecuritybasicauth.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(name).orElseThrow(()->
                new UsernameNotFoundException("user not fount"));
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add((GrantedAuthority) () -> user.getRole().name());
        return UserSecurity.from(user);
    }
}
