package kntr.app.mall.product.details.page.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DateFormat.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a8\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0000\u001a$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000¨\u0006\u0019"}, d2 = {"getCurrentTimeMillis", "", "getCurrentTimeZoneString", "", "formatTimestamp", "timestamp", "byDay", "", "byMinute", "delimiter", "useTimeUnit", "formatPatternTimestamp", "timestampMillis", "pattern", "timeZone", "Lkotlinx/datetime/TimeZone;", "formatLocalDateTime", "localDateTime", "Lkotlinx/datetime/LocalDateTime;", "isToday", "isSameDay", "timestampMillis1", "timestampMillis2", "dayInterval", "", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateFormatKt {
    public static final long getCurrentTimeMillis() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public static final String getCurrentTimeZoneString() {
        TimeZone timeZone = TimeZone.Companion.currentSystemDefault();
        return timeZone.getId();
    }

    public static /* synthetic */ String formatTimestamp$default(long j, boolean z, boolean z2, String str, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            str = "-";
        }
        if ((i & 16) != 0) {
            z3 = false;
        }
        return formatTimestamp(j, z, z2, str, z3);
    }

    public static final String formatTimestamp(long timestamp, boolean byDay, boolean byMinute, String delimiter, boolean useTimeUnit) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Instant instant = Instant.Companion.fromEpochMilliseconds(timestamp);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        int millis = instant.getNanosecondsOfSecond() / 1000000;
        int year = localDateTime.getYear();
        String str = useTimeUnit ? "年" : delimiter;
        String padStart = StringsKt.padStart(String.valueOf(localDateTime.getMonthNumber()), 2, '0');
        String str2 = useTimeUnit ? "月" : delimiter;
        String padStart2 = StringsKt.padStart(String.valueOf(localDateTime.getDayOfMonth()), 2, '0');
        String str3 = "";
        if (!byDay) {
            String str4 = useTimeUnit ? "日" : " ";
            String padStart3 = StringsKt.padStart(String.valueOf(localDateTime.getHour()), 2, '0');
            String padStart4 = StringsKt.padStart(String.valueOf(localDateTime.getMinute()), 2, '0');
            if (!byMinute) {
                str3 = ":" + StringsKt.padStart(String.valueOf(localDateTime.getSecond()), 2, '0') + "." + StringsKt.padStart(String.valueOf(millis), 3, '0');
            }
            str3 = str4 + padStart3 + ":" + padStart4 + str3;
        }
        return year + str + padStart + str2 + padStart2 + str3;
    }

    public static /* synthetic */ String formatPatternTimestamp$default(long j, String str, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy-MM-dd HH:mm";
        }
        if ((i & 4) != 0) {
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return formatPatternTimestamp(j, str, timeZone);
    }

    public static final String formatPatternTimestamp(long timestampMillis, String pattern, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant instant = Instant.Companion.fromEpochMilliseconds(timestampMillis);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, timeZone);
        return formatLocalDateTime(localDateTime, pattern);
    }

    public static final String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        LocalDateTime.Companion companion = LocalDateTime.Companion;
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(pattern, "yyyy", String.valueOf(localDateTime.getYear()), false, 4, (Object) null), "MM", StringsKt.padStart(String.valueOf(localDateTime.getMonthNumber()), 2, '0'), false, 4, (Object) null), "dd", StringsKt.padStart(String.valueOf(localDateTime.getDayOfMonth()), 2, '0'), false, 4, (Object) null), "HH", StringsKt.padStart(String.valueOf(localDateTime.getHour()), 2, '0'), false, 4, (Object) null), "mm", StringsKt.padStart(String.valueOf(localDateTime.getMinute()), 2, '0'), false, 4, (Object) null), "ss", StringsKt.padStart(String.valueOf(localDateTime.getSecond()), 2, '0'), false, 4, (Object) null);
    }

    public static /* synthetic */ boolean isToday$default(long j, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return isToday(j, timeZone);
    }

    public static final boolean isToday(long timestampMillis, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant instant = Instant.Companion.fromEpochMilliseconds(timestampMillis);
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, timeZone);
        LocalDateTime now = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), timeZone);
        return localDateTime.getYear() == now.getYear() && localDateTime.getMonthNumber() == now.getMonthNumber() && localDateTime.getDayOfMonth() == now.getDayOfMonth();
    }

    public static /* synthetic */ boolean isSameDay$default(long j, long j2, TimeZone timeZone, int i, Object obj) {
        if ((i & 4) != 0) {
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return isSameDay(j, j2, timeZone);
    }

    public static final boolean isSameDay(long timestampMillis1, long timestampMillis2, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant instant1 = Instant.Companion.fromEpochMilliseconds(timestampMillis1);
        LocalDateTime localDateTime1 = TimeZoneKt.toLocalDateTime(instant1, timeZone);
        Instant instant2 = Instant.Companion.fromEpochMilliseconds(timestampMillis2);
        LocalDateTime localDateTime2 = TimeZoneKt.toLocalDateTime(instant2, timeZone);
        return localDateTime1.getYear() == localDateTime2.getYear() && localDateTime1.getMonthNumber() == localDateTime2.getMonthNumber() && localDateTime1.getDayOfMonth() == localDateTime2.getDayOfMonth();
    }

    public static /* synthetic */ int dayInterval$default(long j, long j2, TimeZone timeZone, int i, Object obj) {
        if ((i & 4) != 0) {
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return dayInterval(j, j2, timeZone);
    }

    public static final int dayInterval(long timestampMillis1, long timestampMillis2, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant instant1 = Instant.Companion.fromEpochMilliseconds(timestampMillis1);
        LocalDateTime localDateTime1 = TimeZoneKt.toLocalDateTime(instant1, timeZone);
        Instant instant2 = Instant.Companion.fromEpochMilliseconds(timestampMillis2);
        LocalDateTime localDateTime2 = TimeZoneKt.toLocalDateTime(instant2, timeZone);
        LocalDate date1 = new LocalDate(localDateTime1.getYear(), localDateTime1.getMonthNumber(), localDateTime1.getDayOfMonth());
        LocalDate date2 = new LocalDate(localDateTime2.getYear(), localDateTime2.getMonthNumber(), localDateTime2.getDayOfMonth());
        return LocalDateJvmKt.daysUntil(date1, date2);
    }
}