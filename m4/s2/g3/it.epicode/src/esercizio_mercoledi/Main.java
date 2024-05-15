package esercizio_mercoledi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//con l'istanza di order arrivano i prodotti
        Order order = new Order(0, null,null,null, null, null);
        order.addProduct(1, "lotr", "book", 100.50);
        order.addProduct(2, "fight club", "book", 200.12);
        order.addProduct(3, "alice nel paese delle meraviglie", "book", 120.50);
        order.addProduct(4, "i tre porcellini", "book", 7.20);
        order.addProduct(5, "peter pan", "book", 500.10);
        order.addProduct(6, "passeggino", "baby", 5.10);
        order.addProduct(7, "pannolini", "baby", 10.20);
        order.addProduct(8, "pantaloni", "boys", 50.30);
        order.addProduct(9, "felpa", "boys", 20.20);
        order.addProduct(10, "cappello", "boys", 10.50);

        //stream è il metodo per far partire una serie di metodi che modificano array
        //lista per categoria book
        order.products.stream().filter(p -> p.getCategory().equals("book") && p.getPrice() >100).forEach(System.out::println);

        //lista per cat baby
        order.products.stream().filter(p -> p.getCategory().equals("baby")).forEach(System.out::println);

        final double SCONTO = 0.1; //variabile che contiene lo sconto

        //aggiungo lo sconto ai prodotti boys
        order.products.stream()
                .filter(p -> p.getCategory().equals("boys"))
                .map(p -> {
                    //map ha sempre return
                    double prezzoScontato = p.getPrice() * (1 - SCONTO);
                    p.setPrice(prezzoScontato); //il set perché lo sconto potrebbe cambiare
                    return p;
                })
                .forEach(System.out::println);
    }
}