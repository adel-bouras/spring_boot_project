package com.example.creche.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.creche.dtos.adminDto;
import com.example.creche.dtos.enfantAccepted;
import com.example.creche.dtos.enfantRefused;
import com.example.creche.dtos.loginDTO;
import com.example.creche.models.enfant;
import com.example.creche.service.adminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/admin")
public class adminController {
    private adminService adminservice;

    public adminController(adminService Aservice){
        this.adminservice = Aservice;
    }
    
    @PostMapping("/login")
    public adminDto login(@RequestBody loginDTO entity) {
        loginDTO res = adminservice.login(entity.getEmail(), entity.getPassword());
        
        return new adminDto(res.getEmail());
    }

    @GetMapping("/enfants")
    public List<enfant> GetAllEnfants() {
        return this.adminservice.getAll();
    }

    @PostMapping("/accept")
    public enfantAccepted acceptEnfant(@RequestBody enfantAccepted entity) {
        this.adminservice.accepteEnfant(entity.getParentid(), entity.getEnfantid());
        return entity;
    }
    
        @PostMapping("/refuse")
    public enfantRefused refuseEnfant(@RequestBody enfantRefused entity) {
        this.adminservice.refuseEnfant(entity.getParentid(), entity.getEnfantid());
        return entity;
    }
    
    

    
    
}
