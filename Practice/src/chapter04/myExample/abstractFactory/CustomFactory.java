package chapter04.myExample.abstractFactory;

import chapter04.myExample.products.*;
import java.util.*;
import java.util.function.*;

/**
 * <pre><code>
 *
 * print("hello world!)
 *
 * </code></pre>
 */
public class CustomFactory extends AbstractFactory {

    @Override
    public List<Product> createProductGroup() {
        return List.of(
                this.genProductWithRandom(ProductA_1::new, ProductA_2::new),
                this.genProductWithRandom(ProductB_1::new, ProductB_2::new),
                this.genProductWithRandom(ProductC_1::new, ProductC_2::new)
        );
    }

    private Product genProductWithRandom(
            Supplier<Product> type1, Supplier<Product> type2
    ) {
        return new Random().nextBoolean() ?
                type1.get() : type2.get();
    }
}
