package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenParityGame {
    static final String START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int LOWER_BOUND = 0;
    static final int UPPER_BOUND = 50;
    public static void play() {
        String[][] gameData = generateGameData(Engine.ROUNDS_COUNT);
        Engine.startGame(START_MESSAGE, gameData);
    }
    private static String[][] generateGameData(int roundsCount) {
        String[][] gameData = new String[roundsCount][2];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        return gameData;
    }
    private static String[] generateRoundData() {
        String[] roundData = new String[2];
        String question = Integer.toString(Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND));
        String correctAnswer = getCorrectAnswer(question);
        roundData[0] = question;
        roundData[1] = correctAnswer;

        return roundData;
    }
    private static String getCorrectAnswer(String question) {
        return isEven(Integer.parseInt(question)) ? "yes" : "no";
    }
    private static Boolean isEven(int number) {
        return number % 2 == 0;
    }
}
