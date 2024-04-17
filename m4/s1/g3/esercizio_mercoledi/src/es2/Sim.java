package es2;

import java.util.Arrays;

public class Sim {
    private String number;
    private int credit;
    private Calls[] lastCalls;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Calls[] getLastCalls() {
        return lastCalls;
    }

    public void setLastCalls(Calls[] lastCalls) {
        this.lastCalls = lastCalls;
    }


    public Sim(String n){
        number = n;
        credit = 0;
        this.lastCalls = new Calls[0];
    }

    public void stampaSim(){
        System.out.println("numero: " + this.getNumber());
        System.out.println("crdito: " + this.getCredit());
        System.out.println("elenco chiamate: " + Arrays.toString(this.getLastCalls()));

    }
}
