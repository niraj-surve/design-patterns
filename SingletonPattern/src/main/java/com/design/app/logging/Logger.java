package com.design.app.logging;

import com.design.app.constants.LogLevel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements Serializable, Cloneable {
    private static final String RESET = "\u001B[0m";
    private static final String INFO_COLOR = "\u001B[34m"; // Blue
    private static final String DEBUG_COLOR = "\u001B[32m"; // Green
    private static final String ERROR_COLOR = "\u001B[31m"; // Red

    private static Logger instance;

    private Logger() {
        if (instance != null) {
            throw new RuntimeException("You are trying to break singleton pattern.");
        }
    }

    public static Logger getInstance() {
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
        }

        return instance;
    }

    public void log(LogLevel level, String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = now.format(formatter);

        String logEntry = switch (level) {
            case INFO -> INFO_COLOR + "[" + timestamp + "] INFO: " + message + RESET;
            case DEBUG -> DEBUG_COLOR + "[" + timestamp + "] DEBUG: " + message + RESET;
            case ERROR -> ERROR_COLOR + "[" + timestamp + "] ERROR: " + message + RESET;
        };

        System.out.println(logEntry);
    }

    public Object readResolve() {
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return instance;
    }
}
