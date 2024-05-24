package com.example.gestioneDispositivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.gestioneDispositivi.entities.Dipendente;
import com.example.gestioneDispositivi.repositories.DipendenteRepository;
import com.example.gestioneDispositivi.exceptions.NotFoundException;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dipendente save(Dipendente body){
        return dipendenteRepository.save(body);
    }

    public Page<Dipendente> getDipendenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dipendenteRepository.findAll(pageable);
    }

    public Dipendente findById(Long id){
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(Long id){
        Dipendente found = this.findById(id);
        dipendenteRepository.delete(found);
    }

    public Dipendente findByIdAndUpdate(Long id, Dipendente body){
        Dipendente found = this.findById(id);
        found.setEmail(body.getEmail());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setUserName(body.getUserName());
        return dipendenteRepository.save(found);
    }
}
