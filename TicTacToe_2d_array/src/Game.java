import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player1 = new Player('x', "Player 1");
        Player player2 = new Player('o', "Player 2");

        GameBoard gameBoard = new GameBoard(player1, player2);
        gameBoard.startGame();
    }
}
