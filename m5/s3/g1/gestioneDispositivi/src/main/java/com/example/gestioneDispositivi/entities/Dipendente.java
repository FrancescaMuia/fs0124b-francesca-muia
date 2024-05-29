package com.example.gestioneDispositivi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@Table(name = "dipendenti")
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message="Campo obbligatorio")
    private String nome;
    @NotBlank(message="Campo obbligatorio")
    private String cognome;
    @NotBlank(message="Campo obbligatorio")
    @Email
    private String email;
    @NotBlank(message="Campo obbligatorio")
    private String userName;
    private String pathImmagine;

    @OneToMany(mappedBy = "dipendente")
    @JsonManagedReference
    private List<Dispositivo> dispositivi;
}
