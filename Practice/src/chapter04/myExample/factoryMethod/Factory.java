package chapter04.myExample.factoryMethod;

import chapter04.myExample.products.*;
import java.util.*;
import java.util.function.*;

public abstract class Factory {

    protected Product createProduct(
            Supplier<Product> type1, Supplier<Product> type2
    ) {
        return new Random().nextBoolean() ?
                type1.get() : type2.get();
    }

    public abstract Product createProduct();
}
