package com.rokupin.airport_sim.model.flyable;

import com.rokupin.airport_sim.model.weather.tower.Tower;

// Observer
public abstract class Flyable {
    protected Tower tower;

    // enforce toString reimplementation for consistent output
    public abstract String toString();

    public abstract void updateConditions();

    public void registerTower(Tower tower) {
        this.tower = tower;
        this.tower.register(this);
    }

    public void unregisterTower() {
        this.tower.unregister(this);
    }
}
