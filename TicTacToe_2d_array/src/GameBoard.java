public class GameBoard {

    private char field1 = '1';
    private char field2 = '2';
    private char field3 = '3';
    private char field4 = '4';
    private char field5 = '5';
    private char field6 = '6';
    private char field7 = '7';
    private char field8 = '8';
    private char field9 = '9';
    private UserInterface userInterface;
    private boolean gameOver = false;

    /**
     * Constructor for the GameBoard class
     *
     * @param userInterface The language object
     */
    public GameBoard(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    /**
     * Prints the current state of the game board
     */
    public void printBoard() {
        System.out.println(" " + field1 + " | " + field2 + " | " + field3 + " ");
        System.out.println("---+---+---");
        System.out.println(" " + field4 + " | " + field5 + " | " + field6 + " ");
        System.out.println("---+---+---");
        System.out.println(" " + field7 + " | " + field8 + " | " + field9 + " ");
    }

    /**
     * Sets the field for the current player
     *
     * @param player The current player
     */
    public void setField(Player player) {
        boolean properInput = false;

        while (!properInput) {
            switch (userInterface.getPlayerInput()) {
                case 1:
                    if (field1 == 'x' || field1 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field1 = player.getFieldValue();
                    properInput = true;
                    break;
                case 2:
                    if (field2 == 'x' || field2 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field2 = player.getFieldValue();
                    properInput = true;
                    break;
                case 3:
                    if (field3 == 'x' || field3 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field3 = player.getFieldValue();
                    properInput = true;
                    break;
                case 4:
                    if (field4 == 'x' || field4 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field4 = player.getFieldValue();
                    properInput = true;
                    break;
                case 5:
                    if (field5 == 'x' || field5 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field5 = player.getFieldValue();
                    properInput = true;
                    break;
                case 6:
                    if (field6 == 'x' || field6 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field6 = player.getFieldValue();
                    properInput = true;
                    break;
                case 7:
                    if (field7 == 'x' || field7 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field7 = player.getFieldValue();
                    properInput = true;
                    break;
                case 8:
                    if (field8 == 'x' || field8 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field8 = player.getFieldValue();
                    properInput = true;
                    break;
                case 9:
                    if (field9 == 'x' || field9 == 'o') {
                        System.out.println(userInterface.printFieldOccupied());
                        break;
                    }
                    field9 = player.getFieldValue();
                    properInput = true;
                    break;
                default:
                    System.out.println(userInterface.printNotAllowedCharacter());
                    break;
            }
        }
    }

    /**
     * Checks if the game is over
     *
     * @return boolean
     */
    public boolean validateWinner() {
        // Validate horizontally
        if (field1 == field2 && field2 == field3)
            return true;
        if (field4 == field5 && field5 == field6)
            return true;
        if (field7 == field8 && field8 == field9)
            return true;

        // Validate vertically
        if (field1 == field4 && field4 == field7)
            return true;
        if (field2 == field5 && field5 == field8)
            return true;
        if (field3 == field6 && field6 == field9)
            return true;

        // Validate diagonally
        if (field1 == field5 && field5 == field9)
            return true;
        if (field3 == field5 && field5 == field7)
            return true;

        return false;
    }

    public boolean validateDraw() {
        // Validate draw
        if (field1 != '1' && field2 != '2' && field3 != '3' && field4 != '4' && field5 != '5' && field6 != '6' && field7 != '7' && field8 != '8' && field9 != '9')
            return true;
        return false;
    }

    public void handleGameOver(Player player) {
        if (validateWinner())
            System.out.println(userInterface.printGameOverMessage(player.getName()));
        else if (validateDraw())
            System.out.println(userInterface.printDrawMessage());

        printBoard();
        gameOver = true;
    }

    public boolean getGameOver() {
        return gameOver;
    }
}
