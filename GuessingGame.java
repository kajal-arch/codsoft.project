import java.util.Random;
import java.util.Scanner;
public class GuessingGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("--- Welcome to the Number Guessing Game! ---");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Range 1 to 100
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsUsed < maxAttempts) {
                attemptsUsed++;
                System.out.print("Attempt " + attemptsUsed + ": Enter your guess: ");

                // Input validation
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a valid number! Try again.");
                    scanner.next();
                }
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Correct! You found it in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    // Score calculation: higher points for fewer attempts
                    int roundPoints = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += roundPoints;
                    roundsWon++;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + targetNumber);
            }

            System.out.println("Current Score: " + totalScore + " | Rounds Won: " + roundsWon);
            System.out.print("Do you want to play another round? (y/n): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("y");
        }

        System.out.println("\nFinal Result - Score: " + totalScore + " | Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

