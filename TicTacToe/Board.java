package TicTacToe;

public class Board {

    private static final int SIZE = 3;
    private char[][] board;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, Player player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false; // Invalid move
        }
        if (board[row][col] == ' ') {
            board[row][col] = player.getSymbol();
            return true;
        }
        return false;
    }

    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println("---------");
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return false; // Invalid cell
        }
        return board[row][col] == ' ';
    }

    public char getCell(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Invalid cell coordinates");
        }
        return board[row][col];
    }

    public boolean isFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
