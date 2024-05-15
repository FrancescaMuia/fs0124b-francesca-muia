package esercizi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dipendente d1 = new Dipendente(1, 1000, Dipartimento.PRODUZIONE);
        Dipendente d2 = new Dipendente(2, 2000, Dipartimento.AMMINISTRAZIONE);
        Dipendente d3 = new Dipendente(3, 3000, Dipartimento.VENDITE);

        Dipendente[] dipendenti = { d1, d2, d3 };

        for (int i = 0; i < dipendenti.length; i++) {
            Dipendente dipendenteCorrente = dipendenti[i];
            System.out.println(dipendenteCorrente.getMatricola());
            System.out.println(dipendenteCorrente.getStipendio());
            System.out.println(dipendenteCorrente.getDipartimento());
        }
    }

    }
