package com.example.creche.service;

import com.example.creche.dtos.loginDTO;
import com.example.creche.exceptions.userNotFound;
import com.example.creche.models.enfant;
import com.example.creche.models.reponse;
import com.example.creche.repository.adminRepository;
import com.example.creche.repository.enfantRepository;
import com.example.creche.repository.responseRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class adminService {

    private final adminRepository adminRepository;
    private final enfantRepository enfantRepository;
    private final responseRepository responserepository;

    public adminService(adminRepository adminRepository, enfantRepository enfantRepository , responseRepository responserepository) {
        this.adminRepository = adminRepository;
        this.enfantRepository = enfantRepository;
        this.responserepository = responserepository;
    }

    public loginDTO login(String email, String password) throws userNotFound{

        var admin = adminRepository.findByEmail(email);
        if(admin == null || !admin.getPassword().equals(password)){
            throw new userNotFound("user not fount");
        }
        return new loginDTO(email , admin.getId());
    }

    public List<enfant> getAll() {
        return enfantRepository.findAll();
    }

    public Optional<enfant> detaille(@RequestBody Long body){
        return this.enfantRepository.findById(body);
    }

public void accepteEnfant(Long parentId, Long enfantId) {
    Optional<reponse> existingResponse = responserepository.findByParentAndEnfant(parentId, enfantId);
    
    reponse res;
    if (existingResponse.isPresent()) {
        res = existingResponse.get();
    } else {
        res = new reponse();
        res.setParent(parentId);
        res.setEnfant(enfantId);
    }
    
    res.setIsAccepted(true);
    this.responserepository.save(res);
}

public void refuseEnfant(Long parentId, Long enfantId) {
    Optional<reponse> existingResponse = responserepository.findByParentAndEnfant(parentId, enfantId);
    reponse res;
    if (existingResponse.isPresent()) {
        res = existingResponse.get();
    } else {
        res = new reponse();
        res.setParent(parentId);
        res.setEnfant(enfantId);
    }
    
    res.setIsAccepted(false);
    this.responserepository.save(res);
}
}
