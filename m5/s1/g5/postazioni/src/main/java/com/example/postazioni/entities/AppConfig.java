package com.example.postazioni.entities;

import com.example.postazioni.enums.TipoPostazione;
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

    @Bean(name = "e1")
    public Edificio e1Bean(){
        return new Edificio("ed1", "via frittole", "milano");
    }

    @Bean(name = "e2")
    public Edificio e2Bean(){
        return new Edificio("ed2", "via sassi", "milano");
    }

    @Bean(name = "p1")
    public Postazione p1Bean(){
        return  new Postazione("lorem ipsum", TipoPostazione.OPENSPACE, 10, e1Bean());
    }

    @Bean(name = "p2")
    public Postazione p2Bean(){
        return  new Postazione("ciao", TipoPostazione.PRIVATO, 8, e1Bean());
    }

    @Bean(name = "p3")
    public Postazione p3Bean(){
        return  new Postazione("ciao2", TipoPostazione.SALA_RIUNIONI, 20, e2Bean());
    }

}
