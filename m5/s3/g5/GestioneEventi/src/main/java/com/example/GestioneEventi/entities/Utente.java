package com.example.GestioneEventi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Entity
@Table(name = "utenti")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Utente extends BaseEntity {

    private String nome;
    private String cognome;
    @EqualsAndHashCode.Include
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
