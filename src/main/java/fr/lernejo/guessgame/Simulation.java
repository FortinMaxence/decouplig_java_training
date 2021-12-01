package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
        initialize(numberToGuess);
        loopUntilPlayerSucceed();

    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        SecureRandom random = new SecureRandom();
        this.numberToGuess = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long number = player.askNextGuess();
        if (numberToGuess == number)
            return true;

        if(numberToGuess > number)
            logger.log("Le nombre a trouver est plus grand !");
        else
            logger.log("Le nombre a trouver est plus petit !");

        return false;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        while (!nextRound())
        {
            nextRound();
        }
        logger.log("Le nombre a été trouvé !");
    }
}
