package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: NumberFormat.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a$\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a$\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a'\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\t\u001a'\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\n\u001a\"\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"NAN", "", "formatNumber", WatchLaterReporterKt.KEY_NUM, "", "defValue", "digits", "", "format", "(Ljava/lang/Long;Ljava/lang/String;I)Ljava/lang/String;", "(Ljava/lang/Integer;Ljava/lang/String;I)Ljava/lang/String;", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NumberFormat_androidKt {
    private static final String NAN = "-";

    public static final String format(Integer num) {
        return format$default(num, (String) null, 0, 3, (Object) null);
    }

    public static final String format(Integer num, String str) {
        Intrinsics.checkNotNullParameter(str, "defValue");
        return format$default(num, str, 0, 2, (Object) null);
    }

    public static final String format(Long l) {
        return format$default(l, (String) null, 0, 3, (Object) null);
    }

    public static final String format(Long l, String str) {
        Intrinsics.checkNotNullParameter(str, "defValue");
        return format$default(l, str, 0, 2, (Object) null);
    }

    public static final String format(String str) {
        return format$default(str, (String) null, 0, 3, (Object) null);
    }

    public static final String format(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "defValue");
        return format$default(str, str2, 0, 2, (Object) null);
    }

    public static final String formatNumber(int i) {
        return formatNumber$default(i, (String) null, 0, 6, (Object) null);
    }

    public static final String formatNumber(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "defValue");
        return formatNumber$default(i, str, 0, 4, (Object) null);
    }

    public static final String formatNumber(long j) {
        return formatNumber$default(j, (String) null, 0, 6, (Object) null);
    }

    public static final String formatNumber(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "defValue");
        return formatNumber$default(j, str, 0, 4, (Object) null);
    }

    public static /* synthetic */ String formatNumber$default(long j, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = NAN;
        }
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return formatNumber(j, str, i);
    }

    public static final String formatNumber(long num, String defValue, int digits) {
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        if (num > 0) {
            return NumberFormatKt.formatNumber(num, digits, true);
        }
        return defValue;
    }

    public static /* synthetic */ String formatNumber$default(int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = NAN;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        return formatNumber(i, str, i2);
    }

    public static final String formatNumber(int num, String defValue, int digits) {
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        if (num > 0) {
            return NumberFormatKt.formatNumber(num, digits, true);
        }
        return defValue;
    }

    public static /* synthetic */ String format$default(Long l, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = NAN;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return format(l, str, i);
    }

    public static final String format(Long $this$format, String defValue, int digits) {
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return formatNumber($this$format != null ? $this$format.longValue() : 0L, defValue, digits);
    }

    public static /* synthetic */ String format$default(Integer num, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = NAN;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return format(num, str, i);
    }

    public static final String format(Integer $this$format, String defValue, int digits) {
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return formatNumber($this$format != null ? $this$format.intValue() : 0, defValue, digits);
    }

    public static /* synthetic */ String format$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = NAN;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return format(str, str2, i);
    }

    public static final String format(String $this$format, String defValue, int digits) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        long num = ($this$format == null || (longOrNull = StringsKt.toLongOrNull($this$format)) == null) ? 0L : longOrNull.longValue();
        return format(Long.valueOf(num), defValue, digits);
    }
}