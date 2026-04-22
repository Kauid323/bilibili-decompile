package kntr.common.upper.trace;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\b"}, d2 = {"traceD", "", "Lkntr/base/log/ILogger;", "message", "", "traceW", "traceE", "traceDetail", "trace-core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TraceUtilsKt {
    public static final void traceD(ILogger $this$traceD, String message) {
        Intrinsics.checkNotNullParameter($this$traceD, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        $this$traceD.d("@Trace@", message);
    }

    public static final void traceW(ILogger $this$traceW, String message) {
        Intrinsics.checkNotNullParameter($this$traceW, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        $this$traceW.w("@Trace@", message);
    }

    public static final void traceE(ILogger $this$traceE, String message) {
        Intrinsics.checkNotNullParameter($this$traceE, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        $this$traceE.e("@Trace@", message);
    }

    public static final void traceDetail(ILogger $this$traceDetail, String message) {
        Intrinsics.checkNotNullParameter($this$traceDetail, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        $this$traceDetail.d("@Trace-Detail@", message);
    }
}