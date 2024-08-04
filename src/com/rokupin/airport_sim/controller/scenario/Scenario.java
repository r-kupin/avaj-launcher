package com.rokupin.airport_sim.controller.scenario;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.weather.tower.Tower;
import com.rokupin.airport_sim.model.weather.tower.WeatherTower;
import com.rokupin.airport_sim.view.LoggerFactory;

public class Scenario {
    private final int runs;
    private final Tower tower;

    public Scenario(int iterations) {
        this.runs = iterations;
        tower = new WeatherTower();
    }

    public void addAircraft(Flyable flyable) {
        flyable.registerTower(tower);
    }

    public void execute() {
        for (int i = 0; i < runs; i++) {
            String msg = "== RUN " + (i + 1) + " ===========================";
            LoggerFactory.get("console").log(msg);
            LoggerFactory.get("file").log(msg);
            tower.changeState();
        }
    }
}
