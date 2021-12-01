package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long number = player.askNextGuess();
        if (numberToGuess == number)
            return true;

        player.respond(numberToGuess > number);

        return false;
    }

    public void loopUntilPlayerSucceed(long max_iterations) {
        //TODO implement me
        int iteration = 0;
        long start = System.currentTimeMillis();

        while (!nextRound() && iteration < max_iterations)
        {
            nextRound();
            iteration++;
        }

        long end = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:SSS");
        String date = simpleDateFormat.format(new Date(end-start));
        logger.log("Temps: " + date);

        if(iteration < max_iterations)
            logger.log("Le nombre " + numberToGuess + " a été trouvé avant le nombre maximum d'itérations!");
        else
            logger.log("Le nombre " + numberToGuess + " n'a pas été trouvé avant le nombre maximum d'itérations!");
    }
}
