package main.java.com.rokupin.airport_sim.model.flyable.aircraft;

public class AircraftFactoryException extends Exception {
    public AircraftFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public AircraftFactoryException(String message) {
        super(message);
    }
}
