package com.example.gestioneDispositivi.controllers;

import com.example.gestioneDispositivi.entities.Dipendente;
import com.example.gestioneDispositivi.entities.Dispositivo;
import com.example.gestioneDispositivi.enums.StatoDispositivo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gestioneDispositivi.services.DipendenteService;
import com.example.gestioneDispositivi.services.DispositivoService;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

    @Autowired
    private DispositivoService dispositivoService;
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public Dispositivo createDispositivo(@Valid @RequestBody Dispositivo dispositivo) {
        return dispositivoService.save(dispositivo);
    }

    @GetMapping
    public List<Dispositivo> getAllDispositivi(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        return dispositivoService.getDispositivi(page, size, sort).getContent();
    }

    @GetMapping("/{id}")
    public Dispositivo getDispositivoById(@PathVariable Long id) {
        return dispositivoService.findById(id);
    }

    @PutMapping("/{id}")
    public Dispositivo updateDispositivo(@PathVariable Long id, @Valid @RequestBody Dispositivo dispositivo) {
        return dispositivoService.findByIdAndUpdate(id, dispositivo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.findByIdAndDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/assign/{id}/{dipendenteId}")
    public Dispositivo assignDispositivo(@PathVariable Long id, @PathVariable Long dipendenteId) {
        Dispositivo dispositivo = dispositivoService.findById(id);
        Dipendente dipendente = dipendenteService.findById(dipendenteId);
        dispositivo.setDipendente(dipendente);
        dispositivo.setStato(StatoDispositivo.ASSEGNATO);
        return dispositivoService.findByIdAndUpdate(id, dispositivo);
    }
}