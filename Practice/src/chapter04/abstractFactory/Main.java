package chapter04.abstractFactory;

public class Main {

    public static void main(String[] args) {

        PizzaStore store = new PizzaStore(new SimplePizzaFactory());

        System.out.println(store.orderPizza(PizzaType.CHEESE));
        System.out.println();
        System.out.println(store.orderPizza(PizzaType.NORMAL));
    }
}
