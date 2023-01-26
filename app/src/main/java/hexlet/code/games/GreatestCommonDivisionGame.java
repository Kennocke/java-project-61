package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GreatestCommonDivisionGame {
    static final String START_MESSAGE = "Find the greatest common divisor of given numbers.";
    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 50;
    public static void play() {
        String[][] gameData = generateGameData(Engine.ROUNDS_COUNT);
        Engine.startGame(START_MESSAGE, gameData);
    }
    public static String[][] generateGameData(int roundsCount) {
        String[][] gameData = new String[roundsCount][2];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        return gameData;
    }
    private static String[] generateRoundData() {
        String[] roundData = new String[2];
        int firstNum = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int secondNum = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        String question = firstNum + " " + secondNum;
        String correctAnswer = Integer.toString(getGBC(firstNum, secondNum));
        roundData[0] = question;
        roundData[1] = correctAnswer;

        return roundData;
    }
    private static int getGBC(int firstNum, int secondNum) {
        int firsNumber = firstNum;
        int secondNumber = secondNum;
        int remainder;

        do {
            remainder = firsNumber % secondNumber;
            firsNumber = secondNumber;
            secondNumber = remainder;
        } while (remainder > 0);

        return firsNumber;
    }
}
