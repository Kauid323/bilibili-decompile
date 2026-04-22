package kntr.watch.later.watchlater.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: PlayTimeFormat.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a.\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"ONE_HOUR", "", "TEN_HOURS", "ONE_MINUTE", "formatDigits", "", "digits", "formatPlayTime", "time", "", "forceShowHour", "", "isShowZeroOfHour", "isShowZeroOfMinute", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlayTimeFormatKt {
    private static final int ONE_HOUR = 3600;
    private static final int ONE_MINUTE = 60;
    private static final int TEN_HOURS = 36000;

    private static final String formatDigits(int $this$formatDigits, int digits) {
        return StringsKt.padStart(String.valueOf($this$formatDigits), digits, '0');
    }

    public static /* synthetic */ String formatPlayTime$default(long j, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        return formatPlayTime(j, z, z2, z3);
    }

    public static final String formatPlayTime(long time, boolean forceShowHour, boolean isShowZeroOfHour, boolean isShowZeroOfMinute) {
        long totalSeconds = time / ((long) MediaAttrUtils.TYPE_PAY_SEASON);
        long j = (long) ONE_HOUR;
        int hours = (int) (totalSeconds / j);
        long j2 = 60;
        int minutes = (int) ((totalSeconds % j) / j2);
        int seconds = (int) (totalSeconds % j2);
        if (totalSeconds < 3600) {
            if (forceShowHour) {
                if (isShowZeroOfMinute) {
                    String formatTime = formatDigits(hours, 2) + ":" + formatDigits(minutes, 2) + ":" + formatDigits(seconds, 2);
                    return formatTime;
                }
                String formatTime2 = formatDigits(hours, 2) + ":" + minutes + ":" + formatDigits(seconds, 2);
                return formatTime2;
            } else if (isShowZeroOfMinute) {
                String formatTime3 = formatDigits(minutes, 2) + ":" + formatDigits(seconds, 2);
                return formatTime3;
            } else {
                String formatTime4 = minutes + ":" + formatDigits(seconds, 2);
                return formatTime4;
            }
        } else if (totalSeconds >= 3600 && totalSeconds < 36000) {
            if (isShowZeroOfHour) {
                String formatTime5 = formatDigits(hours, 2) + ":" + formatDigits(minutes, 2) + ":" + formatDigits(seconds, 2);
                return formatTime5;
            }
            String formatTime6 = formatDigits(hours, 1) + ":" + formatDigits(minutes, 2) + ":" + formatDigits(seconds, 2);
            return formatTime6;
        } else if (totalSeconds < 36000) {
            return "";
        } else {
            String formatTime7 = hours + ":" + formatDigits(minutes, 2) + ":" + formatDigits(seconds, 2);
            return formatTime7;
        }
    }
}