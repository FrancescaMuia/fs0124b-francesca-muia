package esercizio_mercoledi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo();
        Rettangolo rettangolo2 = new Rettangolo();
        rettangolo.setAltezza(10);
        rettangolo.setLarghezza(20);
        rettangolo2.setAltezza(5);
        rettangolo2.setLarghezza(10);

        System.out.println(rettangolo.perimetro());
        stampa(rettangolo);
        stampa2(rettangolo, rettangolo2);
        }

        public static void stampa(Rettangolo rettangolo){
        System.out.println("area: " + rettangolo.area() + "perimetro: " + rettangolo.perimetro());
        }

        public static void stampa2(Rettangolo r1, Rettangolo r2){
        int sumArea = r1.area() + r2.area();
        int sumPer = r1.perimetro() + r2.perimetro();
        System.out.println("area del primo: " + r1.area() + " perimetro del primo: " + r1.perimetro());
        System.out.println("area del secondo: " + r2.area() + " perimetro del secondo: " + r2.perimetro());
            System.out.println("somma area: " + sumArea + " somma perimetro: " + sumPer);

        }
    }
