package chapter04.myExample.factoryMethod;

import chapter04.myExample.products.*;

public class FactoryB extends Factory {

    @Override
    public Product createProduct() {
        return this.createProduct(
                ProductB_1::new, ProductB_2::new
        );
    }
}
