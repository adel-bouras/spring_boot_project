package com.example.creche.service;

import com.example.creche.dtos.loginDTO;
import com.example.creche.exceptions.userNotFound;
import com.example.creche.models.enfant;
import com.example.creche.models.reponse;
import com.example.creche.repository.adminRepository;
import com.example.creche.repository.enfantRepository;
import com.example.creche.repository.responseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

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

    public void accepteEnfant(Long parentId, Long enfantId) {
        reponse res = new reponse();
        res.setEnfant(enfantId);
        res.setIsAccepted(true);
        res.setParent(parentId);
        this.responserepository.save(res);
    }

    public void refuseEnfant(Long parentId, Long enfantId) {
        reponse res = new reponse();
        res.setEnfant(enfantId);
        res.setIsAccepted(false);
        res.setParent(parentId);
        this.responserepository.save(res);
    }
}
