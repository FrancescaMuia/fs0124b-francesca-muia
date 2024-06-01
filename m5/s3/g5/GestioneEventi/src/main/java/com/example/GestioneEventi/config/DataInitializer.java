package com.example.GestioneEventi.config;

import com.example.GestioneEventi.entities.Ruolo;
import com.example.GestioneEventi.enums.RoleName;
import com.example.GestioneEventi.repositories.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RuoloRepository ruoloRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ruoloRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
            Ruolo userRole = new Ruolo();
            userRole.setName(RoleName.ROLE_USER);
            ruoloRepository.save(userRole);
        }
        if (ruoloRepository.findByName(RoleName.ROLE_ORGANIZER).isEmpty()) {
            Ruolo organizerRole = new Ruolo();
            organizerRole.setName(RoleName.ROLE_ORGANIZER);
            ruoloRepository.save(organizerRole);
        }
    }
}
