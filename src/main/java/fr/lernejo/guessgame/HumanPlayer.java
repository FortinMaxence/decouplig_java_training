package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");

    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    public void respond(boolean lowerOrGreater){
    }

}
