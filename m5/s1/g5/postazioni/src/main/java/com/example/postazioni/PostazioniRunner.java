package com.example.postazioni;

import com.example.postazioni.entities.Edificio;
import com.example.postazioni.entities.Postazione;
import com.example.postazioni.entities.Prenotazione;
import com.example.postazioni.entities.Utente;
import com.example.postazioni.services.EdificioService;
import com.example.postazioni.services.PostazioneService;
import com.example.postazioni.services.PrenotazioneService;
import com.example.postazioni.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class PostazioniRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PostazioniRunner.class);
    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

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

        Prenotazione pren1 = Prenotazione.builder()
                .withUtente(u1)
                .withPostazione(p1)
                .withDataPrenotazione(LocalDate.now().plusDays(2))
                .build();

        Prenotazione pren2 = Prenotazione.builder()
                .withUtente(u2)
                .withPostazione(p2)
                .withDataPrenotazione(LocalDate.now().plusDays(1))
                .build();

        try{
            prenotazioneService.createPrenotazione(pren1);
            prenotazioneService.createPrenotazione(pren2);
        } catch(RuntimeException e){
            log.error("errore");
        }
    }
}
