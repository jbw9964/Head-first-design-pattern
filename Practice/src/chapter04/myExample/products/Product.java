package chapter04.myExample.products;

public abstract class Product {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
