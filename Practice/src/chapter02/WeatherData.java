package chapter02;

import java.util.*;

public class WeatherData implements Subject {

    private final List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
        this.setRandomMeasurements();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(boolean push) {
        observers.forEach(
                push ? o -> o.update(temperature, humidity, pressure) :
                        Observer::update
        );
    }


    public void setRandomMeasurements() {
        Random rand = new Random();

        temperature = rand.nextFloat();
        humidity = rand.nextFloat();
        pressure = rand.nextFloat();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
