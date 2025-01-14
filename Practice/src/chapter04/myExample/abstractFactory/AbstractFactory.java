package chapter04.myExample.abstractFactory;

import chapter04.myExample.products.*;
import java.util.*;

public abstract class AbstractFactory {

    public abstract List<Product> createProductGroup();
}
