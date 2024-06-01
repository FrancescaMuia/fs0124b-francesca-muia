package com.example.GestioneEventi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import lombok.*;

import java.util.List;
import java.util.Set;


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
    private String token;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utente_ruoli",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "ruolo_id")
    )
    private Set<Ruolo> ruoli;

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
