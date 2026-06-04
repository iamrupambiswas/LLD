package TicTacToe;

import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;
    private boolean gameOver;

    public Game(String player1Name, String player2Name) {
        this.board = new Board();
        this.player1 = new Player(player1Name, 'X');
        this.player2 = new Player(player2Name, 'O');
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
        this.gameOver = false;

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println(player1.getName() + " is 'X'");
        System.out.println(player2.getName() + " is 'O'");
    }

    private void switchPlayer() {
        currentPlayer =
                (currentPlayer == player1)
                        ? player2
                        : player1;
    }

    private boolean checkWinner() {

        char symbol = currentPlayer.getSymbol();

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board.getCell(row, 0) == symbol &&
                board.getCell(row, 1) == symbol &&
                board.getCell(row, 2) == symbol) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board.getCell(0, col) == symbol &&
                board.getCell(1, col) == symbol &&
                board.getCell(2, col) == symbol) {
                return true;
            }
        }

        // Main diagonal
        if (board.getCell(0, 0) == symbol &&
            board.getCell(1, 1) == symbol &&
            board.getCell(2, 2) == symbol) {
            return true;
        }

        // Anti diagonal
        if (board.getCell(0, 2) == symbol &&
            board.getCell(1, 1) == symbol &&
            board.getCell(2, 0) == symbol) {
            return true;
        }

        return false;
    }

    public void start() {

        while (!gameOver) {

            board.displayBoard();

            System.out.println();
            System.out.println(
                    currentPlayer.getName()
                    + "'s turn ("
                    + currentPlayer.getSymbol()
                    + ")"
            );

            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            boolean moveSuccessful =
                    board.makeMove(
                            row,
                            col,
                            currentPlayer
                    );

            if (!moveSuccessful) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (checkWinner()) {

                board.displayBoard();

                System.out.println();
                System.out.println(
                        currentPlayer.getName()
                        + " wins!"
                );

                gameOver = true;
                break;
            }

            if (board.isFull()) {

                board.displayBoard();

                System.out.println();
                System.out.println("Game Draw!");

                gameOver = true;
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }
}