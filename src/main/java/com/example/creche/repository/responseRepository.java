package com.example.creche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.creche.dtos.EnfantStatusDto;
import com.example.creche.models.reponse;
import java.util.List;
import java.util.Optional;


public interface responseRepository extends JpaRepository<reponse,Long>{
    
    @Query("""
        SELECT new com.example.creche.dtos.EnfantStatusDto(
            e.name, 
            r.isAccepted
        ) 
        FROM enfant e 
        JOIN reponse r ON r.enfant = e.id
        WHERE r.parent = :parentId
        """)
    public List<EnfantStatusDto> findByParent(@Param("parentId") Long parent);
    public Optional<reponse> findByParentAndEnfant(Long parent , Long enfant);
}
