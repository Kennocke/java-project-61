package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalculatorGame {
    static final String START_MESSAGE = "What is the result of the expression?";
    static final int LOWER_BOUND = 0;
    static final int UPPER_BOUND = 50;
    static final String[] OPERATORS = new String[] {
        "Plus",
        "Minus",
        "Multiply"
    };
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
        int firstOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int secondOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
        int operatorsCount = OPERATORS.length;
        String operator = OPERATORS[Utils.generateRandomInt(0, operatorsCount)];
        String question;

        switch (operator) {
            case "Plus" -> question = firstOperand + " + " + secondOperand;
            case "Minus" -> question = firstOperand + " - " + secondOperand;
            case "Multiply" -> question = firstOperand + " * " + secondOperand;
            default -> throw new RuntimeException("Unknown operation");
        }

        String correctAnswer = getCorrectAnswer(question);
        roundData[0] = question;
        roundData[1] = correctAnswer;
    }
    private static String getCorrectAnswer(String question) {
        String[] expressionParts = question.split(" ");
        int firstOperand = Integer.parseInt(expressionParts[0]);
        int secondOperand = Integer.parseInt(expressionParts[2]);
        String operator = expressionParts[1];
        String correctAnswer;

        switch (operator) {
            case "+" -> correctAnswer = Integer.toString(firstOperand + secondOperand);
            case "-" -> correctAnswer = Integer.toString(firstOperand - secondOperand);
            case "*" -> correctAnswer = Integer.toString(firstOperand * secondOperand);
            default -> throw new RuntimeException("Unknown operation");
        }

        return correctAnswer;
    }
}
