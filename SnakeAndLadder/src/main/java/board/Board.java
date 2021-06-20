package main.java.board;

import java.util.HashMap;
import java.util.Random;

public class Board {
    HashMap<Integer , BoardEntity> cells;
    int cellCount;

    public Board(int dimension) {
        this.cellCount = dimension*dimension;
        cells = new HashMap<>();
        Random random = new Random();
        for (int i =0; i < dimension ; i++){
            int start = random.nextInt(cellCount);
            int end = random.nextInt(start);
            if(!hasSnakeOrLadder(start)) {
                addEntity(start, new Snake(start, end));
            }
            end = random.nextInt(cellCount);
            start = random.nextInt(end);
            if(!hasSnakeOrLadder(start)) {
                addEntity(start, new Ladder(start, end));
            }
        }
    }

    public void print() {
        for (int i =cellCount-1; i>=0 ; i-- ){
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(" ");
            if (hasSnakeOrLadder(i)){
                sb.append(cells.get(i).toString());
            }
            System.out.printf("%-15s", sb);

            if (i%10 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public void addEntity(int index, BoardEntity e) {
        cells.put(index , e);
    }

    public BoardEntity getEntity(int index) {
        return cells.get(index);
    }

    public boolean hasSnakeOrLadder(int cellIndex) {
        return cells.containsKey(cellIndex);
    }
}
