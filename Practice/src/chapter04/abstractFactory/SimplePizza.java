package chapter04.abstractFactory;

public class SimplePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing SimplePizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking SimplePizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting SimplePizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing SimplePizza");
    }
}
