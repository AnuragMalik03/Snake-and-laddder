package main.java.board;

public class Cell {
    // Instead of snake and ladder wew can have BoardEntity as super class of snake and ladder, as a cell can have either snake or ladder
    BoardEntity entity;

    public boolean hasSnake(){
        return entity != null;
    }

}
