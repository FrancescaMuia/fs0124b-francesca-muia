package main.java.it.epicode.data;

//aggiungo parametri solo della classe libro
public class Libri extends Documento{
    private String autore;
    private String genere;

    public Libri(Long isbn, String titolo, int anno, int numeroPagine, String autore, String genere) {
        this.autore = autore;
        this.genere = genere;

        //aggiungo supercostruttore dei parametri generici
        super.setIsbn(isbn);
        super.setTitolo(titolo);
        super.setAnno(anno);
        super.setNumeroPagine(numeroPagine);
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
