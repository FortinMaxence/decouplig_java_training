package fr.lernejo.logger;

import java.time.LocalDateTime;

public class CompositeLogger implements Logger{
    private final Logger first_logger;
    private final Logger second_logger;
    public CompositeLogger(Logger first_logger, Logger second_logger) {
        this.first_logger = first_logger;
        this.second_logger = second_logger;
    }

    public void log(String message) {
        first_logger.log(message);
        second_logger.log(message);
    }
}
