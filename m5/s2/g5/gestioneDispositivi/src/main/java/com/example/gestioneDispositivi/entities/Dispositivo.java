package com.example.gestioneDispositivi.entities;

import com.example.gestioneDispositivi.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "dispositivi")
@NoArgsConstructor
@AllArgsConstructor
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String tipologia;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;

    @ManyToOne
    private Dipendente dipendente;
}
