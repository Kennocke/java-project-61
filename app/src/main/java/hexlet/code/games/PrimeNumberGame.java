package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeNumberGame {
    static final String START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int LOWER_BOUND = 2;
    static final int UPPER_BOUND = 100;
    public static void play() throws Exception {
        String[][] questions = generateQuestions(Engine.QUESTIONS_COUNT);
        Engine.startGame(START_MESSAGE, questions);
    }
    public static String[][] generateQuestions(int questionCount) throws Exception {
        String[][] questions = new String[questionCount][2];

        for (String[] question : questions) {
            int randomNumber = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            String correctAnswer = checkPrimeNumber(randomNumber) ? "yes" : "no";
            question[0] = Integer.toString(randomNumber);
            question[1] = correctAnswer;
        }

        return questions;
    }
    public static boolean checkPrimeNumber(int number) throws Exception {
        if (number <= 1) {
            throw new Exception("Incorrect input number");
        }

        int divisorsCount = 0;

        for (int i = 1; i < number / 2; i++) {
            if (number % i == 0) {
                divisorsCount++;
            }
        }

        return divisorsCount == 1;
    }
}
