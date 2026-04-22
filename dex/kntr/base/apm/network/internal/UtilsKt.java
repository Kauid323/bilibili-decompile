package kntr.base.apm.network.internal;

import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a&\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000\u001a-\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r*\u00060\u000ej\u0002`\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u0011H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"LOG_TAG", "", "currentTimestamp", "", "logD", "", "tag", "msg", "logI", "logE", "e", "", "with", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "network_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    private static final String LOG_TAG = "NetworkMetricsAggregator";

    public static final long currentTimestamp() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public static final void logD(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().d(LOG_TAG, "<" + tag + "> " + msg);
    }

    public static final void logI(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        KLog_androidKt.getKLog().i(LOG_TAG, "<" + tag + "> " + msg);
    }

    public static /* synthetic */ void logE$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logE(str, str2, th);
    }

    public static final void logE(String tag, String msg, Throwable e) {
        String message;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (e != null) {
            message = msg + ", has exception: " + e.getMessage() + "\n" + ExceptionsKt.stackTraceToString(e);
        } else {
            message = msg;
        }
        if (message == null) {
            message = "unknow error message.";
        }
        KLog_androidKt.getKLog().e(LOG_TAG, "<" + tag + "> " + message);
    }

    public static final <T> T with(ReentrantLock $this$with, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter($this$with, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        $this$with.lock();
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            $this$with.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}