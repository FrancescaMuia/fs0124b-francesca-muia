package com.example.postazioni.services;

import com.example.postazioni.entities.Postazione;
import com.example.postazioni.enums.TipoPostazione;
import com.example.postazioni.exceptions.NotFoundException;
import com.example.postazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    PostazioneRepository postazioneRepository;
    public List<Postazione> getAll(){ return postazioneRepository.findAll();}
    public Postazione findById(long id){
        return postazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public void save(Postazione postazione){postazioneRepository.save(postazione);}
    public void findByIdAndDelete(long id){
        Postazione postazione = this.findById(id);
        postazioneRepository.delete(postazione);
    }

    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta){
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }
}
