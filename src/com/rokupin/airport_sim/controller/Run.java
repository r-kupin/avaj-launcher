package com.rokupin.airport_sim.controller;

import com.rokupin.airport_sim.controller.parser.ScenarioParser;
import com.rokupin.airport_sim.controller.parser.ScenarioParserException;
import com.rokupin.airport_sim.controller.scenario.Scenario;
import com.rokupin.airport_sim.view.LoggerException;
import com.rokupin.airport_sim.view.LoggerFactory;

public class Run {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar aviation.jar <input-file-path>");
            System.exit(1);
        } else {
            String inputFilePath = args[0];
            ScenarioParser parser = new ScenarioParser();
            try {
                LoggerFactory.init("console", "out");
                LoggerFactory.init("file", "simulation.txt");
                Scenario scenario = parser.parse(inputFilePath);
                scenario.execute();
            } catch (ScenarioParserException e) {
                System.err.println("Error parsing scenario file: " + e);
                System.exit(1);
            } catch (LoggerException e) {
                System.err.println("Logger error: " + e);
                System.exit(1);
            }
        }
    }
}
