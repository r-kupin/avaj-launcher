package main.java.com.rokupin.airport_sim.model.weather.tower;

import main.java.com.rokupin.airport_sim.model.flyable.aircraft.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return "SUN";
    }

    public void changeWeather() {

    }

}
