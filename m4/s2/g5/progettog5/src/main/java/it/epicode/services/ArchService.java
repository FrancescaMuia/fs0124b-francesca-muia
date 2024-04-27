package main.java.it.epicode.services;

import main.java.it.epicode.data.Documento;

import java.util.List;

public interface ArchService {
    void save();

    void load();

    void aggiungiDoc(Documento documento);

    List<Documento> isbnFind(Long isbn);

    List<Documento> annoFind(int anno);

    List<Documento> autoreFind(String autore);

    void elimina(Long isbn);
}
