package CodeSoftPrgs;
import java.util.Scanner;
import java.util.Random;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            playGame(sc);
            
            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }

    private static void playGame(Scanner sc) {
        System.out.println("Enter any number range from 1 to 100");

        int min = 1, max = 100;
        boolean guessedCorrectly = false;
        int attempt = 0;
        int score = 0;

        while (!guessedCorrectly && attempt < 3) {
            int randomnum = generateRandomNum(max, min);
            int usernum = getUserNum(sc);
            compareUserAndRandom(usernum, randomnum);
            attempt++;
            System.out.println("Number of attempts remaining are " + (3 - attempt));
            score--;
            if (usernum == randomnum) {
                guessedCorrectly = true;
                score++;
            }
        }

        System.out.println("End of Attempts");
        System.out.println("Your Score: " + score);
    }

    private static int generateRandomNum(int max, int min) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private static int getUserNum(Scanner sc) {
        System.out.println("Enter your guess: ");
        return sc.nextInt();
    }

    private static void compareUserAndRandom(int usernum, int randomnum) {
        if (randomnum == usernum) {
            System.out.println("You guessed the number correctly");
            System.out.println("Random number is: " + randomnum);
        } else {
            System.out.println("Incorrect guess");
            if (usernum > randomnum) {
                System.out.println("The number you have guessed is larger than the random number " + randomnum);
            } else {
                System.out.println("The number you have guessed is smaller than the random number " + randomnum);
            }
        }
    }
}
