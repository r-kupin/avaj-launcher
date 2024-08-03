package com.rokupin.airport_sim.model.flyable.aircraft.aircraft_impl;

import com.rokupin.airport_sim.model.flyable.aircraft.Aircraft;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;


public class Balloon extends Aircraft {

    public Balloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    protected void handleSunnyWeather() {
        fileLog(": Let's enjoy the good weather and take some pics.");
        coordinates.increaseLongitude(2).increaseHeight(4);
    }

    @Override
    protected void handleRainyWeather() {
        fileLog(": Damn you rain! You messed up my balloon.");
        coordinates.decreaseHeight(5);
    }

    @Override
    protected void handleFoggyWeather() {
        fileLog(": Can't see thing.. wait, where am I?");
        coordinates.decreaseHeight(3);
    }

    @Override
    protected void handleSnowyWeather() {
        fileLog(": It's snowing. We're gonna crash.");
        coordinates.decreaseHeight(15);
    }

    @Override
    protected void handleDefaultWeather() {
        fileLog(": Something weird is happening");
    }

    @Override
    public String toString() {
        return "Balloon#" + name + "(" + id + ")";
    }
}
