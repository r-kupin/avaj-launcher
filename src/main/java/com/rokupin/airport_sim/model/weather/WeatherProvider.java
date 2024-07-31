package main.java.com.rokupin.airport_sim.model.weather;

import main.java.com.rokupin.airport_sim.model.flyable.aircraft.Coordinates;

public class WeatherProvider {
    private String[] weather;
    private static WeatherProvider instance;

    private WeatherProvider() {}

    public String getCurrentWeather(Coordinates coordinates) {
        return "HOT";
    }

    public static WeatherProvider getInstance() {
        if (WeatherProvider.instance == null) {
            WeatherProvider.instance = new WeatherProvider();
        }
        return WeatherProvider.instance;
    }
}
