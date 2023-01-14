package hexlet.code;

import java.util.Random;

public class Utils {
    public static final Random RAND = new Random();

    public static int generateRandomInt(int min, int max) {
        return RAND.nextInt(min, max);
    }
}
