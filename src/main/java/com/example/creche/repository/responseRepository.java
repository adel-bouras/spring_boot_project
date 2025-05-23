package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.reponse;

public interface responseRepository extends JpaRepository<reponse,Long>{
    
}
