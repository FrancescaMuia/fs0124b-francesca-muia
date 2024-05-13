package it.epicode.pizzeria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyAppConfig {

    @Bean(name = "toppings_pomodoro")
    public Topping tPomodoro(){ return new Topping( 0.0,20,"Pomodoro");}
    @Bean(name = "toppings_mozzarella")
    public Topping tMozzarella(){ return new Topping( 0.0,60,"Mozzarella");}
    @Bean(name = "toppings_salame")
    public Topping tSalame(){ return new Topping( 1.2,150,"Salame");}
    @Bean(name = "toppings_cipolla")
    public Topping tCipolla(){ return new Topping( 0.5,5,"Cipolla");}
    @Bean(name = "toppings_salsiccia")
    public Topping tSalsiccia(){ return new Topping( 1.5,200,"Salsiccia");}
    @Bean(name = "toppings_funghi")
    public Topping tFunghi(){ return new Topping( 0.8,45,"Funghi");}
    @Bean(name = "toppings_tonno")
    public Topping tTonno(){ return new Topping( 1.3,100,"Tonno");}

    @Bean(name = "pizza_margherita")
    public Pizza pizzaMargheritaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(tPomodoro());
        listaTopping.add(tMozzarella());
        return new Pizza("Pizza Margherita",listaTopping);
    }

    @Bean(name = "pizza_tonno_cipolla")
    public Pizza pizzaTonnoCipollaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(tPomodoro());
        listaTopping.add(tMozzarella());
        listaTopping.add(tTonno());
        listaTopping.add(tCipolla());
        return new Pizza("Pizza Tonno e cipolla",listaTopping);
    }

    @Bean(name = "pizza_diavola")
    public Pizza pizzaDiavolaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(tPomodoro());
        listaTopping.add(tMozzarella());
        listaTopping.add(tSalame());
        return new Pizza("Pizza Diavola",listaTopping);
    }

    @Bean(name = "pizza_boscaiola")
    public Pizza pizzaBoscaiolaBean(){
        List<Topping> listaTopping = new ArrayList<>();
        listaTopping.add(tPomodoro());
        listaTopping.add(tMozzarella());
        listaTopping.add(tFunghi());
        listaTopping.add(tSalsiccia());
        return new Pizza("Pizza Boscaiola",listaTopping);
    }

    @Bean(name = "menu")
    public Menu menuBean(){
        List<Pizza> pizzaList = new ArrayList<>();
        List<Topping> toppingList = new ArrayList<>();

        pizzaList.add(pizzaMargheritaBean());
        pizzaList.add(pizzaTonnoCipollaBean());
        pizzaList.add(pizzaBoscaiolaBean());
        pizzaList.add(pizzaDiavolaBean());

        toppingList.add(tTonno());
        toppingList.add(tMozzarella());
        toppingList.add(tSalame());
        toppingList.add(tCipolla());
        toppingList.add(tFunghi());
        toppingList.add(tSalsiccia());
        toppingList.add(tPomodoro());

        return new Menu(pizzaList,toppingList);
    }
}
