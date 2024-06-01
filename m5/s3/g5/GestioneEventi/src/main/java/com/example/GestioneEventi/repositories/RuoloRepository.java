package com.example.GestioneEventi.repositories;

import com.example.GestioneEventi.entities.Ruolo;
import com.example.GestioneEventi.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
    Optional<Ruolo> findByName(RoleName roleName);
}

