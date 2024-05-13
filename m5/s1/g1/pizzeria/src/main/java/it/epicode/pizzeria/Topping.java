package it.epicode.pizzeria;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Topping extends Prodotto{
    private String nome;

    public Topping(Double prezzo, int calorie, String nome) {
        super(prezzo, calorie);
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "nome='" + nome + '\'' +
                "calorie='" + calorie + '\'' +
                "prezzo='" + prezzo + '\'' +
                '}';
    }
}
