package tv.danmaku.bili.bilow;

import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.config.OkHttpConfig;

/* compiled from: Timeouts.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"connectTimeoutMs", "", "readTimeoutMs", "writeTimeoutMs", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TimeoutsKt {
    public static final long connectTimeoutMs() {
        Long connectTimeoutMs = OkHttpConfig.INSTANCE.getConnectTimeoutMs();
        long result = connectTimeoutMs != null ? connectTimeoutMs.longValue() : 12000L;
        BLog.ifmt("BilowEx", "Default connect timeout %d ms.", Long.valueOf(result));
        return result;
    }

    public static final long readTimeoutMs() {
        Long readTimeoutMs = OkHttpConfig.INSTANCE.getReadTimeoutMs();
        long result = readTimeoutMs != null ? readTimeoutMs.longValue() : 12000L;
        BLog.ifmt("BilowEx", "Default read timeout %d ms.", Long.valueOf(result));
        return result;
    }

    public static final long writeTimeoutMs() {
        Long writeTimeoutMs = OkHttpConfig.INSTANCE.getWriteTimeoutMs();
        long result = writeTimeoutMs != null ? writeTimeoutMs.longValue() : 12000L;
        BLog.ifmt("BilowEx", "Default write timeout %d ms.", Long.valueOf(result));
        return result;
    }
}