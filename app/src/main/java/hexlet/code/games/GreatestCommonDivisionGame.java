package hexlet.code.games;

import java.util.Arrays;

import hexlet.code.Engine;
import hexlet.code.Utils;
import org.apache.commons.lang3.ArrayUtils;

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

        for (String[] roundData : gameData) {
            generateRoundData(roundData);
        }

        return gameData;
    }
    private static void generateRoundData(String[] roundData) {
        int firstNum = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int secondNum = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        String question = firstNum + " " + secondNum;
        String correctAnswer = getCorrectAnswer(question);
        roundData[0] = question;
        roundData[1] = correctAnswer;
    }
    private static String getCorrectAnswer(String question) {
        String[] expressionParts = question.split(" ");
        int firstNum = Integer.parseInt(expressionParts[0]);
        int secondNum = Integer.parseInt(expressionParts[1]);
        return Integer.toString(getGBC(firstNum, secondNum));
    }
    private static int getGBC(int firstNum, int secondNum) {
        int[] divisorsFirstNum = getNumberDivisors(firstNum);
        int[] divisorsSecondNum = getNumberDivisors(secondNum);
        int[] leastArray = divisorsFirstNum.length > divisorsSecondNum.length ? divisorsFirstNum : divisorsSecondNum;
        int[] anotherArray = divisorsFirstNum.length > divisorsSecondNum.length ? divisorsSecondNum : divisorsFirstNum;
        int greatestCommonDivision = -1;

        for (int j : leastArray) {
            if (ArrayUtils.contains(anotherArray, j) && j > greatestCommonDivision) {
                greatestCommonDivision = j;
            }
        }

        return greatestCommonDivision;
    }
    private static int[] getNumberDivisors(int num) {
        int[] divisors = new int[num];
        int index = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisors[index] = i;
                index++;
            }
        }

        return Arrays.copyOf(divisors, index);
    }
}
