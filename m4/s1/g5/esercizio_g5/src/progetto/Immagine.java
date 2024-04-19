package progetto;

public class Immagine extends ElementoMultimediale {

    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        //richiamo costruttore della classe padre
        super(titolo, 0); //non ha la durata perciò metto 0
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        System.out.println("Riproduco l'immagine: " + titolo);
        //codice che mi permette di visualizzare un'immagine
    }

    //metodo solo dell'immagine
    public void show(){
        System.out.print(this.titolo);
        for (int i=0; i<luminosita; i++){
            System.out.print("*");
        }
        System.out.println(" ");
    }

    public void aumentaLum(){
        if(luminosita<10) {
            luminosita++;
        }
        else {
            System.out.println("luminosità al massimo");
        }
    }

    public void diminuisciLum(){
        if(luminosita>0){
            luminosita--;
        }
        else {
            System.out.println("luminosità al minimo");
        }
    }
}
