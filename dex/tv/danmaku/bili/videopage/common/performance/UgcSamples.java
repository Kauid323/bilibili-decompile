package tv.danmaku.bili.videopage.common.performance;

import com.bilibili.lib.blconfig.ConfigManager;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UgcSamples.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/videopage/common/performance/UgcSamples;", "", "<init>", "()V", "MIN", "", "MAX", "sRandom", "Ljava/util/Random;", "randInt", "min", "max", "randomInt", "sample", "", "threshold", "wl", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UgcSamples {
    private static final int MAX = 100;
    private static final int MIN = 0;
    public static final UgcSamples INSTANCE = new UgcSamples();
    private static final Random sRandom = new Random();

    private UgcSamples() {
    }

    private final int randInt(int min, int max) {
        return sRandom.nextInt((max - min) + 1) + min;
    }

    private final int randomInt() {
        return randInt(0, 99);
    }

    @JvmStatic
    public static final boolean sample(int threshold) {
        return INSTANCE.wl() || INSTANCE.randomInt() < threshold;
    }

    private final boolean wl() {
        Object obj = ConfigManager.Companion.ab().get("ff_net_monitor_wl", false);
        Intrinsics.checkNotNull(obj);
        return ((Boolean) obj).booleanValue();
    }
}