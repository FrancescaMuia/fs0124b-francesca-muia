package com.example.GestioneEventi.services;

import com.example.GestioneEventi.entities.Ruolo;
import com.example.GestioneEventi.enums.RoleName;
import com.example.GestioneEventi.entities.Utente;
import com.example.GestioneEventi.repositories.RuoloRepository;
import com.example.GestioneEventi.repositories.UtenteRepository;
import com.example.GestioneEventi.services.dto.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private RuoloRepository ruoloRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Utente> login(String username, String password) {
        Optional<Utente> optionalUtente = utenteRepository.findByUsername(username);

        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            if (passwordEncoder.matches(password, utente.getPassword())) {
                return Optional.of(utente);
            }
        }

        return Optional.empty();
    }

    public Utente saveUtente(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        Ruolo userRole = ruoloRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
        utente.setRuoli(Collections.singleton(userRole));
        return utenteRepository.save(utente);
    }

    public Optional<Utente> findByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    public Optional<Utente> findById(Long id) {
        return utenteRepository.findById(id);
    }
}
