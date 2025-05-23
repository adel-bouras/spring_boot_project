package com.example.creche.service;

import com.example.creche.dtos.loginDTO;
import com.example.creche.models.enfant;
import com.example.creche.repository.adminRepository;
import com.example.creche.repository.enfantRepository;
import com.example.creche.repository.responseRepository;

import org.springframework.stereotype.Service;

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

    public loginDTO login(String email, String password) {

        var admin = adminRepository.findByEmail(email);
        if (adminOpt.isPresent()) {
            var admin = adminOpt.get();
            if (admin.getPassword().equals(password)) {
                // success
                return new loginDTO(admin.getEmail(), admin.getPassword());
            }
        }
        // Failed login — return null or throw exception, adjust as needed
        return null;
    }

    // Get all enfants from DB
    public List<enfant> getAll() {
        return enfantRepository.findAll();
    }

    // Accept enfant: update child record in DB to accepted state
    public void accepteEnfant(Long parentId, Long enfantId) {
        Optional<enfant> enfantOpt = enfantRepository.findById(enfantId);
        if (enfantOpt.isPresent()) {
            enfant enfant = enfantOpt.get();
            // Update the enfant to accepted - add your field logic here
            enfant   setAccepted(true);
            enfantRepository.save(enfant);
        }
    }

    // Refuse enfant: update child record in DB to refused state
    public void refuseEnfant(Long parentId, Long enfantId) {
        Optional<enfant> enfantOpt = enfantRepository.findById(enfantId);
        if (enfantOpt.isPresent()) {
            enfant enfant = enfantOpt.get();
            // Update enfant to refused - add your field logic here
            enfant.setRefused(true);
            enfantRepository.save(enfant);
        }
    }
}
