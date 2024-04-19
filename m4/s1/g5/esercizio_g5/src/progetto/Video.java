package progetto;

public class Video extends ElementoMultimediale {

    public Video(String titolo, int durata) {
        //richiamo costruttore della classe padre
        super(titolo, durata);
    }

    @Override
    public void play() {
        System.out.println("Riproduco video: " + titolo);
        //codice che mi permette di riprodurre video
    }
}
