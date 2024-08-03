package com.rokupin.airport_sim.model.weather.tower;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;
import com.rokupin.airport_sim.model.weather.provider.WeatherProvider;

public class WeatherTower extends Tower {
    WeatherProvider weatherProvider;

    public WeatherTower() {
        weatherProvider = WeatherProvider.getInstance();
    }

    @Override
    public void register(Flyable flyable) {
        super.register(flyable);
        fileLog(flyable + " registered to weather tower.");
    }

    @Override
    public void unregister(Flyable flyable) {
        super.unregister(flyable);
        fileLog(flyable + " unregistered from weather tower.");
    }

    public String getWeather(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        weatherProvider.generateNewWeather();
        super.conditionChanged();
    }

}
