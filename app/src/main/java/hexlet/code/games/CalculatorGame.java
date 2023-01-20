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
            int firstOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int secondOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int operatorsCount = OPERATORS.length;
            String operator = OPERATORS[Utils.generateRandomInt(0, operatorsCount)];

            switch (operator) {
                case "Plus" -> {
                    question[0] = firstOperand + " + " + secondOperand;
                }
                case "Minus" -> {
                    question[0] = firstOperand + " - " + secondOperand;
                }
                case "Multiply" -> {
                    question[0] = firstOperand + " * " + secondOperand;
                }
                default -> throw new RuntimeException("Unknown operation");
            }
        }

        return questions;
    }
    public static void fillCorrectAnswers(String[][] questions) {
        for (String[] question : questions) {
            String[] expressionParts = question[0].split(" ");
            int firstOperand = Integer.parseInt(expressionParts[0]);
            int secondOperand = Integer.parseInt(expressionParts[2]);
            String operator = expressionParts[1];

            switch (operator) {
                case "+" -> {
                    question[1] = Integer.toString(firstOperand + secondOperand);
                }
                case "-" -> {
                    question[1] = Integer.toString(firstOperand - secondOperand);
                }
                case "*" -> {
                    question[1] = Integer.toString(firstOperand * secondOperand);
                }
                default -> throw new RuntimeException("Unknown operation");
            }
        }
    }
}
