package progetto;

public abstract class ElementoMultimediale {
    //attributo comune a più classi
    //getter e setter solo per private?
    protected String titolo;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    protected int durata;


    //creo il costruttore
    public ElementoMultimediale(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    //metodo comune a più classi
    public abstract void play();
}
