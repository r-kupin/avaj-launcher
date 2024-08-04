package com.rokupin.airport_sim.model.weather.tower;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;

import java.util.LinkedList;
import java.util.List;

// Observable
public abstract class Tower {
    private final List<Flyable> observers;
    private final List<Flyable> unregistration_requests;

    public Tower() {
        this.observers = new LinkedList<>();
        this.unregistration_requests = new LinkedList<>();
    }

    // =========== State change
    public void changeState() {
        changeStateImpl();
        conditionChanged();
    }

    protected abstract void changeStateImpl();

    protected void conditionChanged() {
        observers.forEach(Flyable::updateConditions);
        unregistration_requests.forEach(observers::remove);
        unregistration_requests.clear();
    }

    // =========== State retrieve
    public abstract String getState(Coordinates coordinates);

    // =========== Subscription
    public void register(Flyable flyable) {
        registerImpl(flyable);
        observers.add(flyable);
    }

    protected abstract void registerImpl(Flyable flyable);

    // =========== UnSubscription
    public void unregister(Flyable flyable) {
        unregisterImpl(flyable);
        unregistration_requests.add(flyable);
    }

    protected abstract void unregisterImpl(Flyable flyable);

}
