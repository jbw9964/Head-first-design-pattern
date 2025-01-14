package chapter04.factoryMethod.chicago;

import chapter04.factoryMethod.*;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new ChicagoCheesePizza();
            case "veggie" -> new ChicagoVeggiePizza();
            default -> null;
        };
    }
}
