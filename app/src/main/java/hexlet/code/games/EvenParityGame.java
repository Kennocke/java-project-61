package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class EvenParityGame {
    static final String START_MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int LOWER_LIMIT = 0;
    static final int UPPER_LIMIT = 50;
    public static void play() {
        String[][] questions = generateQuestions(Engine.QUESTIONS_COUNT);
        Engine.startGame(START_MESSAGE, questions);
    }

    public static String[][] generateQuestions(int questionsCount) {
        Random rand = new Random();
        String[][] questions = new String[questionsCount][2];
        for (String[] question : questions) {
            int randomNumber = rand.nextInt(LOWER_LIMIT, UPPER_LIMIT);
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            question[0] = Integer.toString(randomNumber);
            question[1] = correctAnswer;
        }
        return questions;
    }
}
