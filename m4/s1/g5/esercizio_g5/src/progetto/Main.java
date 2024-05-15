package progetto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //creo istanza di registrazioneAudio e inserisco un esempio di audio
        RegistrazioneAudio reg = new RegistrazioneAudio("titolo1", 10, 2);
        RegistrazioneAudio reg2 = new RegistrazioneAudio("titolo2", 3, 3);
        reg.play(); //richiamo il metodo play per far partire l'audio
        reg2.play();
        reg.abbassaVolume(); //diminuisco il volume
        reg.play(); //mostra la traccia con il volume diminuito di 1
        reg.alzaVolume(); //alzo il volume
        reg.play(); //il volume incrementa di uno

        Video vid = new Video("video1", 5, 3, 2);
        vid.play();
        vid.alzaVolume();
        vid.play();
        vid.aumentaLum();
        vid.play();
        vid.abbassaVolume();
        vid.play();
        vid.diminuisciLum();
        vid.play();

        Immagine img = new Immagine("immagine1", 3);
        img.show();
        img.aumentaLum();
        img.show();
        img.diminuisciLum();
        img.show();
        //prove richiamo metodi
    }

    }
