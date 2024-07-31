package main.java.com.rokupin.airport_sim.scenario;

import main.java.com.rokupin.airport_sim.model.flyable.aircraft.Aircraft;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private int runs;
    private List<Aircraft> aircrafts;

    public Scenario(int iterations) {
        this.runs = iterations;
        this.aircrafts = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircrafts.add(aircraft);
    }

    public void execute() {

    }
}
