package tv.danmaku.bili.splash.ad.chronos;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;

/* compiled from: SplashChronosHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/splash/ad/chronos/SplashChronosHelper;", "", "<init>", "()V", "fawkesChronosSplashEnabled", "", "getFawkesChronosSplashEnabled", "()Z", "reportLoadingInfo", "", "time", "", "coldStart", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashChronosHelper {
    public static final int $stable = 0;
    public static final SplashChronosHelper INSTANCE = new SplashChronosHelper();

    private SplashChronosHelper() {
    }

    public final boolean getFawkesChronosSplashEnabled() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab2().get("chronos.splash_enabled", false);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void reportLoadingInfo(long time, boolean coldStart) {
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("total_time", String.valueOf(time));
        pairArr[1] = TuplesKt.to("cold_start", coldStart ? "1" : "0");
        Neurons.trackT$default(false, "main-common-splash.chronos_execution_time", MapsKt.mapOf(pairArr), 0, (Function0) null, 24, (Object) null);
    }
}