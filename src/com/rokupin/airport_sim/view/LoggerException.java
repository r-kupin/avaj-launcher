package com.rokupin.airport_sim.view;

public class LoggerException extends Exception {
    public LoggerException(String message) {
        super(message);
    }

    public LoggerException(String message, Throwable cause) {
        super(message, cause);
    }
}
