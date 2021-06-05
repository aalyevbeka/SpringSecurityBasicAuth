package com.example.springsecuritybasicauth.repository;

import com.example.springsecuritybasicauth.entity.EMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMailRepository extends JpaRepository<EMail, Long> {
}
