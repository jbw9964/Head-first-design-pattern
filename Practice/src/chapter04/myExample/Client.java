package chapter04.myExample;

import chapter04.myExample.abstractFactory.*;
import chapter04.myExample.factoryMethod.*;

public class Client {

    public static void main(String[] args) {

        System.out.println("Factory Method Pattern : ");
        factoryMethodPattern();

        System.out.println("Abstract Factory Pattern : ");
        abstractFactoryPattern();
    }

    public static void factoryMethodPattern() {

        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();
        FactoryC factoryC = new FactoryC();

        System.out.println("Each factory creates only one product.");
        System.out.println(factoryA.createProduct());
        System.out.println(factoryB.createProduct());
        System.out.println(factoryC.createProduct());

        System.out.println("""
                Products' factories are not related to each other.
                So in order to group "Product Set", we need an Abstract Factory Pattern.
                """);
    }

    public static void abstractFactoryPattern() {
        FactoryType1 factoryType1 = new FactoryType1();
        FactoryType2 factoryType2 = new FactoryType2();
        CustomFactory customFactory = new CustomFactory();

        System.out.println("""
                Abstract Factory Pattern can group products without heritage.
                It only needs to group products in each concrete factory.
                """);

        showProductGroup(factoryType1);
        showProductGroup(factoryType2);
        showProductGroup(customFactory);
    }

    private static void showProductGroup(AbstractFactory factory) {
        System.out.printf("%s : \n", factory.getClass().getSimpleName());

        var group = factory.createProductGroup();
        group.forEach(System.out::println);
        System.out.println();
    }
}
