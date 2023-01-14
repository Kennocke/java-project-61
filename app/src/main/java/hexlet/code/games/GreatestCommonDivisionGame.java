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
        String[][] questions = generateQuestions(Engine.QUESTIONS_COUNT);
        Engine.startGame(START_MESSAGE, questions);
    }

    public static String[][] generateQuestions(int questionsCount) {
        String[][] questions = new String[questionsCount][2];

        for (String[] question : questions) {
            int firstNum = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int secondNum = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            String expression = firstNum + " " + secondNum;
            int correctAnswer = findGCD(firstNum, secondNum);
            question[0] = expression;
            question[1] = Integer.toString(correctAnswer);
        }

        return questions;
    }

    public static int findGCD(int firstNum, int secondNum) {
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

    public static int[] getNumberDivisors(int num) {
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
