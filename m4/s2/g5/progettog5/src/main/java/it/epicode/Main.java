package main.java.it.epicode;

import main.java.it.epicode.data.Documento;
import main.java.it.epicode.data.Libri;
import main.java.it.epicode.data.Periodicita;
import main.java.it.epicode.data.Riviste;
import main.java.it.epicode.services.FileArchService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FileArchService biblio = new FileArchService();
        biblio.aggiungiDoc(new Libri(987654321L, "Lotr", 1964, 1178, "Tolkien", "Fantasy" ));
        biblio.aggiungiDoc(new Libri(999999999L, "1984", 1949, 1100, "George Orwell", "Distopia" ));
        biblio.aggiungiDoc(new Libri(888888888L, "orgoglio e Pregiudizio", 1813, 1100, "Jane Austen", "romanzo classico" ));

        biblio.aggiungiDoc(new Riviste(321654987L, "cucinare stanca", 2021, 50, Periodicita.MENSILE));

        biblio.save();
        Long isbn = 987654321L;
        int anno = 1949;
        String autore = "Tolkien";


        var isbnFound = biblio.isbnFind(isbn);
        var annoFound = biblio.annoFind(anno);
        var autoreFound = biblio.autoreFind(autore);
        biblio.elimina(isbn);




        isbnFound.forEach(d -> System.out.println("articolo trovato: " + d.getTitolo() + " " + isbn));
        annoFound.forEach(d -> System.out.println("articolo con anno: " + anno + " " + d.getTitolo()));
        autoreFound.forEach(d -> System.out.println("autore trovato: " + autore));
    }
}