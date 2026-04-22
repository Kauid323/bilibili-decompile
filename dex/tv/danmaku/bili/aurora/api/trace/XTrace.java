package tv.danmaku.bili.aurora.api.trace;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: XTrace.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0003¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/aurora/api/trace/XTrace;", "", "<init>", "()V", "id", "", "getId", "traceId", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class XTrace {
    public static final XTrace INSTANCE = new XTrace();

    private XTrace() {
    }

    public final String id() {
        try {
            return getId();
        } catch (Exception e) {
            BLog.e("net.aurora.xtrace", e);
            return "";
        }
    }

    private final String getId() {
        String traceId = traceId();
        String spanId = traceId.substring(traceId.length() / 2);
        Intrinsics.checkNotNullExpressionValue(spanId, "substring(...)");
        return traceId + ":" + spanId + ":0:0";
    }

    private final String traceId() {
        byte[] bytes = new byte[16];
        new Random().nextBytes(bytes);
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        for (int i = 15; 12 < i; i--) {
            timestamp >>= 8;
            bytes[i] = (byte) timestamp;
        }
        return XTraceKt.toHex(bytes);
    }
}