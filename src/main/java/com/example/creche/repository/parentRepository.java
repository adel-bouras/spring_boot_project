package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.parent;


public interface parentRepository extends JpaRepository<parent , Long> {
    parent findByEmail(String email);
}
