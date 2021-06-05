package com.example.springsecuritybasicauth.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "emails")
public class EMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email_to")
    @NotBlank(message = "email not be blank")
    @Email
    private String to;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

}
