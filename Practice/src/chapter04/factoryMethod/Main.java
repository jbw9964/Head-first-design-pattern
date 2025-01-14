package chapter04.factoryMethod;

import chapter04.factoryMethod.chicago.*;
import chapter04.factoryMethod.newyork.*;

public class Main {

    public static void main(String[] args) {

        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza nyCheesePizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(nyCheesePizza);

        Pizza chicagoCheesePizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println(chicagoCheesePizza);
    }
}
