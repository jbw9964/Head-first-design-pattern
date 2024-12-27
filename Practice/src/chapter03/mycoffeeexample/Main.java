package chapter03.mycoffeeexample;

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new Coffee1();
        coffee.addExtra(new Extra1());

        System.out.println(coffee.getTotalPrice());
    }
}
