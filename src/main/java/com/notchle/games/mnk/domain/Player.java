package main.java.com.notchle.games.mnk.domain;

public enum Player {
    X('X'),
    O('O');

    private final char icon;

    Player(char icon) {
        this.icon = icon;
    }

    public char getIcon() {
        return icon;
    }

    public Player switchPlayer() {
        return this == X ? O : X;
    }
}
