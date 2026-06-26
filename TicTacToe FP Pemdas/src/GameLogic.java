import java.util.Random;

public class GameLogic {

    private char[] board;
    private Random random;

    private static final int[][] WIN_PATTERNS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };

    public GameLogic() {
        board = new char[9];
        random = new Random();
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public boolean makeMove(int index, char symbol) {
        if (index < 0 || index >= 9 || board[index] != ' ') {
            return false;
        }
        board[index] = symbol;
        return true;
    }

    public boolean checkWinner(char symbol) {
        for (int[] pattern : WIN_PATTERNS) {
            if (board[pattern[0]] == symbol
                    && board[pattern[1]] == symbol
                    && board[pattern[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (char cell : board) {
            if (cell == ' ') return false;
        }
        return true;
    }

    public int computerMove() {
        int index;
        do {
            index = random.nextInt(9);
        } while (board[index] != ' ');
        return index;
    }

    public char[] getBoard() {
        return board;
    }
}