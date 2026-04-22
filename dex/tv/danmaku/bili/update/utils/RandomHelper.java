package tv.danmaku.bili.update.utils;

import java.util.Random;

public final class RandomHelper {
    private static final Random RANDOM = new Random();

    public static int getRandomInt(int n) {
        return RANDOM.nextInt(n);
    }
}