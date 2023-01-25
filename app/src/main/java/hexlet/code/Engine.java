package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;
    public static void startGame(String startMessage, String[][] gameData) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = sc.nextLine();
        System.out.printf("Hello, %s!\n",  playerName);

        System.out.println(startMessage);
        for (String[] roundData : gameData) {
            String question = roundData[0];
            String correctAnswer = roundData[1];

            System.out.println("Question: " + question);
            String playerAnswer = sc.next();

            if (playerAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'. Let's try again, %s!",
                        playerAnswer, correctAnswer, playerName);
                return;
            }
        }

        System.out.format("Congratulations, %s!", playerName);
        sc.close();
    }
}
