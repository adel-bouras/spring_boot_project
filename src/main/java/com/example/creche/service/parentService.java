package com.example.creche.service;

import org.springframework.stereotype.Service;

import com.example.creche.repository.enfantRepository;
import com.example.creche.repository.parentRepository;
import com.example.creche.repository.responseRepository;

@Service
public class parentService {

    private final parentRepository parentrepository;
    private final responseRepository responserepository;
    private final enfantRepository enfantrepository;

    public parentService(parentRepository parentrepository , responseRepository responserepository , enfantRepository enfantrepository){
        this.enfantrepository = enfantrepository;
        this.parentrepository = parentrepository;
        this.responserepository = responserepository;
    }


    
    
}
