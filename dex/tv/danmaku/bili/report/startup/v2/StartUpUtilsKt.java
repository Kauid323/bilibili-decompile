package tv.danmaku.bili.report.startup.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: StartUpUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "startUpTrace", "", "m", "t", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StartUpUtilsKt {
    public static final String TAG = "StartUp_";

    public static final void startUpTrace(String m, Throwable t) {
        Intrinsics.checkNotNullParameter(m, "m");
        Intrinsics.checkNotNullParameter(t, "t");
        BLog.i(TAG, m, t);
    }

    public static final void startUpTrace(String m) {
        Intrinsics.checkNotNullParameter(m, "m");
        BLog.i(TAG, m);
    }
}