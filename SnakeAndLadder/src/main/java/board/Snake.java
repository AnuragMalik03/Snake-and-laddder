package main.java.board;

public class Snake extends BoardEntity{

    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "ohh! you got bit by Snake";
    }
}
