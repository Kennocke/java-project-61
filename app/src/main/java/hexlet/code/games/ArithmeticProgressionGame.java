package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ArithmeticProgressionGame {
    static final String START_MESSAGE = "What number is missing in the progression?";
    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 50;
    static final int MIN_SEQUENCE_LENGTH = 5;
    static final int MAX_SEQUENCE_LENGTH = 10;
    static final int MIN_STEP_LENGTH = 1;
    static final int MAX_STEP_LENGTH = 5;
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
        int sequenceElement = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int sequenceLength = Utils.generateRandomInt(MIN_SEQUENCE_LENGTH, MAX_SEQUENCE_LENGTH);
        int stepLength = Utils.generateRandomInt(MIN_STEP_LENGTH, MAX_STEP_LENGTH);
        String[] sequence = new String[sequenceLength];

        for (int i = 0; i < sequenceLength; i++) {
            sequence[i] = Integer.toString(sequenceElement);
            sequenceElement += stepLength;
        }

        String hiddenNumber = sequence[Utils.generateRandomInt(0, sequenceLength)];
        String question = String.join(" ", sequence).replace(hiddenNumber, "..");
        String correctAnswer = hiddenNumber;
        roundData[0] = question;
        roundData[1] = correctAnswer;
    }
}
