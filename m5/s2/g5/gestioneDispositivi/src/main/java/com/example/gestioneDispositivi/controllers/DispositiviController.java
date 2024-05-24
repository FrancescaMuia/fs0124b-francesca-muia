package com.example.gestioneDispositivi.controllers;

import entities.Dipendente;
import entities.Dispositivo;
import enums.StatoDispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DipendenteService;
import services.DispositivoService;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

    @Autowired
    private DispositivoService dispositivoService;
    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public Dispositivo createDispositivo(@RequestBody Dispositivo dispositivo) {
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
    public Dispositivo updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        return dispositivoService.findByIdAndUpdate(id, dispositivo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.findByIdAndDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/assign/{id}")
    public Dispositivo assignDispositivo(@PathVariable Long id, @RequestParam Long dipendenteId) {
        Dispositivo dispositivo = dispositivoService.findById(id);
        Dipendente dipendente = dipendenteService.findById(dipendenteId);
        dispositivo.setDipendente(dipendente);
        dispositivo.setStato(StatoDispositivo.ASSEGNATO);
        return dispositivoService.findByIdAndUpdate(id, dispositivo);
    }
}
