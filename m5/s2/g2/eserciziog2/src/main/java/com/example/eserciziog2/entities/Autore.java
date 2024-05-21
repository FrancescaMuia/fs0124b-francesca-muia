package com.example.eserciziog2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autori")
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String avatar;

    @OneToMany(mappedBy = "autore")
    private List<BlogPost> listaPost;
}
