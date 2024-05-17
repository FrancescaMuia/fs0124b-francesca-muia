package com.example.postazioni.entities;

import com.example.postazioni.enums.TipoPostazione;
import jakarta.persistence.Entity;
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
    private Edificio edificio;
    private boolean libera;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}
