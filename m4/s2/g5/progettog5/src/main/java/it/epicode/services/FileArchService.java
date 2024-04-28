package main.java.it.epicode.services;

import main.java.it.epicode.data.Documento;
import main.java.it.epicode.data.Libri;
import main.java.it.epicode.data.Periodicita;
import main.java.it.epicode.data.Riviste;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileArchService implements ArchService {
    private static final Logger logger = LoggerFactory.getLogger(FileArchService.class);

    //memoria in cui conserverò i dati successivamente
    private static final String STORAGE = "./project.csv";

    //memorizzo tutti i dati che inserisco nell'arraylist
    private final ArrayList<Documento> doc = new ArrayList<>();

    //costruttore che runna il file
    public FileArchService() {
        load();
    }

    //metodo per salvare dati nel file
    @Override
    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.write(f, "", StandardCharsets.ISO_8859_1); //uso la libreria fileutils per scrivere il documento
            for (Documento d : doc) {
                List<String> lines = new ArrayList<>(); //genero un array string all'interno dell'array doc
                lines.add(d.getClass().getSimpleName()); //aggiungo libro o rivista in base alla classe
                lines.add(d.getIsbn().toString()); //aggiungo l'isbn
                lines.add(d.getTitolo()); //aggiungo il titolo
                lines.add(String.valueOf(d.getAnno())); //aggiungo anno (valueOf converte a stringa)
                lines.add(String.valueOf(d.getNumeroPagine())); //aggiungo n pagine
                if (d instanceof Libri) { //se istanza di libro aggiungo autore e genere
                    Libri l = (Libri) d;
                    lines.add(l.getAutore());
                    lines.add(l.getGenere());
                } else if (d instanceof Riviste) { //se istanza di rivista aggiungo periodicità
                    Riviste r = (Riviste) d;
                    lines.add(r.getPeriodicita().toString());
                }
                //scrivo una stringa su un file utilizzando la libreria Apache Commons IO
                FileUtils.writeStringToFile(f, String.join(",", lines) + System.lineSeparator(), StandardCharsets.ISO_8859_1, true);
            }
        } catch (IOException e) {
            logger.error("Eccezione durante il salvataggio", e);
        }
}

    @Override
    public void load() { //carico il documento
        File f = new File(STORAGE);
        if (!f.exists()) return;
        try {
            List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
            for (String line : lines) {
                String[] parts = line.split(","); //nell'array parse divido tutto con una ,
                Long isbn = Long.parseLong(parts[1]); //converto da string a long
                String titolo = parts[2];
                int anno = Integer.parseInt(parts[3]);
                int numeroPagine = Integer.parseInt(parts[4]);
                if ("Libro".equals(parts[0])) { //se libro leggo autore e genere
                    String autore = parts[5];
                    String genere = parts[6];
                    doc.add(new Libri(isbn, titolo, anno, numeroPagine, autore, genere)); //aggiungo il costruttore di libri
                } else if ("Rivista".equals(parts[0])) {  //se è rivista leggo periodicità
                    Periodicita periodicita = Periodicita.valueOf(parts[5]);

                    doc.add(new Riviste(isbn, titolo, anno, numeroPagine, periodicita));
                }
            }
        } catch (IOException e) {
            logger.error("Eccezione durante il caricamento", e);
        }
    }

    @Override
    public void aggiungiDoc(Documento documento){ //aggiungo il documento
        doc.add(documento);
    }

    @Override
    public List<Documento> isbnFind(Long isbn) { //ricerca del documento per isbn
        return doc.stream().filter(d -> d.getIsbn().equals(isbn)).toList();
    }

    @Override
    public List<Documento> annoFind(int anno) { //ricerca per anno
        return doc.stream().filter(d -> d.getAnno()==(anno)).collect(Collectors.toList()); //raggruppo e aggiungo alla lista
    }

    @Override
    public List<Documento> autoreFind(String autore) {
        return doc.stream().filter(d -> d instanceof Libri && ((Libri) d).getAutore().equals(autore)).collect(Collectors.toList());
    }
    //instanceof prende solo gli elementi di tipo Libri (per accedere ai metodi delle classi figlie)

    @Override
    public void elimina(Long isbn){
        doc.removeIf(d -> d.getIsbn().equals(isbn)); //elimino articolo
    }
}
