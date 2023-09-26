import java.util.Scanner;

public class GameBoard {

    private char[][] board = new char[3][3];
    private Player player1;
    private Player player2;
    private int turn = 1;

    public GameBoard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        initBoard();
    }

    public void initBoard() {
        int iteration = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                board[i][j] = (char) ('0' + iteration);
                iteration++;
            }
        }
    }

    boolean gameOver = false;

    public void startGame() {
        printBoard(board);

        while (!gameOver) {
            System.out.println("\nPlayer " + turn + ", please select your field:\n");
            if (turn == 1) {
                setField(player1);
                if (isGameOver()) {
                    handleGameOver(player1);
                    break;
                }
                turn = 2;
            } else {
                setField(player2);
                if (isGameOver()) {
                    handleGameOver(player2);
                    break;
                }
                turn = 1;
            }

            printBoard(board);
        }
    }

    public void printBoard(char[][] board) {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }

    public void setField(Player player) {

        Scanner scanner = new Scanner(System.in);
        boolean properInput = false;

        while (!properInput) {
            if (scanner.hasNextInt()) {

                switch (scanner.nextInt()) {
                    case 1:
                        if (board[0][0] == 'x' || board[0][0] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[0][0] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 2:
                        if (board[0][1] == 'x' || board[0][1] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[0][1] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 3:
                        if (board[0][2] == 'x' || board[0][2] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[0][2] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 4:
                        if (board[1][0] == 'x' || board[1][0] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[1][0] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 5:
                        if (board[1][1] == 'x' || board[1][1] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[1][1] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 6:
                        if (board[1][2] == 'x' || board[1][2] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[1][2] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 7:
                        if (board[2][0] == 'x' || board[2][0] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[2][0] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 8:
                        if (board[2][1] == 'x' || board[2][1] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[2][1] = player.getFieldValue();
                        properInput = true;
                        break;
                    case 9:
                        if (board[2][2] == 'x' || board[2][2] == 'o') {
                            System.out.println("This field is already taken, please select another one");
                            break;
                        }
                        board[2][2] = player.getFieldValue();
                        properInput = true;
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 9");
                        break;
                }
            } else {
                System.out.println("Please enter a number between 1 and 9");
                scanner.next();
            }
        }
    }

    public boolean isGameOver() {
        // Validate horizontally
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2])
            return true;
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2])
            return true;
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2])
            return true;

        // Validate vertically
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0])
            return true;
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1])
            return true;
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2])
            return true;

        // Validate diagonally
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        // Validate draw
        if (board[0][0] != '1' && board[0][1] != '2' && board[0][2] != '3' && board[1][0] != '4' && board[1][1] != '5' && board[1][2] != '6' && board[2][0] != '7' && board[2][1] != '8' && board[2][2] != '9')
            return true;

        return false;
    }

    public void handleGameOver(Player player)
    {
        if (isGameOver()) {
            System.out.println("Final board:");
            printBoard(board);
            System.out.println("\n" + player.getName() + " has won the game!");
            gameOver = true;
            printBoard(board);
        }
    }
}
