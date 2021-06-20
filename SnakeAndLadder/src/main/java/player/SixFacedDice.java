package main.java.player;

public class SixFacedDice implements IDice{
    private static SixFacedDice dice;
    private SixFacedDice(){

    }

    public static SixFacedDice getSixFacedDice(){
        if (dice == null) {
            dice = new SixFacedDice();
        }
        return dice;
    }


    public int roll(int n){
        int low =1;
        int high =n*6;
        return (int) Math.floor(Math.random() * (high-low+1) + low);
    }
}
