package com.example.springsecuritybasicauth.controller;


import com.example.springsecuritybasicauth.entity.EMail;
import com.example.springsecuritybasicauth.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EMailSenderController {

    private EmailSenderService emailSenderService;

    @PostMapping("/sendmail")
    @PreAuthorize("hasAnyAuthority('read','write')")
    public ResponseEntity sendMessage(@RequestBody EMail eMail) {
        emailSenderService.sendEmail(eMail);
            return new ResponseEntity("success", HttpStatus.ACCEPTED);

    }

}
