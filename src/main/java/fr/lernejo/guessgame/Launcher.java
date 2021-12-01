package fr.lernejo.guessgame;

public class Launcher {
    public static void main(String[] args) {
        HumanPlayer humanplayer = new HumanPlayer();
        new Simulation(humanplayer);
    }
}
