package hexlet.code;

import java.util.Random;

public class Utils {
    public static final Random RAND = new Random();
    public static int generateRandomInt(int min, int max) {
        return RAND.nextInt(min, max);
    }
    public static Constants.Games getNameGame(Constants.Games[] games, int gameNumber) {
        if (gameNumber < 0 || gameNumber >= games.length) {
            throw new RuntimeException("Unknown game");
        }

        return games[gameNumber];
    }
}
