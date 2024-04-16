package mario;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean res= PariDispari("Marzio");
        System.out.println("il numero è pari?" + res);
        System.out.println("è bisestile?" + annoBisestile(2021));
        System.out.println("è bisestile?" + annoBisestile(2020));
        es4();
    }

    public static boolean PariDispari(String stringa){
        return stringa.length() % 2 == 0;
    }

    public static boolean annoBisestile(int anno){
        if (anno % 4 == 0){
            if((anno%100==0 && anno%400==0) || (anno%100!=0)){
                return true;
            }
        }
        return false;
    }

    public static void es4(){
        System.out.print("inserisci stringa:");
        String s= new Scanner(System.in).nextLine();
        String[] arr= s.split("");
        int i=0;
        while(i<arr.length){
           System.out.print(arr[i]);
           if(i< arr.length -1){
               System.out.print(", ");
           }
           i++;
        }
    }
}