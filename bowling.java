<<<<<<< HEAD
// Author: Manansinh Vansia
// Date:  05-07-2024
// Description: Assignment_3 bowling_Game between 2 players.

import java.util.Scanner;

public class bowling {

    // total number of frames in a bowling game
    private static final int FRAMES = 10;
    // total number of pins in each frame
    private static final int PINS = 10;
    // Maximum rolls in this game which will include bonus rolls in the 10th frame
    private static final int MAX_ROLLS = 21;
    private static final Scanner scanner = new Scanner(System.in);

    // array which will store player names
    private String[] players;
    // array which will store the number of pins knocked down in each roll for both players playing the game
    private int[][] rolls;
    // array which will store the scores for each frame for both players playing the game
    private int[] frameScores;

    // Constructor which will help to initialize player names, rolls, and frameScore arrays
    public bowling(String player1, String player2) {
        players = new String[]{player1, player2};
        rolls = new int[2][MAX_ROLLS];
        frameScores = new int[2];
    }


    // Prompt user for roll input, validate, and return the roll score
    private int getRoll(String playerName) {
        int roll;
        do {
            System.out.print(playerName + ", enter your roll (0-10): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. " + playerName + ", enter your roll (0-10): ");
                scanner.next();
            }
            roll = scanner.nextInt();
            if (roll < 0 || roll > PINS) {
                System.out.println("Error: Please enter a number between 0 and 10.");
            }
            // validating the roll input
        } while (roll < 0 || roll > PINS);
        return roll;
    }

    // calculate
    private int getRoll(int player) {
        int roll;
        do {
            System.out.print(players[player] + ", enter your roll (0-10): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. " + players[player] + ", enter your roll (0-10): ");
                scanner.next();
            }
            roll = scanner.nextInt();
        } while (roll < 0 || roll > PINS);
        return roll;
    }


    // Calculate score for one turn (two rolls)
    private int getTurnScores(int playerIndex, int frameNumber) {
        int score = 0;
        int rollIndex = frameNumber * 2;

        int roll1 = getRoll(players[playerIndex]);
        rolls[playerIndex][rollIndex] = roll1;

        if (roll1 < PINS) { // Not a strike
            int roll2 = getRoll(players[playerIndex]);
            rolls[playerIndex][rollIndex + 1] = roll2;
            score = roll1 + roll2;

            // Check for spare bonus
            if (score == PINS) {
                score += getBonus(playerIndex, rollIndex + 2);
            }
        } else { // Strike
            score = PINS + getBonus(playerIndex, rollIndex + 1);
        }

        return score;
    }

    // Get bonus points for strikes and spares
    private int getBonus(int playerIndex, int bonusRollIndex) {
        if (bonusRollIndex < MAX_ROLLS) {
            return rolls[playerIndex][bonusRollIndex];
        }
        return 0;
    }

    // Play the bowling game
    public void playGame() {
        int currentFrame = 0;
        while (currentFrame < FRAMES) {
            for (int playerIndex = 0; playerIndex < 2; playerIndex++) {
                int turnScore = getTurnScores(playerIndex, currentFrame);
                frameScores[playerIndex] += turnScore;
                printFrameScore(playerIndex, currentFrame);
            }
            currentFrame++;
        }
        displayResults();
    }

    // Print score for the current frame for a player
    private void printFrameScore(int playerIndex, int frameNumber) {
        System.out.println(players[playerIndex] + "'s score for frame " + (frameNumber + 1) + ": " + frameScores[playerIndex]);
    }

    // Calculate final scores and determine the winner
    private void displayResults() {
        System.out.println("\nGame Over!");
        System.out.println("Final Scores:");
        for (int playerIndex = 0; playerIndex < 2; playerIndex++) {
            System.out.println(players[playerIndex] + ": " + frameScores[playerIndex]);
        }
        if (frameScores[0] > frameScores[1]) {
            System.out.println(players[0] + " wins!");
        } else if (frameScores[0] < frameScores[1]) {
            System.out.println(players[1] + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player1, player2;
        do {
            System.out.print("Enter the name of player 1: ");
            player1 = scanner.nextLine();
            System.out.print("Enter the name of player 2: ");
            player2 = scanner.nextLine();

            bowling game = new bowling(player1, player2);
            game.playGame();

            System.out.print("Do you want to play another game? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
    }
}
=======
// Author: Manansinh Vansia
// Date:  05-07-2024
// Description: Assignment_3 bowling_Game between 2 players.

import java.util.Scanner;

public class bowling {

    // total number of frames in a bowling game
    private static final int FRAMES = 10;
    // total number of pins in each frame
    private static final int PINS = 10;
    // Maximum rolls in this game which will include bonus rolls in the 10th frame
    private static final int MAX_ROLLS = 21;
    private static final Scanner scanner = new Scanner(System.in);

    // array which will store player names
    private String[] players;
    // array which will store the number of pins knocked down in each roll for both players playing the game
    private int[][] rolls;
    // array which will store the scores for each frame for both players playing the game
    private int[] frameScores;

    // Constructor which will help to initialize player names, rolls, and frameScore arrays
    public bowling(String player1, String player2) {
        players = new String[]{player1, player2};
        rolls = new int[2][MAX_ROLLS];
        frameScores = new int[2];
    }


    // Prompt user for roll input, validate, and return the roll score
    private int getRoll(String playerName) {
        int roll;
        do {
            System.out.print(playerName + ", enter your roll (0-10): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. " + playerName + ", enter your roll (0-10): ");
                scanner.next();
            }
            roll = scanner.nextInt();
            if (roll < 0 || roll > PINS) {
                System.out.println("Error: Please enter a number between 0 and 10.");
            }
            // validating the roll input
        } while (roll < 0 || roll > PINS);
        return roll;
    }

    // calculate
    private int getRoll(int player) {
        int roll;
        do {
            System.out.print(players[player] + ", enter your roll (0-10): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. " + players[player] + ", enter your roll (0-10): ");
                scanner.next();
            }
            roll = scanner.nextInt();
        } while (roll < 0 || roll > PINS);
        return roll;
    }


    // Calculate score for one turn (two rolls)
    private int getTurnScores(int playerIndex, int frameNumber) {
        int score = 0;
        int rollIndex = frameNumber * 2;

        int roll1 = getRoll(players[playerIndex]);
        rolls[playerIndex][rollIndex] = roll1;

        if (roll1 < PINS) { // Not a strike
            int roll2 = getRoll(players[playerIndex]);
            rolls[playerIndex][rollIndex + 1] = roll2;
            score = roll1 + roll2;

            // Check for spare bonus
            if (score == PINS) {
                score += getBonus(playerIndex, rollIndex + 2);
            }
        } else { // Strike
            score = PINS + getBonus(playerIndex, rollIndex + 1);
        }

        return score;
    }

    // Get bonus points for strikes and spares
    private int getBonus(int playerIndex, int bonusRollIndex) {
        if (bonusRollIndex < MAX_ROLLS) {
            return rolls[playerIndex][bonusRollIndex];
        }
        return 0;
    }

    // Play the bowling game
    public void playGame() {
        int currentFrame = 0;
        while (currentFrame < FRAMES) {
            for (int playerIndex = 0; playerIndex < 2; playerIndex++) {
                int turnScore = getTurnScores(playerIndex, currentFrame);
                frameScores[playerIndex] += turnScore;
                printFrameScore(playerIndex, currentFrame);
            }
            currentFrame++;
        }
        displayResults();
    }

    // Print score for the current frame for a player
    private void printFrameScore(int playerIndex, int frameNumber) {
        System.out.println(players[playerIndex] + "'s score for frame " + (frameNumber + 1) + ": " + frameScores[playerIndex]);
    }

    // Calculate final scores and determine the winner
    private void displayResults() {
        System.out.println("\nGame Over!");
        System.out.println("Final Scores:");
        for (int playerIndex = 0; playerIndex < 2; playerIndex++) {
            System.out.println(players[playerIndex] + ": " + frameScores[playerIndex]);
        }
        if (frameScores[0] > frameScores[1]) {
            System.out.println(players[0] + " wins!");
        } else if (frameScores[0] < frameScores[1]) {
            System.out.println(players[1] + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String player1, player2;
        do {
            System.out.print("Enter the name of player 1: ");
            player1 = scanner.nextLine();
            System.out.print("Enter the name of player 2: ");
            player2 = scanner.nextLine();

            bowling game = new bowling(player1, player2);
            game.playGame();

            System.out.print("Do you want to play another game? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
    }
}
>>>>>>> b92a6f7d30aa1ed2821ca3047ccc4585b531a44d
