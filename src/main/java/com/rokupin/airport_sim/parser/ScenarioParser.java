package main.java.com.rokupin.airport_sim.parser;

import main.java.com.rokupin.airport_sim.scenario.Scenario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScenarioParser {

    public Scenario parse(String inputFilePath) throws ScenarioParserException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = reader.readLine();
            if (line == null || line.isEmpty() || !line.matches("\\d+")) {
                throw new ScenarioParserException("Scenario file should start with a number");
            }

            int iterations = Integer.parseInt(line);
            Scenario scenario = new Scenario(iterations);

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length != 5) {
                    throw new ScenarioParserException("Scenario line should contain 5 values");
                }

                String type = getType(tokens[0]);
                String name = getName(tokens[1]);
                int longitude = getLongitude(tokens[2]);
                int latitude = getLatitude(tokens[3]);
                int height = getHeight(tokens[4]);

            }
            return scenario;
        } catch (FileNotFoundException e) {
            throw new ScenarioParserException("File not found: " + inputFilePath);
        } catch (IOException e) {
            throw new ScenarioParserException("Read operation failed on file: " + inputFilePath);
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
            throw new ScenarioParserException("Latitude shoud be a positive number");
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
