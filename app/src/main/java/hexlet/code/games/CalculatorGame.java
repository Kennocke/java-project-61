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
    public static void play() throws Exception {
        String[][] questions = generateQuestions(Engine.QUESTIONS_COUNT);
        Engine.startGame(START_MESSAGE, questions);
    }
    public static String[][] generateQuestions(int questionsCount) throws Exception {
        String[][] questions = new String[questionsCount][2];

        for (String[] question : questions) {
            int firstOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int secondOperand = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int operatorsCount = OPERATORS.length;
            String operand = OPERATORS[Utils.generateRandomInt(0, operatorsCount)];

            String expression;
            int correctAnswer;

            switch (operand) {
                case "Plus" -> {
                    expression = firstOperand + " + " + secondOperand;
                    correctAnswer = firstOperand + secondOperand;
                }
                case "Minus" -> {
                    expression = firstOperand + " - " + secondOperand;
                    correctAnswer = firstOperand - secondOperand;
                }
                case "Multiply" -> {
                    expression = firstOperand + " * " + secondOperand;
                    correctAnswer = firstOperand * secondOperand;
                }
                default -> throw new Exception("Unknown operation");
            }

            question[0] = expression;
            question[1] = Integer.toString(correctAnswer);
        }

        return questions;
    }
}
