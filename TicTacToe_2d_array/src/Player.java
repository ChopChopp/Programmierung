public class Player {
    private String name;
    private char fieldValue;

    public Player(String name, char fieldValue) {
        this.name = name;
        this.fieldValue = fieldValue;
    }

    public String getName() {
        return name;
    }

    public char getFieldValue() {
        return fieldValue;
    }
}
