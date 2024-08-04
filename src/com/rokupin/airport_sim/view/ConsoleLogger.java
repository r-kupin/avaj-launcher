package com.rokupin.airport_sim.view;

public class ConsoleLogger implements Loggable {
    
    private static ConsoleLogger instance;
    private final boolean isErrorStream;

    private ConsoleLogger(String output) throws LoggerException {
        if ("out".equalsIgnoreCase(output)) {
            isErrorStream = false;
        } else if ("err".equalsIgnoreCase(output)) {
            isErrorStream = true;
        } else {
            throw new LoggerException("Invalid console output specified. Use 'out' or 'err'.");
        }
    }

    public static ConsoleLogger getInstance(String output) throws LoggerException {
        if (instance == null) {
            instance = new ConsoleLogger(output);
        }
        return instance;
    }

    @Override
    public void log(String message) {
        if (isErrorStream) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }
    }
}
