package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creche.models.reponse;
import java.util.List;


public interface responseRepository extends JpaRepository<reponse,Long>{
    public List<reponse> findByparent(Long parent);
}
