package it.epicode.esercizio;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class esercizio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci numero parole: ");
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> paroleSet = new HashSet<>(); //collection di parole
        Set<String> paroleDuplicate = new HashSet<>(); //collection di duplicate

        System.out.println("inserisci " + n +" parole:"); //qui inserisco il numero di parole che ho specificato nel primo system.out

        for (int i = 0; i<n; i++){
            String parola = sc.nextLine();

            if(!paroleSet.add(parola)){
                paroleDuplicate.add(parola);
            } //se scrivo la stessa parola mettila in paroleDuplicate
        }
        sc.close();

        //stampo parole duplicate
        System.out.println("parole duplicate:");
        for (String parola : paroleDuplicate){
            System.out.println(parola);
        }

        System.out.println("numero parole distinte: " + paroleSet.size());
        //size = quantità di elementi presenti nell'array

        System.out.println("elenco parole distinte: ");
        for (String parola : paroleSet){
            System.out.println(parola);
        }
    }
}
