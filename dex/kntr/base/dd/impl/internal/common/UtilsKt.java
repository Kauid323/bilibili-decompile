package kntr.base.dd.impl.internal.common;

import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.datetime.Clock;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0000\u001a-\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\u00060\tj\u0002`\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"isLessThanOrEqualTo", "", "", "other", "precision", "randomHitsProbability", "probability", "with", "T", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "currentTimestamp", "", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    static /* synthetic */ boolean isLessThanOrEqualTo$default(double d, double d2, double d3, int i, Object obj) {
        double d4;
        if ((i & 2) == 0) {
            d4 = d3;
        } else {
            d4 = 1.0E-7d;
        }
        return isLessThanOrEqualTo(d, d2, d4);
    }

    private static final boolean isLessThanOrEqualTo(double $this$isLessThanOrEqualTo, double other, double precision) {
        return $this$isLessThanOrEqualTo < other || Math.abs($this$isLessThanOrEqualTo - other) <= precision;
    }

    public static /* synthetic */ boolean randomHitsProbability$default(double d, double d2, int i, Object obj) {
        if ((i & 2) != 0) {
            d2 = 1.0E-6d;
        }
        return randomHitsProbability(d, d2);
    }

    public static final boolean randomHitsProbability(double probability, double precision) {
        if (isLessThanOrEqualTo$default(probability, 0.0d, 0.0d, 2, null)) {
            return false;
        }
        if (isLessThanOrEqualTo$default(1.0d, probability, 0.0d, 2, null)) {
            return true;
        }
        return isLessThanOrEqualTo(Random.Default.nextDouble(0.0d, 1.0d), probability, precision);
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

    public static final long currentTimestamp() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }
}