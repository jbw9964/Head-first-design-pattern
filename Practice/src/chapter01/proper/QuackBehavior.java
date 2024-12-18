package chapter01.proper;

public interface QuackBehavior {

    void doQuack();
}

class QuackNormal implements QuackBehavior {

    @Override
    public void doQuack() {
        System.out.println("평범한 꽥꽥");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void doQuack() {
        System.out.println("난 꽥꽥거릴 수 없어..");
    }
}