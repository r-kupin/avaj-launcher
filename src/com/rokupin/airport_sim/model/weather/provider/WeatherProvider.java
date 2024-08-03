package com.rokupin.airport_sim.model.weather.provider;

import com.rokupin.airport_sim.model.flyable.factory.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private final String[] weather = {"SUN", "SNOW", "FOG", "RAIN"};
    Random random;
    private static WeatherProvider instance;
    private int seed;

    private WeatherProvider() {
        this.random = new Random();
        this.seed = 0;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if (seed == 0)
            generateNewWeather();
        int index = (int) (Math.abs((long) coordinates.hashCode() * seed) % 4);
        return weather[index];
    }

    public static WeatherProvider getInstance() {
        if (WeatherProvider.instance == null) {
            WeatherProvider.instance = new WeatherProvider();
        }
        return WeatherProvider.instance;
    }

    public void generateNewWeather() {
        seed = random.nextInt();
    }
}
