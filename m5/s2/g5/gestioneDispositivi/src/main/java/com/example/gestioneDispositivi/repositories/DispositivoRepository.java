package com.example.gestioneDispositivi.repositories;

import com.example.gestioneDispositivi.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
}
