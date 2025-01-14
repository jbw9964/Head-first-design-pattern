package chapter04.myExample.abstractFactory;

import chapter04.myExample.products.*;
import java.util.*;

public class FactoryType2 extends AbstractFactory {

    @Override
    public List<Product> createProductGroup() {
        return List.of(
                new ProductA_2(), new ProductB_2(), new ProductC_2()
        );
    }
}
