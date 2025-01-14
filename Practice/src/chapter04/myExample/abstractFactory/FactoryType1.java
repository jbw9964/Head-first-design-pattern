package chapter04.myExample.abstractFactory;

import chapter04.myExample.products.*;
import java.util.*;

public class FactoryType1 extends AbstractFactory {

    @Override
    public List<Product> createProductGroup() {
        return List.of(
                new ProductA_1(), new ProductB_1(), new ProductC_1()
        );
    }
}
