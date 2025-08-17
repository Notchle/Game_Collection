package com.notchle.games.mnk.ui.console;

import com.notchle.games.mnk.domain.Board;

public final class MNKBoardPrinter {

    private MNKBoardPrinter() {} //prevents instantiation

    private static final String SPACE = "      ";

    private static String num(int num) {
        return String.format(" %3d  ", num + 1);
    }

    private static String cell(Board board, int row, int col) {
        return String.format("  %c  ", board.getCell(row, col));
    }

    public static void printBoard(Board board, boolean gravity) {
        final int rows = board.getRows();
        final int cols = board.getColumns();

        System.out.print("\nCOL > ");
        for (int i = 0; i <= cols; i++) System.out.print(i < cols ? num(i) : "\n");

        System.out.println((gravity ? SPACE : "ROW v ") + "╔" + "═════╦".repeat(cols - 1) + "═════╗");

        for (int i = 0; i < rows; i++) {
            System.out.print((gravity ? SPACE : num(i)) + "║");
            for (int j = 0; j <= cols; j++) System.out.print(j < cols ? cell(board, i, j) + "║" : "\n");

            if (i < rows - 1) System.out.println(SPACE + "╠" + "═════╬".repeat(cols - 1) + "═════╣");
        }

        System.out.println(SPACE + "╚" + "═════╩".repeat(cols - 1) + "═════╝");
    }


}
