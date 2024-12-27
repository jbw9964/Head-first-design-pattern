package chapter03.coffee;

import chapter03.*;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.description = "House Blend";
    }

    @Override
    public double cost() {
        return 3.5d;
    }
}
