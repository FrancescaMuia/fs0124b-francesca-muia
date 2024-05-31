package com.example.GestioneEventi.controllers;

import com.example.GestioneEventi.entities.Utente;
import com.example.GestioneEventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/{id}/prenotazioni")
    public ResponseEntity<?> getUserPrenotazioni(@PathVariable Long id) {
        return utenteService.findById(id)
                .map(utente -> ResponseEntity.ok(utente.getPrenotazioni()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
