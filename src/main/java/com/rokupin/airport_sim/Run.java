package main.java.com.rokupin.airport_sim;

import main.java.com.rokupin.airport_sim.parser.ScenarioParser;
import main.java.com.rokupin.airport_sim.parser.ScenarioParserException;
import main.java.com.rokupin.airport_sim.scenario.Scenario;

public class Run {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar aviation.jar <input-file-path>");
            System.exit(1);
        } else {
            String inputFilePath = args[0];
            ScenarioParser parser = new ScenarioParser();

            try {
                Scenario scenario = parser.parse(inputFilePath);
                scenario.execute();
            } catch (ScenarioParserException e) {
                System.err.println("Error parsing scenario file: " + e);
            }
        }
    }
}
