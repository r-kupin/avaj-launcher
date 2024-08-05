package com.rokupin.airport_sim.model.weather.tower;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;
import com.rokupin.airport_sim.model.weather.provider.WeatherProvider;
import com.rokupin.airport_sim.view.LoggerFactory;

public class WeatherTower extends Tower {
    private final WeatherProvider weatherProvider;

    public WeatherTower() {
        weatherProvider = WeatherProvider.getInstance();
    }

    @Override
    protected void changeStateImpl() {
        weatherProvider.generateNewWeather();
    }

    @Override
    protected void registerImpl(Flyable flyable) {
        fileLog(flyable + " registered to weather tower.");
    }

    @Override
    protected void unregisterImpl(Flyable flyable) {
        fileLog(flyable + " unregistered from weather tower.");
    }

    @Override
    public String getState(Coordinates coordinates) {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    private void fileLog(String msg) {
        LoggerFactory.get("file").log("Tower says: " + msg);
    }
}
