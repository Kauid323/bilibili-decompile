package leakcanary.internal;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0080\b¨\u0006\u0005"}, d2 = {"measureDurationMillis", "", "block", "Lkotlin/Function0;", "", "leakcanary-android-utils_release"}, k = 2, mv = {1, 4, 1})
public final class TimingKt {
    public static final long measureDurationMillis(Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        long start = SystemClock.uptimeMillis();
        block.invoke();
        return SystemClock.uptimeMillis() - start;
    }
}