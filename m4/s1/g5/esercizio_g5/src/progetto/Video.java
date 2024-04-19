package progetto;

public class Video extends ElementoMultimediale {

    //aggiungo nuovi attributi di video
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        //richiamo costruttore della classe padre
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        for(int i = 0; i< durata; i++){
            String seqPuntiEsclamativi = "!".repeat(volume);
            String seqAsterischi = "*".repeat(luminosita);
            System.out.println(titolo + " " + seqPuntiEsclamativi + seqAsterischi);
        }
    }

    public void aumentaLum(){
        luminosita++;
    }

    public void diminuisciLum(){
        if(luminosita>0){
            luminosita--;
        }
    }

    public void alzaVolume(){
        //alzo il volume
        volume++;
    }

    public void abbassaVolume(){
        //se volume maggiore di 0 lo diminuisce di 1
        if(volume>0){
            volume--;
        }
    }
}

