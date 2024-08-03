package com.rokupin.airport_sim.model.flyable.factory;

import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.flyable.aircraft.aircraft_impl.Balloon;
import com.rokupin.airport_sim.model.flyable.aircraft.aircraft_impl.Helicopter;
import com.rokupin.airport_sim.model.flyable.aircraft.aircraft_impl.JetPlane;

public class AircraftFactory {
    private static AircraftFactory instance;
    private static int id;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (AircraftFactory.instance == null) {
            AircraftFactory.instance = new AircraftFactory();
            AircraftFactory.id = 0;
        }
        return AircraftFactory.instance;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) throws AircraftFactoryException {
        return switch (type) {
            case "Balloon" -> new Balloon(AircraftFactory.id++, name, coordinates);
            case "Helicopter" -> new Helicopter(AircraftFactory.id++, name, coordinates);
            case "JetPlane" -> new JetPlane(AircraftFactory.id++, name, coordinates);
            default -> throw new AircraftFactoryException("Unsupported aircraft type: " + type);
        };
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AircraftFactoryException {
        return newAircraft(type, name, new Coordinates(longitude, latitude, height));
    }
}
