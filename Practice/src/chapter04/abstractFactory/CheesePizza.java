package chapter04.abstractFactory;

public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing CheesePizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking CheesePizza");
    }

    @Override
    public void cut() {
        System.out.println("Cut CheesePizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing CheesePizza");
    }
}
