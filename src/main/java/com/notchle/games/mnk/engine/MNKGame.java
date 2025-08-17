package main.java.com.notchle.games.mnk.engine;

import main.java.com.notchle.games.mnk.domain.Board;
import main.java.com.notchle.games.mnk.domain.Player;
import main.java.com.notchle.games.mnk.domain.Symbols;

import static main.java.com.notchle.games.mnk.ui.i18n.Texts.*;

import java.util.Scanner;

import static main.java.com.notchle.games.mnk.ui.console.MNKBoardPrinter.printBoard;
import static main.java.com.notchle.games.mnk.logic.GameLogic.*;
import static main.java.com.notchle.games.mnk.ui.console.Input.*;
import static main.java.com.notchle.games.mnk.logic.bot.RandomBot.makeRandomMove;

public class MNKGame {
    private final Scanner sc;
    private Board board;
    private int reqToWin;
    private static final int MIN_REQ_TO_WIN = 3;
    private static final int MIN_BOARD_SIZE = 3;
    private static final int MAX_BOARD_SIZE = 100;
    private boolean vsBot, gravity;
    private Player currentMNKPlayer = Player.X;

    public MNKGame(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        while (true) {
            playSingleGame();
            if (getChoice(PROMPT_PLAY_AGAIN, "Y", "N", sc)) {
                System.out.println(GAME_RESTARTING);
                this.board = new Board(board.getRows(), board.getColumns());
                currentMNKPlayer = currentMNKPlayer.switchPlayer();
            } else {
                System.out.println(GAME_EXIT);
                break;
            }
        }
    }

    private void playSingleGame() {
        printBoard(board, gravity);
        System.out.printf(GAME_START, currentMNKPlayer.getIcon());
        while (true) {
            if (vsBot && currentMNKPlayer == Player.O) {
                makeRandomMove(board, gravity);
            } else {
                setHumanMove();
            }
            printBoard(board, gravity);
            final char winner = getWinner(board, reqToWin);
            final boolean full = isBoardFull(board);
            showGameState(winner, full, currentMNKPlayer);
            if (winner != Symbols.EMPTY || full) break;
            currentMNKPlayer = currentMNKPlayer.switchPlayer();
        }
    }

    private void setHumanMove() {
        while (true) {
            int row, col;
            if (gravity) {
                col = getNumber(PROMPT_COL, 1, board.getColumns(), sc) - 1;
                if (isValidCol(board, col)) {
                    row = getDropRow(board, col);
                    board.setCell(row, col, currentMNKPlayer);
                    break;
                }
                System.out.println(ERROR_COL_FULL);
            } else {
                row = getNumber(PROMPT_ROW, 1, board.getRows(), sc) - 1;
                col = getNumber(PROMPT_COL, 1, board.getColumns(), sc) - 1;
                if (isValidCell(board, row, col)) {
                    board.setCell(row, col, currentMNKPlayer);
                    break;
                }
                System.out.println(ERROR_CELL_TAKEN);
            }
        }
    }

    public void setup() {
        setBoardSize();
        setReqToWin(board);
        setGravity();
        setVsBot();
    }

    public void setup(int rows, int cols, int reqToWin, boolean gravity, boolean vsBot) {
        setBoardSize(rows, cols);
        setReqToWin(reqToWin);
        setGravity(gravity);
        setVsBot(vsBot);
    }

    public void setup(int rows, int cols, int reqToWin, boolean gravity) {
        setBoardSize(rows, cols);
        setReqToWin(reqToWin);
        setGravity(gravity);
        setVsBot();
    }

    public void setReqToWin(Board board) {
        final int maxReqToWin = Math.max(board.getRows(), board.getColumns());
        this.reqToWin = getNumber(PROMPT_REQ, MIN_REQ_TO_WIN, maxReqToWin, sc);
    }

    public void setReqToWin(int reqToWin) {
        this.reqToWin = reqToWin;
    }

    public void setBoardSize() {
        final int rows = getNumber(PROMPT_SIZE_ROWS, MIN_BOARD_SIZE, MAX_BOARD_SIZE, sc);
        final int cols = getNumber(PROMPT_SIZE_COLS, MIN_BOARD_SIZE, MAX_BOARD_SIZE, sc);
        this.board = new Board(rows, cols);
    }

    public void setBoardSize(int rows, int cols) {
        this.board = new Board(rows, cols);
    }

    public void setVsBot() {
        this.vsBot = getChoice(PROMPT_PLAY_BOT, "Y", "N", sc);
    }

    public void setVsBot(boolean isBotActive) {
        this.vsBot = isBotActive;
    }

    public void setGravity() {
        this.gravity = getChoice(PROMPT_PLAY_GRAVITY, "Y", "N", sc);
    }

    public void setGravity(boolean isGravityActive) {
        this.gravity = isGravityActive;
    }

}
