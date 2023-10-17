import java.util.Scanner;

public class UserInterface {
    private String[] languages;
    private String currentLanguage;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
        languages = new String[]{"English", "German"};
        currentLanguage = languages[0];
    }

    public void setCurrentLanguage() {
        if (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("English") || input.equals("english")) {
                currentLanguage = languages[0];
            } else if (input.equals("German") || input.equals("german")) {
                currentLanguage = languages[1];
            } else {
                System.out.println(printNotAllowedCharacter());
            }
        }
    }

    public int getPlayerInput() {
        int input = 0;
        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input < 1 || input > 9) {
                System.out.println(printNotAllowedCharacter());
            }
        } else {
            System.out.println(printNotAllowedCharacter());
        }
        return input;
    }

    public String printAvailableLanguages() {
        String availableLanguages = "";
        for (String language : languages) {
            availableLanguages += "•" + language + "\n";
        }

        return "Please choose a language from: \n" + availableLanguages;
    }

    public String printOpeningMessage() {
        if (currentLanguage.equals("English")) {
            return "Welcome to Tic Tac Toe!";
        } else if (currentLanguage.equals("German")) {
            return "Willkommen bei Tic Tac Toe!";
        }
        return "";
    }

    public String printChooseFieldMessage(String name) {
        if (currentLanguage.equals("English")) {
            return "Player " + name + ", please select your field:\n";
        } else if (currentLanguage.equals("German")) {
            return "Spieler " + name + ", bitte wähle dein Feld:\n";
        }
        return "";
    }

    public String printGameOverMessage(String name) {
        if (currentLanguage.equals("English")) {
            return name + " has won the game!\nFinal board:\n";
        } else if (currentLanguage.equals("German")) {
            return name + " hat das Spiel gewonnen!\nEndgültiges Spielfeld:\n";
        }
        return "";
    }

    public String printDrawMessage() {
        if (currentLanguage.equals("English")) {
            return "It's a draw!\nFinal board:\n";
        } else if (currentLanguage.equals("German")) {
            return "Das Spiel endet unentschieden!\nEndgültiges Spielfeld:\n";
        }
        return "";
    }

    public String printFieldOccupied() {
        if (currentLanguage.equals("English")) {
            return "This field is already taken, please select another one";
        } else if (currentLanguage.equals("German")) {
            return "Dieses Feld ist bereits belegt, bitte wähle ein anderes";
        }
        return "";
    }

    public String printNotAllowedCharacter() {
        if (currentLanguage.equals("English")) {
            return "Please enter a number between 1 and 9";
        } else if (currentLanguage.equals("German")) {
            return "Bitte gib eine Zahl zwischen 1 und 9 ein";
        }
        return "";
    }
}
