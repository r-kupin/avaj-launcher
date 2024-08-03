package com.rokupin.airport_sim.controller.parser;

import com.rokupin.airport_sim.controller.scenario.Scenario;
import com.rokupin.airport_sim.model.flyable.Flyable;
import com.rokupin.airport_sim.model.flyable.factory.AircraftFactory;
import com.rokupin.airport_sim.model.flyable.factory.AircraftFactoryException;
import com.rokupin.airport_sim.view.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScenarioParser {

    public Scenario parse(String inputFilePath) throws ScenarioParserException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = reader.readLine();
            int iterations = getIterations(line);

            Scenario scenario = new Scenario(iterations);
            AircraftFactory aircraftFactory = AircraftFactory.getInstance();

            while ((line = reader.readLine()) != null)
                scenario.addAircraft(getFlyable(aircraftFactory, line));
            LoggerFactory.get("console").log("Parsing done. File \"" + inputFilePath + "\" is OK.");
            return scenario;
        } catch (FileNotFoundException e) {
            throw new ScenarioParserException("File not found: " + inputFilePath);
        } catch (IOException e) {
            throw new ScenarioParserException("Read operation failed on file: " + inputFilePath);
        }
    }

    private int getIterations(String line) throws ScenarioParserException {
        if (line == null || line.isEmpty() || !line.matches("\\d+"))
            throw new ScenarioParserException("Scenario file should start with a number");
        int iterations = Integer.parseInt(line);
        if (iterations < 1)
            throw new ScenarioParserException("Amount of simulation runs should be positive");
        return iterations;
    }

    private Flyable getFlyable(AircraftFactory aircraftFactory, String line) throws ScenarioParserException {
        String[] tokens = line.split(" ");
        if (tokens.length != 5)
            throw new ScenarioParserException("Scenario line \"" + line + "\" should contain 5 values");
        try {
            return aircraftFactory.newAircraft(getType(tokens[0]), getName(tokens[1]),
                    getLongitude(tokens[2]), getLatitude(tokens[3]), getHeight(tokens[4]));
        } catch (AircraftFactoryException e) {
            throw new ScenarioParserException("Cant create aircraft: " + e.getMessage() + " \"" + line + "\" is incorrect");
        }
    }

    private int getHeight(String token) throws ScenarioParserException {
        try {
            int result = Integer.parseInt(token);
            if (result > 0 && result <= 100)
                return result;
            throw new ScenarioParserException("The height should be in the 1-100 range");
        } catch (NumberFormatException e) {
            throw new ScenarioParserException("This token " + token + " is not a valid number");
        }
    }

    private int getLatitude(String token) throws ScenarioParserException {
        try {
            int result = Integer.parseInt(token);
            if (result > 0)
                return result;
            throw new ScenarioParserException("Latitude should be a positive number");
        } catch (NumberFormatException e) {
            throw new ScenarioParserException("This token " + token + " is not a valid number");
        }
    }

    private int getLongitude(String token) throws ScenarioParserException {
        try {
            int result = Integer.parseInt(token);
            if (result > 0)
                return result;
            throw new ScenarioParserException("Longitude shoud be a positive number");
        } catch (NumberFormatException e) {
            throw new ScenarioParserException("This token " + token + " is not a valid number");
        }
    }

    private String getName(String token) throws ScenarioParserException {
        if (token.isEmpty())
            throw new ScenarioParserException("Aircraft name isn't specified");
        return token;
    }

    private String getType(String token) throws ScenarioParserException {
        if (token.isEmpty())
            throw new ScenarioParserException("Aircraft type isn't specified");
        return token;
    }
}
