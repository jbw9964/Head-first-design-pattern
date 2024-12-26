package chapter02;

public class WeatherDisplayB implements Observer, DisplayElement {

    private WeatherData weatherDataSubject;

    public WeatherDisplayB(WeatherData weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        weatherDataSubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Displaying B!");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("\nDisplay B only needs Temperature & Humidity");
        System.out.printf("""
                        Temperature \t: [%.3f]
                        Humidity \t\t\t: [%.3f]
                        """,
                temp, humidity);
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
