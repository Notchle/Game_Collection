package com.notchle.games.mnk.domain;

public enum Player {
    X('X'),
    O('O'),
    EMPTY(' ');

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
