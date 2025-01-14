package chapter04.factoryMethod.newyork;

import chapter04.factoryMethod.*;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new NYCheesePizza();
            case "veggie" -> new NYVeggiePizza();
            default -> null;
        };
    }
}
