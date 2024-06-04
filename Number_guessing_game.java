/**
 * @author Manansinh Vansia
 * @version 1.0
 * 2024-05-24
 * Number Guessing Game from 1 to 100 numbers.
 */

// Import to handle input errors
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Number_guessing_game {

    public static void main(String[] args) {

        // Create an instance of the random class
        Random random = new Random();

        // Create an instance of the Scanner class
        Scanner scanner = new Scanner(System.in);

        // Minimum number for the range
        int min = 1;

        // Maximum number for the range
        int max = 100;

        // Variable to control if the user wants to play again
        boolean playAgain;

        // Main loop to play the game multiple times if the user chooses
        do {
            // Generate a random number between min and max
            int numberToGuess = random.nextInt(max - min + 1) + min;

            // Counter for the number of guesses
            int numberOfGuesses = 0;

            // Flag to check if the user has guessed correctly
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to my Guessing the Number Game!");
            System.out.println("I have selected a number that is between " + min + " and " + max + ".");
            System.out.println("Try to guess the correct number!");

            // Loop until the user guesses the correct number
            while (!hasGuessedCorrectly) {
                System.out.print("Please enter your guess number: ");
                try {

                    // Read the user's guess
                    int userGuess = scanner.nextInt();

                    // Increment the guess counter
                    numberOfGuesses++;

                    // Check if the guess is too low, too high, or correct
                    if (userGuess < numberToGuess) {
                        System.out.println("Number is too low! Try again.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Number is too high! Try again.");
                    } else {
                        // Set flag to true if the number guess is correct
                        System.out.println("Congratulations! You have guessed the correct number in " + numberOfGuesses + " tries.");
                        hasGuessedCorrectly = true;
                    }
                } catch (InputMismatchException e) {

                    // Handle invalid input
                    System.out.println("Invalid input. Please enter a number.");

                    // Clear the invalid input
                    scanner.next();
                }
            }

            // Ask the user if they want to play again
            System.out.print("Would you like to play this game again? (yes/no): ");

            // Read the user's response
            playAgain = scanner.next().equalsIgnoreCase("yes");


            scanner.nextLine();

            // Repeat the game if the user wants to play again
        } while (playAgain);

        System.out.println("Thank you for playing this game! Goodbye and enjoy.");

        scanner.close();
    }
}