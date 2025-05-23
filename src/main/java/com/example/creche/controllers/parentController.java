package com.example.creche.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.creche.dtos.loginDTO;
import com.example.creche.dtos.parentDto;
import com.example.creche.models.enfant;
import com.example.creche.models.reponse;
import com.example.creche.service.parentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin(origins = "*")  
@RestController
@RequestMapping("/parent")
public class parentController {
    private final parentService parentservice;

    public parentController(parentService Pservice){
        this.parentservice = Pservice;
    }

    @PostMapping("/login")
    public parentDto login(@RequestBody loginDTO entity) {
       loginDTO par =  this.parentservice.login(entity.getEmail(), entity.getPassword());
        
        return new parentDto(par.getEmail(), par.getId()) ;
    }

    @PostMapping("/signup")
    public parentDto signup(@RequestBody loginDTO entity) {
       loginDTO par =  this.parentservice.signup(entity.getEmail(), entity.getPassword());
        
        return new parentDto(par.getEmail(), par.getId()) ;
    }

    @PostMapping("/create")
    public enfant create(@RequestBody enfant entity) {
        enfant enf = this.parentservice.createEnfant(entity);
        return enf;
    }

    @GetMapping("/status")
    public List<reponse> getMethodName(@RequestBody parentDto param) {
        return this.parentservice.status(param);
    }
    
    
    
    
}
