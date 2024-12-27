package chapter03;

import chapter03.coffee.*;
import chapter03.condiment.*;

public class Main {

    public static void main(String[] args) {

        Beverage[] basicCoffees = new Beverage[]{
                new DarkRoast(), new Espresso(), new HouseBlend()
        };

        for (Beverage beverage : basicCoffees) {

            Beverage[] finalCompositions = new CondimentDecorator[]{
                    new Mocha(beverage), new Soy(beverage), new Whip(beverage)
            };

            for (Beverage composition : finalCompositions) {
                String description = composition.getDescription();
                double cost = composition.cost();

                System.out.printf("%20s \t: $%.2f\n", description, cost);
            }

            System.out.println();
        }
    }
}
