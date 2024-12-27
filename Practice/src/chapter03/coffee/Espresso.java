package chapter03.coffee;

import chapter03.*;

public class Espresso extends Beverage {

    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 5.00d;
    }
}
