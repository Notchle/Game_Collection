package main.java.com.notchle.games.mnk.ui.console;

import main.java.com.notchle.games.mnk.domain.GameType;

import java.util.Scanner;

import static main.java.com.notchle.games.mnk.ui.i18n.Texts.*;

public final class Menu {

    private Menu() {
    } //prevents instantiation

    public static GameType getMNKGameType(Scanner sc) {
        final GameType[] games = GameType.values();
        final StringBuilder menuText = new StringBuilder();

        menuText.append("\nAvailable MNK-Games:\n\n");
        for (int i = 0; i < games.length; i++) {
            menuText.append(i + 1).append(") ").append(games[i].describe()).append("\n");
        }
        int choice = Input.getNumber(menuText + PROMPT_GAMETYPE, 1, games.length, sc);
        return games[choice - 1];
    }
}
