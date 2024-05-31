package com.example.GestioneEventi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "prenotazioni")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione extends BaseEntity{
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private Evento evento;
}
