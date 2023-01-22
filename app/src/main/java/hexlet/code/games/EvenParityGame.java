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
        for (String[] roundData : gameData) {
            generateRoundData(roundData);
        }
        return gameData;
    }
    private static void generateRoundData(String[] roundData) {
        String question = Integer.toString(Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND));
        String correctAnswer = getCorrectAnswer(question);
        roundData[0] = question;
        roundData[1] = correctAnswer;
    }
    private static String getCorrectAnswer(String question) {
        return Integer.parseInt(question) % 2 == 0 ? "yes" : "no";
    }
}
