package com.example.springsecuritybasicauth.service;


import com.example.springsecuritybasicauth.entity.EMail;
import com.example.springsecuritybasicauth.repository.EMailRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailSenderService {

    EMailRepository eMailRepository;
    JavaMailSender javaMailSender;


    public void sendEmail(EMail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getTo());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getText());
        eMailRepository.save(mail);
        javaMailSender.send(msg);
    }
}