package com.notchle.games.mnk.logic.bot;

import com.notchle.games.mnk.domain.Board;
import com.notchle.games.mnk.domain.Player;

import java.util.concurrent.ThreadLocalRandom;

import static com.notchle.games.mnk.logic.GameLogic.*;

public final class RandomBot {

    private RandomBot(){} //prevents instantiation

    public static void makeRandomMove(Board board, boolean gravity) {
        int row, col;

        if (isBoardFull(board)) return;
        while (true) {

            if (gravity) {
                col = ThreadLocalRandom.current().nextInt(0, board.getColumns());
                if (isValidCol(board, col)) {
                    row = getDropRow(board, col);
                    break;
                }
            } else {
                row = ThreadLocalRandom.current().nextInt(0, board.getRows());
                col = ThreadLocalRandom.current().nextInt(0, board.getColumns());
                if (isValidCell(board, row, col)) break;
            }
        }
        board.setCell(row, col, Player.O);
    }

}
