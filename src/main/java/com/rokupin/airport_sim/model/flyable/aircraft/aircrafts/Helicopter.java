package main.java.com.rokupin.airport_sim.model.flyable.aircraft.aircrafts;

import main.java.com.rokupin.airport_sim.model.flyable.aircraft.Aircraft;
import main.java.com.rokupin.airport_sim.model.flyable.aircraft.Coordinates;

public class Helicopter extends Aircraft {

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    @Override
    public void updateConditions() {

    }
}
