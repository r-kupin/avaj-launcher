package com.rokupin.airport_sim.model.flyable.aircraft.aircraft_impl;

import com.rokupin.airport_sim.model.flyable.aircraft.Aircraft;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    protected void handleSunnyWeather() {
        fileLog(": This is hot.");
        coordinates.increaseLongitude(10).increaseHeight(2);
    }

    @Override
    protected void handleRainyWeather() {
        fileLog(": It's nice to have that swinging umbrella on top.");
        coordinates.increaseLongitude(5);
    }

    @Override
    protected void handleFoggyWeather() {
        fileLog(": Can't see my rotor, lol. Is it still there?");
        coordinates.increaseLongitude(1);
    }

    @Override
    protected void handleSnowyWeather() {
        fileLog(": My rotor is going to freeze!");
        coordinates.decreaseHeight(12);
    }

    @Override
    protected void handleDefaultWeather() {
        fileLog(": Something weird is happening");
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}
