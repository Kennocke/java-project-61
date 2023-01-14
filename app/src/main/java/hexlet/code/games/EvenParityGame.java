package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenParityGame {
    static final String START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int LOWER_BOUND = 0;
    static final int UPPER_BOUND = 50;
    public static void play() {
        String[][] questions = generateQuestions(Engine.QUESTIONS_COUNT);
        Engine.startGame(START_MESSAGE, questions);
    }

    public static String[][] generateQuestions(int questionsCount) {
        String[][] questions = new String[questionsCount][2];
        for (String[] question : questions) {
            int randomNumber = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            question[0] = Integer.toString(randomNumber);
            question[1] = correctAnswer;
        }
        return questions;
    }
}
