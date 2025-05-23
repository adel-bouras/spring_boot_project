package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.reponse;
import java.util.List;
import java.util.Optional;


public interface responseRepository extends JpaRepository<reponse,Long>{
    public List<reponse> findByParent(Long parent);
    public Optional<reponse> findByParentAndEnfant(Long parent , Long enfant);
}
