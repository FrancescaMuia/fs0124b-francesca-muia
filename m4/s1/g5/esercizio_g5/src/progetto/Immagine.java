package progetto;

public class Immagine extends ElementoMultimediale {

    public Immagine(String titolo, int durata) {
        super(titolo, durata);
    }

    @Override
    public void play() {
        System.out.println("Riproduco l'immagine: " + titolo);
        //codice che mi permette di visualizzare un'immagine
    }
}
