package com.codecool.stackoverflowtw.logger;

import java.time.LocalDateTime;

public class LoggerImpl implements Logger{
    @Override
    public void logInfo(String message) {
        createMessage("INFO", message);
    }

    @Override
    public void logError(String message) {
        createMessage("ERROR", message);
    }

    private void createMessage(String type, String message){
        String unit = String.format("[%s] %s: %s", LocalDateTime.now(), type, message);
        System.out.println(unit);
    }
}
