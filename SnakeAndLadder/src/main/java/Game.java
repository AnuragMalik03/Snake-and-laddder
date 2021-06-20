package main.java;

import main.java.board.Board;
import main.java.board.Cell;
import main.java.player.IDice;
import main.java.player.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    //Alternative , we can hve
    Board board;
    Queue<Player> players;
    Queue<Player> winners;
    IDice dice;
    int diceCount;
    int size;

    public Game(int dimension, int diceCount , IDice d){
        this.size =dimension*dimension;
        this.diceCount = diceCount;
        this.dice = d;
        board = new Board(dimension);
        players = new LinkedList<>();
        winners = new LinkedList<>();
    }

    public void launch(){
        board.print();
        while (players.size() >1 ){
            Player currPlayer = players.poll();
            System.out.println(currPlayer.getUserName() + "'s turn");
            System.out.println("Press r to roll dice");
            char c;
            do{
                Scanner sc = new Scanner(System.in);
                 c = sc.next().charAt(0);
                if (c != 'r'){
                    System.out.println("Please press r to roll dice");
                }else{
                    makeMove(currPlayer);
                    if (currPlayer.getPosition() == size){
                        System.out.println(currPlayer.getUserName() + " won!!!");
                        winners.add(currPlayer);
                    }else {
                        players.add(currPlayer);
                    }
                }
                printPosition();
            }while (c != 'r');

        }
    }

    private void printPosition() {
        for (Player player : players){
            System.out.println(player.getUserName() +" : " + player.getPosition());
        }
    }

    public void makeMove(Player player){
        int move = 0;
        do{
             move = dice.roll(diceCount);
            System.out.println(" You got " + move);
            int currPosition = player.getPosition();
            int finalPos = currPosition + move;
            if (finalPos <= size){
                if (board.hasSnakeOrLadder(finalPos)) {
                    System.out.println(board.getEntity(finalPos).getEncounterMessage());
                    finalPos = board.getEntity(finalPos).getEnd();
                }
                System.out.println("Taking you to " + finalPos);
            }else {
                System.out.println("Try again");
                finalPos = currPosition;
            }
            player.setPosition(finalPos);
        }while (move == 6);

    }

    public void addPlayers(Player player){
        players.add(player);
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Queue<Player> getWinners() {
        return winners;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public int getSize() {
        return size;
    }
}
