package chapter01.proper;

public interface FlyingBehavior {

    void doFly();
}

class FlyNormal implements FlyingBehavior {

    @Override
    public void doFly() {
        System.out.println("평범하게 날기");
    }
}

class FlyNoWay implements FlyingBehavior {

    @Override
    public void doFly() {
        System.out.println("난 날수 없어..");
    }
}