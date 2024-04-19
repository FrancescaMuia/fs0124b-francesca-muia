package progetto;

public class RegistrazioneAudio extends ElementoMultimediale {

    /*public int getVolume() {
        return volume;
    }*/

    //aggiungo l'attributo che è solo dell'audio
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata);
        //inizializzo l'attributo
        this.volume = volume;
    }
    @Override
    public void play() {
        //qui facciamo play e incrementa arrivando fino al massimo della durata
        for (int i = 0; i < durata; i++) {
            //punti ! aumentano in base al volume
            String seqPuntiEsclamativi = "!".repeat(volume);
            //stampa il titolo + i punti ! del volume
            System.out.println(titolo + " " + seqPuntiEsclamativi);
        }
    }

    //creo un metodo per abbassare il volume
    public void abbassaVolume(){
        //se volume maggiore di 0 lo diminuisce di 1
        if(volume>0){
            volume--;
        }
    }

    //creo un metodo per alzare il volume
    public void alzaVolume(){
        //alzo il volume
        volume++;
        }
    }

