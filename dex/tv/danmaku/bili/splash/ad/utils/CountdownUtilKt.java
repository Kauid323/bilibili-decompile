package tv.danmaku.bili.splash.ad.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import bili.resource.common.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: CountdownUtil.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"getCountdownText", "", "context", "Landroid/content/Context;", "targetTime", "", "timeShowType", "", "timeStr", "", "getTimeStr", "(J)Ljava/lang/String;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CountdownUtilKt {
    public static final CharSequence getCountdownText(Context context, long targetTime, int timeShowType) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        long timeDiff = RangesKt.coerceAtLeast(targetTime - (System.currentTimeMillis() / 1000), 0L);
        long day = 0;
        long hour = 0;
        long minute = 0;
        long second = 0;
        if (timeDiff > 0) {
            long j = 86400;
            day = timeDiff / j;
            long timeDiff2 = timeDiff % j;
            long j2 = 3600;
            hour = timeDiff2 / j2;
            long timeDiff3 = timeDiff2 % j2;
            long j3 = 60;
            minute = timeDiff3 / j3;
            timeDiff = timeDiff3 % j3;
            second = timeDiff;
        }
        String str2 = "";
        if (timeShowType <= 3) {
            str2 = " " + getTimeStr(day) + context.getString(R.string.common_global_string_412);
        }
        if (timeShowType <= 2) {
            str2 = str2 + " " + getTimeStr(hour) + context.getString(R.string.common_global_string_413);
        }
        if (timeShowType <= 1) {
            str2 = str2 + " " + getTimeStr(minute) + context.getString(R.string.common_global_string_414);
        }
        if (timeShowType <= 0) {
            str2 = str2 + " " + getTimeStr(second) + context.getString(R.string.common_global_string_415);
        }
        SpannableStringBuilder builder = new SpannableStringBuilder(str2);
        int i = 0;
        StringsKt.append(builder, new CharSequence[0]);
        CharSequence $this$forEachIndexed$iv = str2;
        int index$iv = 0;
        while (i < $this$forEachIndexed$iv.length()) {
            char item$iv = $this$forEachIndexed$iv.charAt(i);
            int index$iv2 = index$iv + 1;
            if (Character.isDigit(item$iv)) {
                int index = index$iv;
                str = str2;
                builder.setSpan(new StyleSpan(1), index, index + 1, 33);
            } else {
                str = str2;
                int index2 = index$iv;
                if (CharsKt.isWhitespace(item$iv)) {
                    builder.setSpan(new AbsoluteSizeSpan(ListExtentionsKt.toPx(6)), index2, index2 + 1, 33);
                }
            }
            i++;
            index$iv = index$iv2;
            str2 = str;
        }
        return builder;
    }

    private static final String getTimeStr(long $this$timeStr) {
        boolean z = false;
        if (0 <= $this$timeStr && $this$timeStr < 10) {
            z = true;
        }
        return z ? "0" + $this$timeStr : String.valueOf($this$timeStr);
    }
}