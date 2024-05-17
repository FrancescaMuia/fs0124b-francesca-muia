package com.example.postazioni.services;

import com.example.postazioni.entities.Prenotazione;
import com.example.postazioni.exceptions.NotFoundException;
import com.example.postazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public boolean isPostazioneLibera(long postazioneId, LocalDate data){
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneIdAndDataPrenotazione(postazioneId, data);
        return prenotazioni.isEmpty();
    }

    public boolean utenteDataPrenotazione(long utenteId, LocalDate data){
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtenteIdAndDataPrenotazione(utenteId, data);
        return !prenotazioni.isEmpty();
    }

    public Prenotazione createPrenotazione(Prenotazione prenotazione){
        if(!isPostazioneLibera(prenotazione.getPostazione().getId(), prenotazione.getDataPrenotazione())){
            throw new RuntimeException("non disponibile");
        }
        if(utenteDataPrenotazione(prenotazione.getUtente().getId(), prenotazione.getDataPrenotazione())){
            throw new RuntimeException("utente ha una prenotazione");
        }
        return prenotazioneRepository.save(prenotazione);
    }
}
