package com.example.postazioni;

import com.example.postazioni.entities.Edificio;
import com.example.postazioni.entities.Postazione;
import com.example.postazioni.entities.Utente;
import com.example.postazioni.services.EdificioService;
import com.example.postazioni.services.PostazioneService;
import com.example.postazioni.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class PostazioniRunner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

   @Autowired
   private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        Utente u1= (Utente) ctx.getBean("u1");
        Utente u2= (Utente) ctx.getBean("u2");
        Utente u3= (Utente) ctx.getBean("u3");

        Edificio e1=(Edificio) ctx.getBean("e1");
        Edificio e2=(Edificio) ctx.getBean("e2");

        Postazione p1= (Postazione) ctx.getBean("p1");
        Postazione p2= (Postazione) ctx.getBean("p2");
        Postazione p3= (Postazione) ctx.getBean("p3");

        utenteService.save(u1);
        utenteService.save(u2);
        utenteService.save(u3);

        edificioService.save(e1);
        edificioService.save(e2);

        postazioneService.save(p1);
        postazioneService.save(p2);
        postazioneService.save(p3);

    }
}
