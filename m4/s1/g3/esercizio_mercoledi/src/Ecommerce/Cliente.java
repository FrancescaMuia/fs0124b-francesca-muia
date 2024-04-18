package Ecommerce;

import java.util.Date;

public class Cliente {
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    private int codice;
    private String nome;
    private String cognome;
    private String email;
    private Date data;

    public Cliente(int codice, String nome, String cognome, String email, Date data){
        this.codice=codice;
        this.nome=nome;
        this.cognome=cognome;
        this.data=new Date();
    }
}
