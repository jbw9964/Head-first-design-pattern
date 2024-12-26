package chapter02;

public class Main {

    public static void main(String[] args) {

        WeatherData data = new WeatherData();

        WeatherDisplayA observerA = new WeatherDisplayA(data);
        WeatherDisplayB observerB = new WeatherDisplayB(data);

        data.setRandomMeasurements();

        data.notifyObserver(true);
        data.notifyObserver(false);
    }
}
