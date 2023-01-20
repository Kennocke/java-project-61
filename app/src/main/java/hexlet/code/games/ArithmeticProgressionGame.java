package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import org.apache.commons.lang3.ArrayUtils;

public class ArithmeticProgressionGame {
    static final String START_MESSAGE = "What number is missing in the progression?";
    static final int LOWER_BOUND = 1;
    static final int UPPER_BOUND = 50;
    static final int MIN_SEQUENCE_LENGTH = 5;
    static final int MAX_SEQUENCE_LENGTH = 10;
    static final int MIN_STEP_LENGTH = 1;
    static final int MAX_STEP_LENGTH = 5;
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
            int sequenceElement = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int sequenceLength = Utils.generateRandomInt(MIN_SEQUENCE_LENGTH, MAX_SEQUENCE_LENGTH);
            int stepLength = Utils.generateRandomInt(MIN_STEP_LENGTH, MAX_STEP_LENGTH);
            String[] sequence = new String[sequenceLength];

            for (int i = 0; i < sequenceLength; i++) {
                sequence[i] = Integer.toString(sequenceElement);
                sequenceElement += stepLength;
            }

            String hiddenNumber = sequence[Utils.generateRandomInt(0, sequenceLength)];
            question[0] = String.join(" ", sequence).replace(hiddenNumber, "..");
        }

        return questions;
    }
    public static void fillCorrectAnswers(String[][] questions) {
        for (String[] question : questions) {
            String[] sequence = question[0].split(" ");

            if (sequence.length < 3) {
                throw new RuntimeException("Not enough data for detecting correct answer");
            }

            int unknownElementIndex = ArrayUtils.indexOf(sequence, "..");
            int sequenceStep;
            if (unknownElementIndex == 0) {
                sequenceStep = Integer.parseInt(sequence[unknownElementIndex + 2])
                        - Integer.parseInt(sequence[unknownElementIndex + 1]);
                question[1] = Integer.toString(Integer.parseInt(sequence[unknownElementIndex + 1])
                        - sequenceStep);
            } else if (unknownElementIndex + 1 == sequence.length) {
                sequenceStep = Integer.parseInt(sequence[unknownElementIndex - 1])
                        - Integer.parseInt(sequence[unknownElementIndex - 2]);
                question[1] = Integer.toString(Integer.parseInt(sequence[unknownElementIndex - 1]) + sequenceStep);
            } else {
                sequenceStep = (Integer.parseInt(sequence[unknownElementIndex + 1])
                        - Integer.parseInt(sequence[unknownElementIndex - 1])) / 2;
                question[1] = Integer.toString(Integer.parseInt(sequence[unknownElementIndex - 1]) + sequenceStep);
            }
        }
    }
}
