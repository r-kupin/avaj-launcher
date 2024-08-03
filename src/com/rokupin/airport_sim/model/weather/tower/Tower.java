package com.rokupin.airport_sim.model.weather.tower;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.view.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Observable
public class Tower {
    private final List<Flyable> observers;
    private final List<Flyable> unregistration_requests;

    public Tower() {
        this.observers = new ArrayList<>();
        this.unregistration_requests = new LinkedList<>();
    }

    protected void fileLog(String msg) {
        LoggerFactory.get("file").log("Tower says: " + msg);
    }

    protected void conditionChanged() {
        observers.forEach(Flyable::updateConditions);
        unregistration_requests.forEach(observers::remove);
        unregistration_requests.clear();
    }

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        unregistration_requests.add(flyable);
    }
}
