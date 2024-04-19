package progetto;

public class RegistrazioneAudio extends ElementoMultimediale {

    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
    }
    @Override
    public void play() {
        System.out.println("Riproduco audio: " + titolo);
        //codice che mi permette di riprodurre audio
    }
}
