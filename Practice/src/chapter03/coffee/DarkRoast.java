package chapter03.coffee;

import chapter03.*;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 5.5d;
    }
}
