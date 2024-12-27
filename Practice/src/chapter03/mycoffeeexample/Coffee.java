package chapter03.mycoffeeexample;

import java.util.*;

public abstract class Coffee {

    private final double price;
    private final List<CoffeeExtra> extras = new ArrayList<>();

    public Coffee(double price) {
        this.price = price;
    }

    public void addExtra(CoffeeExtra extra) {
        extras.add(extra);
    }

    public double getTotalPrice() {
        return price + extras.stream().mapToDouble(CoffeeExtra::cost).sum();
    }
}
