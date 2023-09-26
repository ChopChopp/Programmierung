public class Player {
    private char fieldValue;
    private String name;

    public Player(char fieldValue, String name) {
        this.fieldValue = fieldValue;
        this.name = name;
    }

    public char getFieldValue() {
        return fieldValue;
    }

    public String getName() {
        return name;
    }
}
