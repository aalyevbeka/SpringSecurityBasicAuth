package com.example.springsecuritybasicauth.service;

import com.example.springsecuritybasicauth.entity.Role;
import com.example.springsecuritybasicauth.entity.User;
import com.example.springsecuritybasicauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.transform.sax.SAXResult;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user){
        User user1 = new User();
        user1.setUserName(user.getUserName());
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setRole(Role.USER);

        return userRepository.save(user1);
    }
}
