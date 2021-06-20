package main.java;

import main.java.player.Player;
import main.java.player.SixFacedDice;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Game game =new Game(10,1,  SixFacedDice.getSixFacedDice());
        game.addPlayers(new Player("A"));
        game.addPlayers(new Player("B"));
        game.addPlayers(new Player("C"));
        game.launch();

    }
}
