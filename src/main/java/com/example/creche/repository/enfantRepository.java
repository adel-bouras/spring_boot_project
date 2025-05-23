package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.enfant;

public interface enfantRepository extends JpaRepository<enfant , Long> {
    
}
