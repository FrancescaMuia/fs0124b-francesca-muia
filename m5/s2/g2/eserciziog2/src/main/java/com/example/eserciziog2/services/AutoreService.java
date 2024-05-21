package com.example.eserciziog2.services;

import com.example.eserciziog2.entities.Autore;
import com.example.eserciziog2.exceptions.NotFoundException;
import com.example.eserciziog2.repositories.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public List<Autore> getAll() {
        return autoreRepository.findAll();
    }

    public Autore findById(long id) { return autoreRepository.findById(id).orElseThrow(() -> new NotFoundException(id));}

    public void save(Autore autore) {autoreRepository.save(autore);}

    public void findByIdAndDelete(long id) {
        Autore autore = this.findById(id);
        autoreRepository.delete(autore);
    }


}