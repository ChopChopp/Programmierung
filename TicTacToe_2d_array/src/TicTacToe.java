import java.util.Scanner;

public class TicTacToe {

    char[][] board = new char[3][3];

    public static void main(String[] args) {
        TicTacToe gameOfTicTacToe = new TicTacToe();
        gameOfTicTacToe.run();
    }

    public void run() {
        int iteration = 1;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = (char)('0' + iteration);
                iteration++;
            }
        }

        // 1 == player1, 2 == player2
        int turn = 1;
        char player1 = 'X';
        char player2 = 'O';
        boolean gameOver = false;

        printBoard(board);
        while(!gameOver) {
            System.out.println("\nPlayer " + turn + ", please select your field:\n");
            if (turn == 1)
                setField(player1);
            else
                setField(player2);

            printBoard(board);
        }

    }

    public void setField(char fieldValue) {

        Scanner scanner = new Scanner(System.in);
        boolean properInput = false;

        while (!properInput) {
            if (scanner.hasNextInt()) {

                switch(scanner.nextInt()) {
                    case 1:
                        board[0][0] = fieldValue;
                        properInput = true;
                        break;
                    case 2:
                        board[0][1] = fieldValue;
                        properInput = true;
                        break;
                    case 3:
                        board[0][2] = fieldValue;
                        properInput = true;
                        break;
                    case 4:
                        board[1][0] = fieldValue;
                        properInput = true;
                        break;
                    case 5:
                        board[1][1] = fieldValue;
                        properInput = true;
                        break;
                    case 6:
                        board[1][2] = fieldValue;
                        properInput = true;
                        break;
                    case 7:
                        board[2][0] = fieldValue;
                        properInput = true;
                        break;
                    case 8:
                        board[2][1] = fieldValue;
                        properInput = true;
                        break;
                    case 9:
                        board[2][2] = fieldValue;
                        properInput = true;
                        break;
                    default:
                        System.out.println("False input! Select a range from 1-9.");
                }
            } else {
                System.out.println("Enter a proper int!");
                scanner.next();
            }
        }
    }

    public void printBoard(char[][] board) {
        System.out.println("Welcome to TicTacToe");

        for (char[] row : board) {
            System.out.println("---------------");
            for (char col : row) {
                System.out.print(" |" + col + "| ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }
}