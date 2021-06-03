package com.example.springsecuritybasicauth.controller;


import com.example.springsecuritybasicauth.entity.User;
import com.example.springsecuritybasicauth.repository.UserRepository;
import com.example.springsecuritybasicauth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity createNewUser(@RequestBody User user) {
        Optional<User> user1 = userRepository.findByUserName(user.getUserName());
        if (user1.isPresent()){
            return new ResponseEntity("user is exist", HttpStatus.CONFLICT);
        }
        return new ResponseEntity(userService.save(user),HttpStatus.CREATED);
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('read')")
    public String user(){
        return "user";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('read','write')")
    public String admin(){
        return "admin";
    }

    @GetMapping("/moderator")
    @PreAuthorize("hasAuthority('write')")
    public String moserator(){
        return "moderator";
    }


}
