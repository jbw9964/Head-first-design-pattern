package chapter04.abstractFactory;

public class SimplePizzaFactory extends PizzaFactory {

    @Override
    public Pizza createPizza(PizzaType type) {
        return switch (type) {
            case CHEESE -> new CheesePizza();
            case VEGGIE -> new VeggiePizza();
            default -> new SimplePizza();
        };
    }
}
