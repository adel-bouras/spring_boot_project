package com.example.creche.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.creche.service.parentService;

@RestController
@RequestMapping("/parent")
public class parentController {
    private final parentService parentservice;

    public parentController(parentService Pservice){
        this.parentservice = Pservice;
    }
    
}
