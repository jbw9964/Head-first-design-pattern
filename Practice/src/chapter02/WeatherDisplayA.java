package chapter02;

public class WeatherDisplayA implements Observer, DisplayElement {

    private WeatherData weatherDataSubject;

    public WeatherDisplayA(WeatherData weatherData) {
        weatherDataSubject = weatherData;
        weatherDataSubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Displaying A!");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("\nDisplay A need All data.");
        System.out.printf("""
                        Temperature \t: [%.3f]
                        Humidity \t\t\t: [%.3f]
                        Pressure \t\t\t: [%.3f]
                        """,
                temp, humidity, pressure);
        display();
        System.out.println();
    }

    @Override
    public void update() {
        float temperature = weatherDataSubject.getTemperature();
        float humidity = weatherDataSubject.getHumidity();
        float pressure = weatherDataSubject.getPressure();

        this.update(temperature, humidity, pressure);
    }
}
