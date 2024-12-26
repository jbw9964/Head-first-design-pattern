package chapter02;

public interface Observer {

    /**
     * Push 방식의 옵저버 update
     */
    void update(float temp, float humidity, float pressure);

    /**
     * Pull 방식의 옵저버 update
     */
    void update();
}
