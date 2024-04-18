package esercizi;

public class Dipendente {
    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }


    private int matricola;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

    public Dipendente(int matricola, double stipendio, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.dipartimento=dipartimento;
    }

    public void stampaDatiDipendente() {
        System.out.println("Matricola: "+ this.matricola);
        System.out.println("stipendio: "+ this.stipendio);
        System.out.println("Dipartimento: "+ this.dipartimento);
    }
}
