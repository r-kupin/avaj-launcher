package com.rokupin.airport_sim.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Loggable {

    private static FileLogger instance;
    private final String filePath;
    private final FileWriter writer;

    private FileLogger(String filePath) throws LoggerException {
        this.filePath = filePath;
        try {
            File file = new File(filePath);
            for (int i = 0; file.exists(); i++) {
                file = new File(i + "_" + filePath);
            }
            if (file.createNewFile()) {
                writer = new FileWriter(file, true);
            } else {
                throw new LoggerException("Cannot create or access the log file.");
            }
        } catch (IOException e) {
            throw new LoggerException("Error initializing the file logger.", e);
        }
    }

    public static FileLogger getInstance(String filePath) throws LoggerException {
        if (instance == null) {
            instance = new FileLogger(filePath);
        }
        return instance;
    }

    @Override
    public void log(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Can't write \"" + message + "\" to " + filePath +
                    ". File existence and accessibility check is suggested.");
            System.exit(1);
        }
    }
}
