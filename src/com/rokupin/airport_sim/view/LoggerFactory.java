package com.rokupin.airport_sim.view;

import java.util.HashMap;
import java.util.Map;

public final class LoggerFactory {
    private static final Map<String, Loggable> instances = new HashMap<>();

    public static void init(String logger, String arg) throws LoggerException {
        if (!instances.containsKey(logger)) {
            instances.put(logger, switch (logger) {
                case "file" -> FileLogger.getInstance(arg);
                case "console" -> ConsoleLogger.getInstance(arg);
                default -> throw new LoggerException("Logger of type " + logger + " is not implemented");
            });
        } else {
            throw new LoggerException("Logger is already initialized.");
        }
    }

    public static Loggable get(String type) {
        Loggable loggable = instances.get(type);
        if (loggable == null) {
            System.err.println(type + " logger is not initialized.");
            System.exit(1);
        }
        return loggable;
    }
}
