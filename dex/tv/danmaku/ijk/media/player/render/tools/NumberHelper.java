package tv.danmaku.ijk.media.player.render.tools;

import java.math.BigDecimal;

public class NumberHelper {
    public static double round(double value, int scale, int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        double d = bd.setScale(scale, roundingMode).doubleValue();
        return d;
    }
}