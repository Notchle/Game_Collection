package main.java.com.notchle.games.mnk.ui.i18n;

public final class Texts {
    //PROMPTS
    public static final String PROMPT_GAMETYPE          = "Please select which game you'd like to play:";
    public static final String PROMPT_SIZE_ROWS         = "Please specify how many rows the board should have:";
    public static final String PROMPT_SIZE_COLS         = "Please specify how many columns the board should have:";
    public static final String PROMPT_REQ               = "Please specify how many of their symbols each player " +
                                                            "is required to place in a row for a win:";
    public static final String PROMPT_ROW               = "Please choose a row: ";
    public static final String PROMPT_COL               = "Please choose a column: ";

    //[Y/N] OPTIONS
    public static final String PROMPT_OPTIONS           = "[%s/%s]\n";
    public static final String PROMPT_PLAY_BOT          = "Would you like to play against a bot?";
    public static final String PROMPT_PLAY_GRAVITY      = "Would you like to play with gravity enabled?";
    public static final String PROMPT_PLAY_AGAIN        = "Would you like to play again?";

    //ERROR MESSAGES
    public static final String ERROR_INPUT_CHOICE       = "Error: Please choose between '%s' and '%s'!\n";
    public static final String ERROR_INPUT_TYPE         = "Error: Input has to be a %s!\n";
    public static final String ERROR_OUT_OF_RANGE       = "Error: Please enter a number between %d and %d!\n";
    public static final String ERROR_CELL_TAKEN         = "Error: The chosen cell has already been claimed!";
    public static final String ERROR_COL_FULL           = "Error: The chosen column is already full!";

    //GAME STATES
    public static final String GAME_STATE_NEXT          = "Player %c is next!\n";
    public static final String GAME_STATE_WIN           = "Player %c wins!\n";
    public static final String GAME_STATE_TIE           = "It's a tie!\n";

    //GAME MESSAGES
    public static final String GAME_START               = "Player %c begins!\n";
    public static final String GAME_RESTARTING          = "Starting a new game!";
    public static final String GAME_EXIT                = "Returning to Menu!";
    public static final String GAME_GOODBYE             = "Terminating program...";

    //GAME NAMES
    public static final String GAMEMODE_TICTACTOE       = "TicTacToe";
    public static final String GAMEMODE_GOMOKU          = "Gomoku";
    public static final String GAMEMODE_CONNECT_FOUR    = "Connect Four";
    public static final String GAMEMODE_CUSTOM          = "Custom Game";
    public static final String GAMEMODE_EXIT            = "Exit\n";

    //GAME DESCRIPTIONS
    public static final String DESCRIPTION_MNK          = "%-13s (%d x %d board, %d in a row, %s gravity)";
    public static final String DESCRIPTION_MNK_CUSTOM   = "%-13s (Allows you to create your own custom MNK-Game)";

    private Texts() {} //prevents instantiation
}
