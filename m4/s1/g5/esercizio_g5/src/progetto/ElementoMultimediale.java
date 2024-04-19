package progetto;

public abstract class ElementoMultimediale {
    //attributo comune a più classi
    protected String titolo;
    protected int durata;


    //creo il costruttore
    public ElementoMultimediale(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    //metodo comune a più classi
    public abstract void play();
}
