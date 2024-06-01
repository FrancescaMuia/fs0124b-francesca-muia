package com.example.GestioneEventi.controllers;

import com.example.GestioneEventi.entities.Prenotazione;
import com.example.GestioneEventi.entities.Utente;
import com.example.GestioneEventi.services.PrenotazioneService;
import com.example.GestioneEventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Prenotazione> findAll() {
        return prenotazioneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> findById(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneService.findById(id);
        return prenotazione.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prenotazione save(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.save(prenotazione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/myreservation")
    public ResponseEntity<List<Prenotazione>> getCurrentUserPrenotazioni() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Utente> utenteOptional = utenteService.findByUsername(username);
        if (utenteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Utente utente = utenteOptional.get();
        List<Prenotazione> prenotazioni = utente.getPrenotazioni();
        return ResponseEntity.ok(prenotazioni);
    }



    @DeleteMapping("/myreservation/{id}")
    public ResponseEntity<Void> deleteCurrentUserPrenotazione(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<Utente> utente = utenteService.findByUsername(username);
        if (utente == null) {
            return ResponseEntity.notFound().build();
        }
        Optional<Prenotazione> prenotazione = prenotazioneService.findById(id);
        if (prenotazione.isPresent() && prenotazione.get().getUtente().equals(utente)) {
            prenotazioneService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
