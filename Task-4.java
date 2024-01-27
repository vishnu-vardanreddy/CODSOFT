package CodeSoftPrgs;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    char correctAnswer;
    private volatile char userAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ". " + options[i]);
        }
    }

    public boolean isCorrect() {
        return Character.toUpperCase(userAnswer) == correctAnswer;
    }

    public void setUserAnswer(char userAnswer) {
        this.userAnswer = userAnswer;
    }
}

public class Task_4 {
    private static Timer timer = new Timer(true);
    private static int userScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        QuizQuestion[] quizQuestions = new QuizQuestion[3];

        quizQuestions[0] = new QuizQuestion("What is the capital of France?",
                new String[]{"Paris", "Berlin", "Madrid", "Rome"}, 'A');
        quizQuestions[1] = new QuizQuestion("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 'B');
        quizQuestions[2] = new QuizQuestion("What is the largest mammal?",
                new String[]{"Elephant", "Whale", "Giraffe", "Hippopotamus"}, 'B');

        for (QuizQuestion question : quizQuestions) {
            question.displayQuestion();

            
            setTimer(10, question);

            System.out.print("Your answer (A/B/C/D): ");

            // Allow users to select an option and submit their answer within the given time
            Thread userInputThread = new Thread(() -> {
                char userAnswer = sc.next().charAt(0);
                question.setUserAnswer(userAnswer);
                timer.cancel(); // Cancel the timer once the user provides an answer
            });

            userInputThread.start();

            try {
                userInputThread.join(); // Wait for user input thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (question.isCorrect()) {
                System.out.println("Correct!\n");
                userScore++; // Increment the user's score for each correct answer
            } else {
                System.out.println("Incorrect. The correct answer is " + question.correctAnswer + ".\n");
            }
        }

        System.out.println("Your final score: " + userScore + "/" + quizQuestions.length);

        sc.close();
    }

    private static void setTimer(int seconds, QuizQuestion question) {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! You didn't answer in time.\n");
                timer.cancel();
                question.setUserAnswer(' '); // Set a default value if the user doesn't answer in time
            }
        }, seconds * 1000);
    }
}
