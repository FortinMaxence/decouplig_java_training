package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if(args.length < 1)
        {
            System.out.println("-interactive : Lance la partie en tant que joueur");
            System.out.println("-auto <max_iterations> : Lance une partie jouée automatiquement, <max_iterations> doit être un nombre");
            return;
        }

        if(args[0].equals("-interactive"))
        {
            HumanPlayer humanplayer = new HumanPlayer();
            Simulation simulation = new Simulation(humanplayer);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

        }
        else if(args[0].equals("-auto"))
        {
            try {
                long nbr = Long.parseLong(args[1]);
                ComputerPlayer computerplayer = new ComputerPlayer();
                Simulation simulation = new Simulation(computerplayer);
                simulation.initialize(nbr);
                simulation.loopUntilPlayerSucceed(1000);
            } catch (NumberFormatException e) {
                System.out.println("Le second argument doit être numérique !");
            }
        }
        else
        {
            System.out.println("-interactive : Lance la partie en tant que joueur");
            System.out.println("-auto <nbr> : Lance une partie jouée automatiquement, <nbr> doit être un nombre et correspond au nombre à trouver");
        }


    }
}
