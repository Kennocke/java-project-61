package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class CalculatorGame extends Engine {
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
        Random rand = new Random();
        String[][] questions = new String[questionsCount][2];

        for (String[] question : questions) {
            int firstOperand = rand.nextInt(LOWER_BOUND, UPPER_BOUND);
            int secondOperand = rand.nextInt(LOWER_BOUND, UPPER_BOUND);
            String operand = OPERATORS[rand.nextInt(0, 2)];

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