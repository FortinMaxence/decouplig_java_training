package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");

    public long askNextGuess() {
        System.out.println("Entrez un nombre: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    public void respond(boolean lowerOrGreater){
        if (lowerOrGreater)
            logger.log("Le nombre a trouver est plus grand !");
        else
            logger.log("Le nombre a trouver est plus petit !");
    }

}
