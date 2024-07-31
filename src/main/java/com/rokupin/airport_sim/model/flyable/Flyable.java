package main.java.com.rokupin.airport_sim.model.flyable;

import main.java.com.rokupin.airport_sim.model.weather.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
