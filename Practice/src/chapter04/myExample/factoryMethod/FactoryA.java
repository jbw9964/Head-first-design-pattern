package chapter04.myExample.factoryMethod;

import chapter04.myExample.products.*;

public class FactoryA extends Factory {

    @Override
    public Product createProduct() {
        return this.createProduct(
                ProductA_1::new, ProductA_2::new
        );
    }
}
