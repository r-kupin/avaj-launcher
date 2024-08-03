package com.rokupin.airport_sim.model.weather.tower;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.view.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// Observable
public class Tower {
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    protected void fileLog(String msg) {
        LoggerFactory.get("file").log("Tower says: " + msg);
    }

    protected void conditionChanged() {
        observers.forEach(Flyable::updateConditions);
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }
}
