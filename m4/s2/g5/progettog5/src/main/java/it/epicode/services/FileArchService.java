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

    private static final String STORAGE = "./project.csv";

    private final ArrayList<Documento> doc = new ArrayList<>();

    public FileArchService() {
        load();
    }

    @Override
    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.write(f, "", StandardCharsets.ISO_8859_1);
            for (Documento d : doc) {
                List<String> lines = new ArrayList<>();
                lines.add(d.getClass().getSimpleName()); //aggiunge se libro o rivista
                lines.add(d.getIsbn().toString());
                lines.add(d.getTitolo());
                lines.add(String.valueOf(d.getAnno()));
                lines.add(String.valueOf(d.getNumeroPagine()));
                if (d instanceof Libri) {
                    Libri l = (Libri) d;
                    lines.add(l.getAutore());
                    lines.add(l.getGenere());
                } else if (d instanceof Riviste) {
                    Riviste r = (Riviste) d;
                    lines.add(r.getPeriodicita().toString());
                }
                FileUtils.writeStringToFile(f, String.join(",", lines) + System.lineSeparator(), StandardCharsets.ISO_8859_1, true);
            }
        } catch (IOException e) {
            logger.error("Eccezione durante il salvataggio", e);
        }
}

    @Override
    public void load() {
        File f = new File(STORAGE);
        if (!f.exists()) return;
        try {
            List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
            for (String line : lines) {
                String[] parts = line.split(",");
                Long isbn = Long.parseLong(parts[1]);
                String titolo = parts[2];
                int anno = Integer.parseInt(parts[3]);
                int numeroPagine = Integer.parseInt(parts[4]);
                if ("Libro".equals(parts[0])) {
                    String autore = parts[5];
                    String genere = parts[6];
                    doc.add(new Libri(isbn, titolo, anno, numeroPagine, autore, genere));
                } else if ("Rivista".equals(parts[0])) {
                    Periodicita periodicita = Periodicita.valueOf(parts[5]);

                    doc.add(new Riviste(isbn, titolo, anno, numeroPagine, periodicita));
                }
            }
        } catch (IOException e) {
            logger.error("Eccezione durante il caricamento", e);
        }
    }

    @Override
    public void aggiungiDoc(Documento documento){
        doc.add(documento);
    }

    @Override
    public List<Documento> isbnFind(Long isbn) {
        return doc.stream().filter(d -> d.getIsbn().equals(isbn)).toList();
    }

    @Override
    public List<Documento> annoFind(int anno) {
        return doc.stream().filter(d -> d.getAnno()==(anno)).collect(Collectors.toList());
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
