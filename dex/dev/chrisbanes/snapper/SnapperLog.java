package dev.chrisbanes.snapper;

import com.tencent.matrix.report.Issue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapperLog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Ldev/chrisbanes/snapper/SnapperLog;", "", "()V", "d", "", Issue.ISSUE_REPORT_TAG, "", "message", "Lkotlin/Function0;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SnapperLog {
    public static final SnapperLog INSTANCE = new SnapperLog();

    private SnapperLog() {
    }

    public static /* synthetic */ void d$default(SnapperLog snapperLog, String tag, Function0 message, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            tag = "SnapperFlingBehavior";
        }
        Intrinsics.checkNotNullParameter(tag, Issue.ISSUE_REPORT_TAG);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public final void d(String tag, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(tag, Issue.ISSUE_REPORT_TAG);
        Intrinsics.checkNotNullParameter(function0, "message");
    }
}