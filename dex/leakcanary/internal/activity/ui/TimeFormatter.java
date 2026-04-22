package leakcanary.internal.activity.ui;

import android.content.Context;
import android.text.format.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeFormatter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lleakcanary/internal/activity/ui/TimeFormatter;", "", "()V", "DAY_MILLIS", "", "FIFTY_MINUTES_MILLIS", "HOUR_MILLIS", "MINUTE_MILLIS", "NINETY_MINUTES_MILLIS", "TWO_DAYS_MILLIS", "TWO_MINUTES_MILLIS", "formatTimestamp", "", "context", "Landroid/content/Context;", "timestampMillis", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class TimeFormatter {
    private static final int DAY_MILLIS = 86400000;
    private static final int FIFTY_MINUTES_MILLIS = 3000000;
    private static final int HOUR_MILLIS = 3600000;
    public static final TimeFormatter INSTANCE = new TimeFormatter();
    private static final int MINUTE_MILLIS = 60000;
    private static final int NINETY_MINUTES_MILLIS = 5400000;
    private static final int TWO_DAYS_MILLIS = 172800000;
    private static final int TWO_MINUTES_MILLIS = 120000;

    private TimeFormatter() {
    }

    public final String formatTimestamp(Context context, long timestampMillis) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        long nowMillis = System.currentTimeMillis();
        long diff = nowMillis - timestampMillis;
        long j = (long) MINUTE_MILLIS;
        if (0 <= diff && j >= diff) {
            return "just now";
        }
        long j2 = (long) TWO_MINUTES_MILLIS;
        if (j <= diff && j2 >= diff) {
            return "a minute ago";
        }
        long j3 = (long) FIFTY_MINUTES_MILLIS;
        if (j2 <= diff && j3 >= diff) {
            return (diff / j) + " minutes ago";
        }
        long j4 = (long) NINETY_MINUTES_MILLIS;
        if (j3 <= diff && j4 >= diff) {
            return "an hour ago";
        }
        long j5 = 86400000;
        if (j4 <= diff && j5 >= diff) {
            return (diff / ((long) HOUR_MILLIS)) + " hours ago";
        }
        long j6 = (long) TWO_DAYS_MILLIS;
        if (j5 <= diff && j6 >= diff) {
            return "yesterday";
        }
        String formatDateTime = DateUtils.formatDateTime(context, timestampMillis, 17);
        Intrinsics.checkExpressionValueIsNotNull(formatDateTime, "DateUtils.formatDateTime…ORMAT_SHOW_DATE\n        )");
        return formatDateTime;
    }
}