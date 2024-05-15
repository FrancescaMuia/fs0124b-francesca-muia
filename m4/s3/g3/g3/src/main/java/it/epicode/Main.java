package it.epicode;

import it.epicode.dao.EventoDao;
import it.epicode.enums.TipoEvento;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var eventoDAO = new EventoDao();
        var e1 = new Evento("titolo1", new Date(), "prova", TipoEvento.PUBBLICO, 100, new Location("loc1", "loc1"));

        eventoDAO.save(e1);

        System.out.println(eventoDAO.getById(1L));
    }
}