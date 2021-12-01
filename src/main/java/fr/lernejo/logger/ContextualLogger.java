package fr.lernejo.logger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private final String callerClass;
    private final Logger delegateLogger;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public ContextualLogger(String callerClass, Logger logger) {
        this.callerClass = callerClass;
        this.delegateLogger = logger;
    }

    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);
    }
}
