package com.example.postazioni.entities;

import com.example.postazioni.enums.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Postazione extends BaseEntity{
    private String descrizione;
    private TipoPostazione tipo;
    private int maxOccupati;
    @ManyToOne
    private Edificio edificio;
    private boolean libera;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, TipoPostazione tipo, int maxOccupati, Edificio edificio){
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxOccupati = maxOccupati;
        this.edificio = edificio;
        this.libera = true;
    }
}
