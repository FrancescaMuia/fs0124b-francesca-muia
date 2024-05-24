package com.example.gestioneDispositivi.controllers;

import com.example.gestioneDispositivi.entities.Dipendente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestioneDispositivi.services.DipendenteService;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public Dipendente createDipendente(@Valid @RequestBody Dipendente dipendente) {
        return dipendenteService.save(dipendente);
    }

    @GetMapping
    public List<Dipendente> getAllDipendenti(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        return dipendenteService.getDipendenti(page, size, sort).getContent();
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable Long id) {
        return dipendenteService.findById(id);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @Valid @RequestBody Dipendente dipendente) {
        return dipendenteService.findByIdAndUpdate(id, dipendente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.findByIdAndDelete(id);
        return ResponseEntity.noContent().build();
    }
}
