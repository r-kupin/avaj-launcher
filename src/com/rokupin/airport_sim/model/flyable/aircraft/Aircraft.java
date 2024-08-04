package com.rokupin.airport_sim.model.flyable.aircraft;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.flyable.factory.Coordinates;
import com.rokupin.airport_sim.view.LoggerFactory;

public abstract class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        String weather = tower.getState(coordinates);
        consoleLog("received weather report: " + weather);
        switch (weather) {
            case "SUN" -> handleSunnyWeather();
            case "RAIN" -> handleRainyWeather();
            case "FOG" -> handleFoggyWeather();
            case "SNOW" -> handleSnowyWeather();
            default -> handleDefaultWeather();
        }
        if (coordinates.getHeight() > 100) {
            coordinates.setHeight(100);
        } else if (coordinates.getHeight() <= 0) {
            land();
        }
    }

    private void land() {
        coordinates.setHeight(0);
        fileLog(" landing");
        unregisterTower();
    }

    protected void consoleLog(String msg) {
        LoggerFactory.get("console").log(this + " at " + coordinates.toString() + " " + msg);
    }

    protected void fileLog(String msg) {
        LoggerFactory.get("file").log(this + msg);
    }

    protected abstract void handleSunnyWeather();

    protected abstract void handleRainyWeather();

    protected abstract void handleFoggyWeather();

    protected abstract void handleSnowyWeather();

    protected abstract void handleDefaultWeather();
}
