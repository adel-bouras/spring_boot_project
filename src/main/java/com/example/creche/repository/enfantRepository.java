package com.example.creche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.enfant;

public interface enfantRepository extends JpaRepository<enfant , Long> {
    public List<enfant> findByParentId(Long parentId);
    
}
