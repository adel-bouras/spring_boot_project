package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.admin;


public interface adminRepository extends JpaRepository<admin , Long> {
    admin findByEmail(String email);
}
