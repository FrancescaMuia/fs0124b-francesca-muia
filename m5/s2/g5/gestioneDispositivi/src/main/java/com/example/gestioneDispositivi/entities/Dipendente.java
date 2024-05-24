package com.example.gestioneDispositivi.entities;

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
    @NotBlank
    @NotEmpty
    @NotNull
    private String nome;
    @NotBlank
    @NotEmpty
    @NotNull
    private String cognome;
    @NotBlank
    @NotEmpty
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotEmpty
    @NotNull
    private String userName;

    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivi;
}
