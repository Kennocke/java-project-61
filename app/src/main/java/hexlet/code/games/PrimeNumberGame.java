package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeNumberGame {
    static final String START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int LOWER_BOUND = 2;
    static final int UPPER_BOUND = 100;
    public static void play() {
        String[][] questions = generateQuestions(Engine.QUESTIONS_COUNT);
        Engine.startGame(START_MESSAGE, questions);
    }
    public static String[][] generateQuestions(int questionsCount) {
        String[][] questions = createQuestions(questionsCount);
        fillCorrectAnswers(questions);
        return questions;
    }
    public static String[][] createQuestions(int questionsCount) {
        String[][] questions = new String[questionsCount][2];

        for (String[] question : questions) {
            int randomNumber = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            question[0] = Integer.toString(randomNumber);
        }

        return questions;
    }
    public static void fillCorrectAnswers(String[][] questions) {
        for (String[] question: questions) {
            int numberForCheck = Integer.parseInt(question[0]);
            question[1] = checkPrimeNumber(numberForCheck) ? "yes" : "no";
        }
    }
    public static boolean checkPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        int divisorsCount = 0;

        for (int i = 1; i < Math.abs(number) / 2; i++) {
            if (number % i == 0) {
                divisorsCount++;
            }
        }

        return divisorsCount == 1;
    }
}
