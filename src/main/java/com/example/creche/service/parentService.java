package com.example.creche.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.creche.dtos.EnfantStatusDto;
import com.example.creche.dtos.loginDTO;
import com.example.creche.dtos.parentDto;
import com.example.creche.exceptions.userNotFound;
import com.example.creche.models.enfant;
import com.example.creche.models.parent;
import com.example.creche.models.reponse;
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

        public loginDTO login(String email, String password) throws userNotFound{

        var parent = parentrepository.findByEmail(email);
        if(parent == null || !parent.getPassword().equals(password)){
            throw new userNotFound("user not fount");
        }
        return new loginDTO(email , parent.getId());
    }

    public loginDTO signup(String email, String password){
                var parent = parentrepository.findByEmail(email);
        if(parent != null){
            throw new userNotFound("user already exists.");
        }

        parent user = new parent();
        user.setEmail(email);
        user.setPassword(password);
        this.parentrepository.save(user);
        return new loginDTO(email, user.getId());
    }

    public enfant createEnfant(@RequestBody enfant entity){
        enfant enf = new enfant();
        enf.setBirthDate(entity.getBirthDate());
        enf.setName(entity.getName());
        enf.setNationality(entity.getNationality());
        enf.setParentId(entity.getParentId());
        this.enfantrepository.save(enf);
        return enf;
    }

@PostMapping("/status")
public List<EnfantStatusDto> status( long parent) {
        return responserepository.findByParent(parent);
}
}
