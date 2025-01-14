package chapter04.myExample.factoryMethod;

import chapter04.myExample.products.*;

public class FactoryC extends Factory {

    @Override
    public Product createProduct() {
        return this.createProduct(
                ProductC_1::new, ProductC_2::new
        );
    }
}
