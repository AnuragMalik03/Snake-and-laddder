package main.java.board;

public class Ladder extends BoardEntity{

    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getEncounterMessage() {
        return "Yeah! you got Ladder";
    }
}
