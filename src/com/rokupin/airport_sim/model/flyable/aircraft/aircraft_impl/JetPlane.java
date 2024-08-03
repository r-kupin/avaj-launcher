package com.rokupin.airport_sim.model.flyable.aircraft.aircraft_impl;

import com.rokupin.airport_sim.model.flyable.aircraft.Aircraft;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;

public class JetPlane extends Aircraft {

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    protected void handleSunnyWeather() {
        fileLog(": Put that glasses on, folks.");
        coordinates.increaseLatitude(10).increaseHeight(2);
    }

    @Override
    protected void handleRainyWeather() {
        fileLog(": It's raining. Better watch out for lightnings.");
        coordinates.increaseLatitude(5);
    }

    @Override
    protected void handleFoggyWeather() {
        fileLog(": This fog is so foggy.");
        coordinates.increaseLatitude(1);
    }

    @Override
    protected void handleSnowyWeather() {
        fileLog(": OMG! Winter is coming!");
        coordinates.decreaseHeight(7);
    }

    @Override
    protected void handleDefaultWeather() {
        fileLog(": Something weird is happening");
    }

    @Override
    public String toString() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}
