package com.rokupin.airport_sim.model.flyable;

import com.rokupin.airport_sim.model.weather.tower.WeatherTower;

// Observer
public abstract class Flyable {
    protected WeatherTower weatherTower;

    // enforce toString reimplementation for consistent output
    public abstract String toString();

    public abstract void updateConditions();

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    public void unregisterTower() {
        this.weatherTower.unregister(this);
    }
}
