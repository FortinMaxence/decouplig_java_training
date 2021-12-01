package fr.lernejo.logger;

public class LoggerFactory{
    public static Logger getLogger(String name){
        return new CompositeLogger(
            new ContextualLogger(name, new FilteredLogger(new FileLogger("log.txt"),
            message -> !message.contains("player"))), new ContextualLogger(name, new ConsoleLogger()));
    }
}
