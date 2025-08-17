package main.java.com.notchle.games.mnk.app;

import main.java.com.notchle.games.mnk.engine.MNKGame;
import main.java.com.notchle.games.mnk.domain.GameType;
import main.java.com.notchle.games.mnk.ui.console.Menu;

import static main.java.com.notchle.games.mnk.ui.i18n.Texts.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final MNKGame game = new MNKGame(sc);
        do {
            GameType type = Menu.getMNKGameType(sc);
            if (type == GameType.EXIT_GAME) break;
            if (type == GameType.CUSTOM) game.setup();
            else game.setup(type.rows, type.cols, type.reqToWin, type.gravity);
            game.run();
        } while(true);
        System.out.println(GAME_GOODBYE);
        sc.close();
    }
}