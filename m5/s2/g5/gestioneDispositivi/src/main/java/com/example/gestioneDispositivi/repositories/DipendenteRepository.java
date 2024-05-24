package com.example.gestioneDispositivi.repositories;

import com.example.gestioneDispositivi.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
}
