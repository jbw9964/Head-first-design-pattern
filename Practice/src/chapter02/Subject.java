package chapter02;

public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    /**
     * 옵저버한테 notify 하기
     *
     * @param push {@code true} 면 push 방식, {@code false} 면 pull 방식
     */
    void notifyObserver(boolean push);
}
