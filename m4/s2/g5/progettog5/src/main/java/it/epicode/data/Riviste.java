package main.java.it.epicode.data;

public class Riviste extends Documento {
    private Periodicita periodicita;

    public Riviste(Long isbn, String titolo, int anno, int numeroPagine, Periodicita periodicita) {
        this.periodicita = periodicita;

        super.setIsbn(isbn);
        super.setTitolo(titolo);
        super.setAnno(anno);
        super.setNumeroPagine(numeroPagine);
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }
}
