package main.java.player;

public class Player {
    int position;
    String userName;

    public Player(String userName) {
        this.position = 0;
        this.userName = userName;
    }

    public int getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
