package com.example.postazioni.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "u1")
    public Utente u1Bean(){
        return new Utente("giuliab","Giulia", "Bianchi", "giuliabianchi@gmail.com");
    }

    @Bean(name = "u2")
    public Utente u2Bean(){
        return new Utente("giorgion","Giorgio", "Neri", "giorgioneri@gmail.com");
    }

    @Bean(name = "u3")
    public Utente u3Bean(){
        return new Utente("fabiov","Fabio", "Verdi", "fabioverdi@gmail.com");
    }
}
