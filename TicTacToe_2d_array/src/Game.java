public class Game {
    private Player player1;
    private Player player2;
    private Player turn;
    private UserInterface userInterface;
    private GameBoard gameBoard;

    public Game() {
        player1 = new Player("Player 1", 'x');
        player2 = new Player("Player 2", 'o');
        turn = player1;
        userInterface = new UserInterface();
        gameBoard = new GameBoard(userInterface);
    }

    /**
     * Main method
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    /**
     * Runs the game
     */
    public void run() {
        System.out.println(userInterface.printOpeningMessage());
        System.out.println(userInterface.printAvailableLanguages());
        userInterface.setCurrentLanguage();

        gameBoard.printBoard();

        while (!gameBoard.getGameOver()) {
            System.out.println(userInterface.printChooseFieldMessage(turn.getName()));
            gameBoard.setField(turn);
            if (gameBoard.validateWinner()) {
                gameBoard.handleGameOver(turn);
                break;
            } else if (gameBoard.validateDraw()) {
                gameBoard.handleGameOver(turn);
                break;
            }

            // If the game is not over, switch the turn to the other player
            turn = (turn == player1) ? player2 : player1;

            // Print the board after each turn
            gameBoard.printBoard();
        }
    }
}
