package com.example.GestioneEventi.controllers;

import com.example.GestioneEventi.entities.Utente;
import com.example.GestioneEventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public ResponseEntity<Utente> registerUser(@RequestBody Utente utente) {
        if (utenteService.findByUsername(utente.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Utente savedUtente = utenteService.saveUtente(utente);
        return ResponseEntity.ok(savedUtente);
    }
}
