package com.design.app;

import com.design.app.constants.LogLevel;
import com.design.app.logging.Logger;

public class Application {
    public static void main(String[] args) throws RuntimeException, CloneNotSupportedException {
        Logger logger1 = Logger.getInstance();

        logger1.log(LogLevel.INFO, "" + logger1.hashCode());
    }
}
