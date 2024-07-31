package main.java.com.rokupin.airport_sim.model.flyable.aircraft;

import main.java.com.rokupin.airport_sim.model.flyable.Flyable;
import main.java.com.rokupin.airport_sim.model.flyable.aircraft.aircrafts.Baloon;
import main.java.com.rokupin.airport_sim.model.flyable.aircraft.aircrafts.Helicopter;
import main.java.com.rokupin.airport_sim.model.flyable.aircraft.aircrafts.JetPlane;

public class AircraftFactory {
    private static AircraftFactory instance;
    private static int id;

    private AircraftFactory() {}

    public Flyable newAircraft(String type, String name, Coordinates coordinates) throws AircraftFactoryException {
        return switch (type) {
            case "Baloon" -> new Baloon(AircraftFactory.id++, name, coordinates);
            case "Helicopter" -> new Helicopter(AircraftFactory.id++, name, coordinates);
            case "JetPlane" -> new JetPlane(AircraftFactory.id++, name, coordinates);
            default -> throw new AircraftFactoryException("Unsupported aircraft type");
        };
    }

    public static AircraftFactory getInstance() {
        if (AircraftFactory.instance == null) {
            AircraftFactory.instance = new AircraftFactory();
            AircraftFactory.id = 0;
        }
        return AircraftFactory.instance;
    }
}
