package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private boolean lowerOrGreater;
    private long nbrGuess = Long.MAX_VALUE / 2;
    private long borne_haute = 100;
    private long borne_basse = 0;

    public long askNextGuess() {
        if (this.lowerOrGreater)
        {
            this.borne_basse = this.nbrGuess;
        }
        else
        {
            this.borne_haute = this.nbrGuess;
        }

        this.nbrGuess = (this.borne_basse + this.borne_haute)/2;

        return this.nbrGuess;
    }

    public void respond(boolean lowerOrGreater){
        this.lowerOrGreater = lowerOrGreater;
    }

}
