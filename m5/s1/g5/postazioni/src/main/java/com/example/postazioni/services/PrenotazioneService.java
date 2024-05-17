package com.example.postazioni.services;

import com.example.postazioni.entities.Prenotazione;
import com.example.postazioni.exceptions.NotFoundException;
import com.example.postazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository prenotazioneRepository;
    public List<Prenotazione> getAll(){ return prenotazioneRepository.findAll();}
    public Prenotazione findById(long id){
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void save(Prenotazione prenotazione){prenotazioneRepository.save(prenotazione);}
    public void findByIdAndDelete(long id){
        Prenotazione prenotazione = this.findById(id);
        prenotazioneRepository.delete(prenotazione);
    }
}
