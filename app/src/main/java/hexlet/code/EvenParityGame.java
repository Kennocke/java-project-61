package hexlet.code;

import java.util.Random;
import java.util.Scanner;



public class EvenParityGame {
    final static int LOWER_LIMIT = 0;
    final static int UPPER_LIMIT = 50;
    public static void play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = sc.nextLine();
        System.out.printf("Hello, %s !\n",  playerName);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int randomNumber = rand.nextInt(LOWER_LIMIT, UPPER_LIMIT);
            System.out.println("Question: " + randomNumber);
            String playerAnswer = sc.next();
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            if (correctAnswer.equalsIgnoreCase(playerAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'", playerAnswer, correctAnswer);
                return;
            }
        }

        System.out.format("Congratulations, %s!", playerName);
    }
}
