package chapter04.factoryMethod;

public abstract class Pizza {

    public void prepare() {
        System.out.printf("Preparing %s ...", this.getClass().getSimpleName());
    }

    public void bake() {
        System.out.printf("Baking %s ...", this.getClass().getSimpleName());
    }

    public void cut() {
        System.out.printf("Cutting %s ...", this.getClass().getSimpleName());
    }

    public void box() {
        System.out.printf("Boxing %s ...", this.getClass().getSimpleName());
    }
}
