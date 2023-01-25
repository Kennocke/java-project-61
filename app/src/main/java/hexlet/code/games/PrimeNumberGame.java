package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeNumberGame {
    static final String START_MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int LOWER_BOUND = 2;
    static final int UPPER_BOUND = 100;
    public static void play() {
        String[][] gameData = generateQuestions(Engine.ROUNDS_COUNT);
        Engine.startGame(START_MESSAGE, gameData);
    }
    private static String[][] generateQuestions(int roundsCount) {
        String[][] gameData = new String[roundsCount][2];

        for (String[] roundData : gameData) {
            generateRoundData(roundData);
        }

        return gameData;
    }
    private static void generateRoundData(String[] roundData) {
        int randomNumber = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        String question = Integer.toString(randomNumber);
        String correctAnswer = getCorrectAnswer(question);
        roundData[0] = question;
        roundData[1] = correctAnswer;
    }
    private static String getCorrectAnswer(String question) {
        int numberForCheck = Integer.parseInt(question);
        return isPrime(numberForCheck) ? "yes" : "no";
    }
    private static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        int divisorsCount = 0;

        for (int i = 1; i <=  Math.abs(number) / 2; i++) {
            if (number % i == 0) {
                divisorsCount++;
            }
        }

        return divisorsCount == 1;
    }
}
