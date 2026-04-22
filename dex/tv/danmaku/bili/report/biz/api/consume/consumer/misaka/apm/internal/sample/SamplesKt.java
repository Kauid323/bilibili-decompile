package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.sample;

import java.util.Random;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: Samples.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\u0006\u0010\t\u001a\u00020\u0005\u001a\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"sRandom", "Ljava/util/Random;", "sample", "", "rate", "", "randInt", "min", "max", "randomInt", "sample2", "threshold", "MIN", "MAX", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SamplesKt {
    public static final int MAX = 100;
    public static final int MIN = 0;
    private static final Random sRandom = new Random();

    public static final boolean sample(int rate) {
        return rate > 0 && sRandom.nextInt() % rate == 0;
    }

    public static final int randInt(int min, int max) {
        return sRandom.nextInt((max - min) + 1) + min;
    }

    public static final int randomInt() {
        return randInt(0, 99);
    }

    public static final boolean sample2(int threshold) {
        return randomInt() < threshold;
    }
}