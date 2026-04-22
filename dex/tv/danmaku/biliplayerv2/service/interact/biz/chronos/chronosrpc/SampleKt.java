package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import java.util.Random;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Sample.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"MIN", "", "MAX", "sRandom", "Ljava/util/Random;", "randInt", "min", "max", "sample", "", "threshold", "thresholdF", "", "factor", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SampleKt {
    public static final int MAX = 100;
    public static final int MIN = 0;
    private static final Random sRandom = new Random();

    public static final int randInt(int min, int max) {
        return sRandom.nextInt((max - min) + 1) + min;
    }

    public static final boolean sample(int threshold) {
        return randInt(0, 100) < threshold;
    }

    public static /* synthetic */ boolean sample$default(float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return sample(f, i);
    }

    public static final boolean sample(float thresholdF, int factor) {
        return ((float) randInt(0, factor * 100)) < ((float) factor) * thresholdF;
    }
}