package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalculatorGame {
    static final String START_MESSAGE = "What is the result of the expression?";
    static final int LOWER_BOUND = 0;
    static final int UPPER_BOUND = 50;
    static final String[] OPERATORS = new String[] {
        "+",
        "-",
        "*"
    };
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
        int firstOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int secondOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int operatorsCount = OPERATORS.length;
        String operator = OPERATORS[Utils.generateRandomInt(0, operatorsCount)];
        String question = String.format("%s %s %s", firstOperand, operator, secondOperand);
        String correctAnswer = getCorrectAnswer(firstOperand, secondOperand, operator);
        roundData[0] = question;
        roundData[1] = correctAnswer;

        return roundData;
    }
    private static String getCorrectAnswer(int firstOperand, int secondOperand, String operator) {
        return switch (operator) {
            case "+" -> Integer.toString(firstOperand + secondOperand);
            case "-" -> Integer.toString(firstOperand - secondOperand);
            case "*" -> Integer.toString(firstOperand * secondOperand);
            default -> throw new RuntimeException("Unknown operation");
        };
    }
}
