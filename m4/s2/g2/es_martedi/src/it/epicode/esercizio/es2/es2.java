package it.epicode.esercizio.es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class es2{


    public static List<Integer> generaListaCasuale(int n) {
        Random random = new Random();
        List<Integer> lista = new ArrayList<>(); //inizializzo lista di arraylist
        for (int i = 0; i < n; i++) {
            lista.add(random.nextInt(101)); // foreach che aggiunge un random da 0 a 100 in lista
        }
        Collections.sort(lista); //la collection serve per poter modificare le liste essendo la classe padre di tutti
        return lista; // mi sputa fuori la lista come ritorno
    }


    public static List<Integer> listaConInverso(List<Integer> lista) { //inseriamo come parametro la lista precedente
        List<Integer> nuovaLista = new ArrayList<>(lista); // la inseriamo come parameteo in una nuova variabile list
        Collections.reverse(nuovaLista); // la collection usa il reverse per invertire l'ordine
        lista.addAll(nuovaLista);  // aggiungiamo nuova lista in lista e la sputiamo fuori
        return lista;
    }


    public static void stampaPosizioni(List<Integer> lista, boolean pari) { // tramite un boolean se  è true mi stampa le posizioni pari
        System.out.println("Valori in posizioni " + (pari ? "pari:" : "dispari:"));
        for (int i = pari ? 0 : 1; i < lista.size(); i += 2) { //lista.size() grandeza totale di tutta la lista e icrementi di due per la parità o la disparità
            System.out.println(lista.get(i));  //lettura del for di lista
        }
    }

    public static void main(String[] args) {

        List<Integer> listaCasuale = generaListaCasuale(5);
        System.out.println("Lista casuale ordinata: " + listaCasuale);

        List<Integer> listaConInverso = listaConInverso(new ArrayList<>(listaCasuale));
        System.out.println("Lista con inverso: " + listaConInverso);

        stampaPosizioni(listaConInverso, true);
    }
}
