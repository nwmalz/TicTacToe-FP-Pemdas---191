import java.util.ArrayList;

public class GameLogic {

    private char[] board;

    private static final int[][] WIN_PATTERNS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}
    };

    public GameLogic() {
        board = new char[9];
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

    // Algoritma Minimax: komputer selalu pilih langkah terbaik
    public int computerMove() {
        // TODO: Select an empty cell for computer move.
        // A simple random move is acceptable.
        ArrayList<Integer> emptyCells = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                emptyCells.add(i);
            }
        }
        if (emptyCells.isEmpty()) 
        return -1;
        
        int randomIndex = (int) (Math.random() * emptyCells.size());
        return emptyCells.get(randomIndex);
    }

    private int minimax(boolean isComputerTurn, int depth) {
        if (checkWinner('O')) return  10 - depth;
        if (checkWinner('X')) return -10 + depth;
        if (isDraw())         return 0;

        if (isComputerTurn) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = 'O';
                    best = Math.max(best, minimax(false, depth + 1));
                    board[i] = ' ';
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = 'X';
                    best = Math.min(best, minimax(true, depth + 1));
                    board[i] = ' ';
                }
            }
            return best;
        }
    }

    public char[] getBoard() {
        return board;
    }
}
