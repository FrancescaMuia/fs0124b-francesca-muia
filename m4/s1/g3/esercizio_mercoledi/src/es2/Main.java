package es2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Sim sim1 = new Sim("3928231509");
        System.out.println(Arrays.toString(sim1.getLastCalls()));
        sim1.stampaSim();
    }
}
