package kntr.base.localization.preview;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.base.localization.preview.LegacyDateTimeFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.DayOfWeekNames;
import kotlinx.datetime.format.Padding;

/* compiled from: LegacyDateTimeFormat.kt */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b *\u0001 \bÇ\u0002\u0018\u00002\u00020\u0001:\u0012-./0123456789:;<=>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0006H\u0007J\n\u0010\b\u001a\u00020\u0005*\u00020\u0006J\f\u0010\t\u001a\u00020\u0005*\u00020\u0006H\u0007J\f\u0010\n\u001a\u00020\u0005*\u00020\u0006H\u0007J\f\u0010\u000b\u001a\u00020\u0005*\u00020\u0006H\u0007J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0013H\u0002J8\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0011\u001a\u00020\u0016H\u0002J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u001f\u001a\u00020 *\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0082\u0004¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0014\u0010$\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006?"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat;", "", "<init>", "()V", "formatRelativeDateTime", "", "", "formatAbsoluteDateTime", "formatIMDateTime", "formatRelativeDateTimeFromSeconds", "formatAbsoluteDateTimeFromSeconds", "formatIMDateTimeFromSeconds", "target", "Lkotlinx/datetime/Instant;", "current", "timeZone", "Lkotlinx/datetime/TimeZone;", "format", "Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "showThisWeek", "", "Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "SystemTimeZone", "getSystemTimeZone", "()Lkotlinx/datetime/TimeZone;", "TimeTolerance", "Lkotlin/time/Duration;", "J", "formatRelativePastDateTime", "formatRelativeFutureDateTime", "until", "kntr/base/localization/preview/LegacyDateTimeFormat$until$1", "other", "until-QTBD994", "(JJ)Lkntr/base/localization/preview/LegacyDateTimeFormat$until$1;", "DefaultRelativeDateTimeFormat", "getDefaultRelativeDateTimeFormat", "()Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "DefaultAbsoluteDateTimeFormat", "getDefaultAbsoluteDateTimeFormat", "()Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "DefaultImDateTimeFormat", "getDefaultImDateTimeFormat", "()Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "RelativeDateTimeFormat", "ChineseRelativeDateTimeFormat", "SimplifiedChineseRelativeDateTimeFormat", "TraditionalChineseRelativeDateTimeFormat", "JapaneseRelativeDateTimeFormat", "ThaiRelativeDateTimeFormat", "EnglishRelativeDateTimeFormat", "AbsoluteDateTimeFormat", "ChineseAbsoluteDateTimeFormat", "JapaneseAbsoluteDateTimeFormat", "ThaiAbsoluteDateTimeFormat", "EnglishAbsoluteDateTimeFormat", "IMDateTimeFormat", "ChineseIMDateTimeFormat", "EnglishIMDateTimeFormat", "TraditionalChineseIMDateTimeFormat", "JapaneseIMDateTimeFormat", "ThaiIMDateTimeFormat", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LegacyDateTimeFormat {
    public static final int $stable = 0;
    public static final LegacyDateTimeFormat INSTANCE = new LegacyDateTimeFormat();
    private static final long TimeTolerance;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "", "yearMonthDayHourMinute", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalDateTime;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface AbsoluteDateTimeFormat {
        Function1<LocalDateTime, String> getYearMonthDayHourMinute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001R-\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR-\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR-\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n\u0082\u0001\u0005\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "", "today", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalTime;", "Lkotlin/ParameterName;", "name", "time", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "Lkotlinx/datetime/LocalDateTime;", "getThisWeek", "past", "getPast", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$EnglishIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$JapaneseIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ThaiIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface IMDateTimeFormat {
        Function1<LocalDateTime, String> getPast();

        Function1<LocalDateTime, String> getThisWeek();

        Function1<LocalTime, String> getToday();

        Function1<LocalTime, String> getYesterday();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R-\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR-\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR-\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR-\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000eR\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000eR-\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR-\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000e\u0082\u0001\u0004&'()¨\u0006*À\u0006\u0003"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "yesterday", "Lkotlinx/datetime/LocalTime;", "time", "getYesterday", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "pastThisYear", "Lkotlinx/datetime/LocalDateTime;", "getPastThisYear", "past", "getPast", "toady", "getToady", "tomorrow", "getTomorrow", "futureThisYear", "getFutureThisYear", "future", "getFuture", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$EnglishRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ThaiRelativeDateTimeFormat;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface RelativeDateTimeFormat {
        Function1<DatePeriod, String> getDaysAgo();

        Function1<LocalDateTime, String> getFuture();

        Function1<LocalDateTime, String> getFutureThisYear();

        Function1<Duration, String> getHoursAgo();

        Function0<String> getJustNow();

        Function1<Duration, String> getMinutesAgo();

        Function1<LocalDateTime, String> getPast();

        Function1<LocalDateTime, String> getPastThisYear();

        Function1<LocalTime, String> getToady();

        Function1<LocalTime, String> getTomorrow();

        Function1<LocalTime, String> getYesterday();
    }

    private LegacyDateTimeFormat() {
    }

    public final String formatRelativeDateTime(long $this$formatRelativeDateTime) {
        return formatRelativeDateTime$default(this, Instant.Companion.fromEpochMilliseconds($this$formatRelativeDateTime), null, null, null, 14, null);
    }

    public final String formatAbsoluteDateTime(long $this$formatAbsoluteDateTime) {
        return formatAbsoluteDateTime$default(this, Instant.Companion.fromEpochMilliseconds($this$formatAbsoluteDateTime), null, null, 6, null);
    }

    public final String formatIMDateTime(long $this$formatIMDateTime) {
        return formatIMDateTime$default(this, Instant.Companion.fromEpochMilliseconds($this$formatIMDateTime), null, null, false, null, 30, null);
    }

    public final String formatRelativeDateTimeFromSeconds(long $this$formatRelativeDateTimeFromSeconds) {
        return formatRelativeDateTime$default(this, Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$formatRelativeDateTimeFromSeconds, 0L, 2, (Object) null), null, null, null, 14, null);
    }

    public final String formatAbsoluteDateTimeFromSeconds(long $this$formatAbsoluteDateTimeFromSeconds) {
        return formatAbsoluteDateTime$default(this, Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$formatAbsoluteDateTimeFromSeconds, 0L, 2, (Object) null), null, null, 6, null);
    }

    public final String formatIMDateTimeFromSeconds(long $this$formatIMDateTimeFromSeconds) {
        return formatIMDateTime$default(this, Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$formatIMDateTimeFromSeconds, 0L, 2, (Object) null), null, null, false, null, 30, null);
    }

    static /* synthetic */ String formatRelativeDateTime$default(LegacyDateTimeFormat legacyDateTimeFormat, Instant instant, Instant instant2, TimeZone timeZone, RelativeDateTimeFormat relativeDateTimeFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            instant2 = Clock.System.INSTANCE.now();
        }
        if ((i & 4) != 0) {
            timeZone = legacyDateTimeFormat.getSystemTimeZone();
        }
        if ((i & 8) != 0) {
            relativeDateTimeFormat = legacyDateTimeFormat.getDefaultRelativeDateTimeFormat();
        }
        return legacyDateTimeFormat.formatRelativeDateTime(instant, instant2, timeZone, relativeDateTimeFormat);
    }

    private final String formatRelativeDateTime(Instant target, Instant current, TimeZone timeZone, RelativeDateTimeFormat format) {
        if (current.plus-LRDsOJo(TimeTolerance).compareTo(target) >= 0) {
            return formatRelativePastDateTime(current, target, timeZone, format);
        }
        return formatRelativeFutureDateTime(current, target, timeZone, format);
    }

    static /* synthetic */ String formatAbsoluteDateTime$default(LegacyDateTimeFormat legacyDateTimeFormat, Instant instant, TimeZone timeZone, AbsoluteDateTimeFormat absoluteDateTimeFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = legacyDateTimeFormat.getSystemTimeZone();
        }
        if ((i & 4) != 0) {
            absoluteDateTimeFormat = legacyDateTimeFormat.getDefaultAbsoluteDateTimeFormat();
        }
        return legacyDateTimeFormat.formatAbsoluteDateTime(instant, timeZone, absoluteDateTimeFormat);
    }

    private final String formatAbsoluteDateTime(Instant target, TimeZone timeZone, AbsoluteDateTimeFormat format) {
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(target, timeZone);
        return (String) format.getYearMonthDayHourMinute().invoke(targetDateTime);
    }

    static /* synthetic */ String formatIMDateTime$default(LegacyDateTimeFormat legacyDateTimeFormat, Instant instant, Instant instant2, TimeZone timeZone, boolean z, IMDateTimeFormat iMDateTimeFormat, int i, Object obj) {
        return legacyDateTimeFormat.formatIMDateTime(instant, (i & 2) != 0 ? Clock.System.INSTANCE.now() : instant2, (i & 4) != 0 ? legacyDateTimeFormat.getSystemTimeZone() : timeZone, (i & 8) != 0 ? false : z, (i & 16) != 0 ? legacyDateTimeFormat.getDefaultImDateTimeFormat() : iMDateTimeFormat);
    }

    private final String formatIMDateTime(Instant target, Instant current, TimeZone timeZone, boolean showThisWeek, IMDateTimeFormat format) {
        LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(current, timeZone);
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(target, timeZone);
        Instant today = TimeZoneKt.atStartOfDayIn(currentDateTime.getDate(), timeZone);
        if (target.compareTo(current) >= 0) {
            return (String) format.getToday().invoke(currentDateTime.getTime());
        }
        if (Intrinsics.areEqual(targetDateTime.getDate(), currentDateTime.getDate())) {
            return (String) format.getToday().invoke(targetDateTime.getTime());
        }
        Duration.Companion companion = Duration.Companion;
        if (target.compareTo(today.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS))) >= 0) {
            return (String) format.getYesterday().invoke(targetDateTime.getTime());
        }
        if (showThisWeek) {
            Duration.Companion companion2 = Duration.Companion;
            if (target.compareTo(today.minus-LRDsOJo(DurationKt.toDuration(7, DurationUnit.DAYS))) >= 0) {
                return (String) format.getThisWeek().invoke(targetDateTime);
            }
        }
        return (String) format.getPast().invoke(targetDateTime);
    }

    private final TimeZone getSystemTimeZone() {
        return TimeZone.Companion.currentSystemDefault();
    }

    static {
        Duration.Companion companion = Duration.Companion;
        TimeTolerance = DurationKt.toDuration(10, DurationUnit.SECONDS);
    }

    private final String formatRelativePastDateTime(Instant current, Instant target, TimeZone timeZone, RelativeDateTimeFormat format) {
        long duration = current.minus-5sfh64U(target);
        long j = Duration.unaryMinus-UwyO8pc(TimeTolerance);
        Duration.Companion companion = Duration.Companion;
        if (m1642untilQTBD994(j, DurationKt.toDuration(1, DurationUnit.MINUTES)).contains(Duration.box-impl(duration))) {
            return (String) format.getJustNow().invoke();
        }
        Duration.Companion companion2 = Duration.Companion;
        long duration2 = DurationKt.toDuration(1, DurationUnit.MINUTES);
        Duration.Companion companion3 = Duration.Companion;
        if (m1642untilQTBD994(duration2, DurationKt.toDuration(1, DurationUnit.HOURS)).contains(Duration.box-impl(duration))) {
            return (String) format.getMinutesAgo().invoke(Duration.box-impl(duration));
        }
        Duration.Companion companion4 = Duration.Companion;
        long duration3 = DurationKt.toDuration(1, DurationUnit.HOURS);
        Duration.Companion companion5 = Duration.Companion;
        if (m1642untilQTBD994(duration3, DurationKt.toDuration(24, DurationUnit.HOURS)).contains(Duration.box-impl(duration))) {
            return (String) format.getHoursAgo().invoke(Duration.box-impl(duration));
        }
        LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(current, timeZone);
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(target, timeZone);
        Instant today = TimeZoneKt.atStartOfDayIn(currentDateTime.getDate(), timeZone);
        Duration.Companion companion6 = Duration.Companion;
        if (target.compareTo(today.minus-LRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS))) >= 0) {
            return (String) format.getYesterday().invoke(targetDateTime.getTime());
        }
        Duration.Companion companion7 = Duration.Companion;
        if (target.compareTo(today.minus-LRDsOJo(DurationKt.toDuration(3, DurationUnit.DAYS))) >= 0) {
            return (String) format.getDaysAgo().invoke(LocalDateKt.minus(currentDateTime.getDate(), targetDateTime.getDate()));
        }
        if (targetDateTime.getYear() == currentDateTime.getYear()) {
            return (String) format.getPastThisYear().invoke(targetDateTime);
        }
        return (String) format.getPast().invoke(targetDateTime);
    }

    private final String formatRelativeFutureDateTime(Instant current, Instant target, TimeZone timeZone, RelativeDateTimeFormat format) {
        LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(current, timeZone);
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(target, timeZone);
        if (Intrinsics.areEqual(targetDateTime.getDate(), currentDateTime.getDate())) {
            return (String) format.getToady().invoke(targetDateTime.getTime());
        }
        if (Intrinsics.areEqual(targetDateTime.getDate(), LocalDateJvmKt.plus(currentDateTime.getDate(), 1, DateTimeUnit.Companion.getDAY()))) {
            return (String) format.getTomorrow().invoke(targetDateTime.getTime());
        }
        return targetDateTime.getYear() == currentDateTime.getYear() ? (String) format.getFutureThisYear().invoke(targetDateTime) : (String) format.getFuture().invoke(targetDateTime);
    }

    /* renamed from: until-QTBD994  reason: not valid java name */
    private final LegacyDateTimeFormat$until$1 m1642untilQTBD994(long j, long j2) {
        return new LegacyDateTimeFormat$until$1(j, j2);
    }

    private final RelativeDateTimeFormat getDefaultRelativeDateTimeFormat() {
        Locale current = Localization.INSTANCE.getCurrent();
        return Intrinsics.areEqual(current, Locale.Companion.getTRADITIONAL_CHINESE()) ? TraditionalChineseRelativeDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getENGLISH()) ? EnglishRelativeDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getJAPANESE()) ? JapaneseRelativeDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getTHAI()) ? ThaiRelativeDateTimeFormat.INSTANCE : SimplifiedChineseRelativeDateTimeFormat.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R/\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R/\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R/\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019\u0082\u0001\u0002*+¨\u0006,"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yesterdayLocalTimeFormat", "pastThisYearLocalDateTimeFormat", "Lkotlinx/datetime/LocalDateTime;", "pastLocalDateTimeFormat", "todayLocalTimeFormat", "tomorrowLocalTimeFormat", "futureThisYearLocalDateTimeFormat", "futureLocalDateTimeFormat", "yesterday", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "time", "", "getYesterday", "()Lkotlin/jvm/functions/Function1;", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "pastThisYear", "getPastThisYear", "past", "getPast", "toady", "getToady", "tomorrow", "getTomorrow", "futureThisYear", "getFutureThisYear", "future", "getFuture", "Lkntr/base/localization/preview/LegacyDateTimeFormat$SimplifiedChineseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$TraditionalChineseRelativeDateTimeFormat;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static abstract class ChineseRelativeDateTimeFormat implements RelativeDateTimeFormat {
        private final Function1<DatePeriod, String> daysAgo;
        private final Function1<LocalDateTime, String> future;
        private final DateTimeFormat<LocalDateTime> futureLocalDateTimeFormat;
        private final Function1<LocalDateTime, String> futureThisYear;
        private final DateTimeFormat<LocalDateTime> futureThisYearLocalDateTimeFormat;
        private final DateTimeFormat<LocalTime> hourMinuteFormat;
        private final DateTimeFormat<LocalDate> monthDayFormat;
        private final Function1<LocalDateTime, String> past;
        private final DateTimeFormat<LocalDateTime> pastLocalDateTimeFormat;
        private final Function1<LocalDateTime, String> pastThisYear;
        private final DateTimeFormat<LocalDateTime> pastThisYearLocalDateTimeFormat;
        private final Function1<LocalTime, String> toady;
        private final DateTimeFormat<LocalTime> todayLocalTimeFormat;
        private final Function1<LocalTime, String> tomorrow;
        private final DateTimeFormat<LocalTime> tomorrowLocalTimeFormat;
        private final DateTimeFormat<LocalDate> yearMonthDayFormat;
        private final Function1<LocalTime, String> yesterday;
        private final DateTimeFormat<LocalTime> yesterdayLocalTimeFormat;

        public /* synthetic */ ChineseRelativeDateTimeFormat(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ChineseRelativeDateTimeFormat() {
            this.hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit hourMinuteFormat$lambda$0;
                    hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                    return hourMinuteFormat$lambda$0;
                }
            });
            this.monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda17
                public final Object invoke(Object obj) {
                    Unit monthDayFormat$lambda$0;
                    monthDayFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                    return monthDayFormat$lambda$0;
                }
            });
            this.yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit yearMonthDayFormat$lambda$0;
                    yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.yearMonthDayFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithDate) obj);
                    return yearMonthDayFormat$lambda$0;
                }
            });
            this.yesterdayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit yesterdayLocalTimeFormat$lambda$0;
                    yesterdayLocalTimeFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.yesterdayLocalTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithTime) obj);
                    return yesterdayLocalTimeFormat$lambda$0;
                }
            });
            this.pastThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit pastThisYearLocalDateTimeFormat$lambda$0;
                    pastThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.pastThisYearLocalDateTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithDateTime) obj);
                    return pastThisYearLocalDateTimeFormat$lambda$0;
                }
            });
            this.pastLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit pastLocalDateTimeFormat$lambda$0;
                    pastLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.pastLocalDateTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithDateTime) obj);
                    return pastLocalDateTimeFormat$lambda$0;
                }
            });
            this.todayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit unit;
                    unit = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.todayLocalTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithTime) obj);
                    return unit;
                }
            });
            this.tomorrowLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit unit;
                    unit = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.tomorrowLocalTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithTime) obj);
                    return unit;
                }
            });
            this.futureThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit futureThisYearLocalDateTimeFormat$lambda$0;
                    futureThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.futureThisYearLocalDateTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithDateTime) obj);
                    return futureThisYearLocalDateTimeFormat$lambda$0;
                }
            });
            this.futureLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda8
                public final Object invoke(Object obj) {
                    Unit futureLocalDateTimeFormat$lambda$0;
                    futureLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.futureLocalDateTimeFormat$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (DateTimeFormatBuilder.WithDateTime) obj);
                    return futureLocalDateTimeFormat$lambda$0;
                }
            });
            this.yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    String yesterday$lambda$0;
                    yesterday$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.yesterday$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalTime) obj);
                    return yesterday$lambda$0;
                }
            };
            this.daysAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    String daysAgo$lambda$0;
                    daysAgo$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.daysAgo$lambda$0((DatePeriod) obj);
                    return daysAgo$lambda$0;
                }
            };
            this.pastThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    String pastThisYear$lambda$0;
                    pastThisYear$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.pastThisYear$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalDateTime) obj);
                    return pastThisYear$lambda$0;
                }
            };
            this.past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    String past$lambda$0;
                    past$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.past$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalDateTime) obj);
                    return past$lambda$0;
                }
            };
            this.toady = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda13
                public final Object invoke(Object obj) {
                    String str;
                    str = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.toady$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalTime) obj);
                    return str;
                }
            };
            this.tomorrow = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda14
                public final Object invoke(Object obj) {
                    String str;
                    str = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.tomorrow$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalTime) obj);
                    return str;
                }
            };
            this.futureThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda15
                public final Object invoke(Object obj) {
                    String futureThisYear$lambda$0;
                    futureThisYear$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.futureThisYear$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalDateTime) obj);
                    return futureThisYear$lambda$0;
                }
            };
            this.future = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseRelativeDateTimeFormat$$ExternalSyntheticLambda16
                public final Object invoke(Object obj) {
                    String future$lambda$0;
                    future$lambda$0 = LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.future$lambda$0(LegacyDateTimeFormat.ChineseRelativeDateTimeFormat.this, (LocalDateTime) obj);
                    return future$lambda$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("月");
            $this$Format.dayOfMonth(Padding.NONE);
            $this$Format.chars("日");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("年");
            $this$Format.date(this$0.monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayLocalTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("昨天");
            $this$Format.chars(" ");
            $this$Format.time(this$0.hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastThisYearLocalDateTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(this$0.monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastLocalDateTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(this$0.yearMonthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit todayLocalTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("今天");
            $this$Format.chars(" ");
            $this$Format.time(this$0.hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit tomorrowLocalTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("明天");
            $this$Format.chars(" ");
            $this$Format.time(this$0.hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureThisYearLocalDateTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(this$0.monthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(this$0.hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureLocalDateTimeFormat$lambda$0(ChineseRelativeDateTimeFormat this$0, DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(this$0.yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(this$0.hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return this.yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.yesterdayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<DatePeriod, String> getDaysAgo() {
            return this.daysAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String daysAgo$lambda$0(DatePeriod it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getDays() + "天前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPastThisYear() {
            return this.pastThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String pastThisYear$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.pastThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return this.past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.pastLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getToady() {
            return this.toady;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String toady$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.todayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getTomorrow() {
            return this.tomorrow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String tomorrow$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.tomorrowLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFutureThisYear() {
            return this.futureThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String futureThisYear$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.futureThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFuture() {
            return this.future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String future$lambda$0(ChineseRelativeDateTimeFormat this$0, LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this$0.futureLocalDateTimeFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR/\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$SimplifiedChineseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseRelativeDateTimeFormat;", "<init>", "()V", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SimplifiedChineseRelativeDateTimeFormat extends ChineseRelativeDateTimeFormat {
        public static final SimplifiedChineseRelativeDateTimeFormat INSTANCE = new SimplifiedChineseRelativeDateTimeFormat();
        private static final Function0<String> justNow = new Function0() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$SimplifiedChineseRelativeDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke() {
                String justNow$lambda$0;
                justNow$lambda$0 = LegacyDateTimeFormat.SimplifiedChineseRelativeDateTimeFormat.justNow$lambda$0();
                return justNow$lambda$0;
            }
        };
        private static final Function1<Duration, String> minutesAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$SimplifiedChineseRelativeDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String minutesAgo$lambda$0;
                minutesAgo$lambda$0 = LegacyDateTimeFormat.SimplifiedChineseRelativeDateTimeFormat.minutesAgo$lambda$0((Duration) obj);
                return minutesAgo$lambda$0;
            }
        };
        private static final Function1<Duration, String> hoursAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$SimplifiedChineseRelativeDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                String hoursAgo$lambda$0;
                hoursAgo$lambda$0 = LegacyDateTimeFormat.SimplifiedChineseRelativeDateTimeFormat.hoursAgo$lambda$0((Duration) obj);
                return hoursAgo$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SimplifiedChineseRelativeDateTimeFormat) {
                SimplifiedChineseRelativeDateTimeFormat simplifiedChineseRelativeDateTimeFormat = (SimplifiedChineseRelativeDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1021992693;
        }

        public String toString() {
            return "SimplifiedChineseRelativeDateTimeFormat";
        }

        private SimplifiedChineseRelativeDateTimeFormat() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String justNow$lambda$0() {
            return "刚刚";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function0<String> getJustNow() {
            return justNow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String minutesAgo$lambda$0(Duration it) {
            return Duration.getInWholeMinutes-impl(it.unbox-impl()) + "分钟前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getMinutesAgo() {
            return minutesAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String hoursAgo$lambda$0(Duration it) {
            return Duration.getInWholeHours-impl(it.unbox-impl()) + "小时前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getHoursAgo() {
            return hoursAgo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR/\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$TraditionalChineseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseRelativeDateTimeFormat;", "<init>", "()V", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TraditionalChineseRelativeDateTimeFormat extends ChineseRelativeDateTimeFormat {
        public static final TraditionalChineseRelativeDateTimeFormat INSTANCE = new TraditionalChineseRelativeDateTimeFormat();
        private static final Function0<String> justNow = new Function0() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseRelativeDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke() {
                String justNow$lambda$0;
                justNow$lambda$0 = LegacyDateTimeFormat.TraditionalChineseRelativeDateTimeFormat.justNow$lambda$0();
                return justNow$lambda$0;
            }
        };
        private static final Function1<Duration, String> minutesAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseRelativeDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String minutesAgo$lambda$0;
                minutesAgo$lambda$0 = LegacyDateTimeFormat.TraditionalChineseRelativeDateTimeFormat.minutesAgo$lambda$0((Duration) obj);
                return minutesAgo$lambda$0;
            }
        };
        private static final Function1<Duration, String> hoursAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseRelativeDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                String hoursAgo$lambda$0;
                hoursAgo$lambda$0 = LegacyDateTimeFormat.TraditionalChineseRelativeDateTimeFormat.hoursAgo$lambda$0((Duration) obj);
                return hoursAgo$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TraditionalChineseRelativeDateTimeFormat) {
                TraditionalChineseRelativeDateTimeFormat traditionalChineseRelativeDateTimeFormat = (TraditionalChineseRelativeDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1539086956;
        }

        public String toString() {
            return "TraditionalChineseRelativeDateTimeFormat";
        }

        private TraditionalChineseRelativeDateTimeFormat() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String justNow$lambda$0() {
            return "剛剛";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function0<String> getJustNow() {
            return justNow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String minutesAgo$lambda$0(Duration it) {
            return Duration.getInWholeMinutes-impl(it.unbox-impl()) + "分鐘前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getMinutesAgo() {
            return minutesAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String hoursAgo$lambda$0(Duration it) {
            return Duration.getInWholeHours-impl(it.unbox-impl()) + "小時前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getHoursAgo() {
            return hoursAgo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R/\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR/\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR/\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR/\u0010$\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR/\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR/\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR \u00100\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR \u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001e¨\u0006;"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yesterdayLocalTimeFormat", "pastThisYearLocalDateTimeFormat", "Lkotlinx/datetime/LocalDateTime;", "pastLocalDateTimeFormat", "todayLocalTimeFormat", "tomorrowLocalTimeFormat", "futureThisYearLocalDateTimeFormat", "futureLocalDateTimeFormat", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "yesterday", "time", "getYesterday", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "pastThisYear", "getPastThisYear", "past", "getPast", "toady", "getToady", "tomorrow", "getTomorrow", "futureThisYear", "getFutureThisYear", "future", "getFuture", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class JapaneseRelativeDateTimeFormat implements RelativeDateTimeFormat {
        public static final JapaneseRelativeDateTimeFormat INSTANCE = new JapaneseRelativeDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> yesterdayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit yesterdayLocalTimeFormat$lambda$0;
                yesterdayLocalTimeFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.yesterdayLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayLocalTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit pastThisYearLocalDateTimeFormat$lambda$0;
                pastThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.pastThisYearLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastThisYearLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit pastLocalDateTimeFormat$lambda$0;
                pastLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.pastLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit unit;
                unit = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.todayLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return unit;
            }
        });
        private static final DateTimeFormat<LocalTime> tomorrowLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit unit;
                unit = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.tomorrowLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return unit;
            }
        });
        private static final DateTimeFormat<LocalDateTime> futureThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit futureThisYearLocalDateTimeFormat$lambda$0;
                futureThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.futureThisYearLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return futureThisYearLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> futureLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit futureLocalDateTimeFormat$lambda$0;
                futureLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.futureLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return futureLocalDateTimeFormat$lambda$0;
            }
        });
        private static final Function0<String> justNow = new Function0() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda11
            public final Object invoke() {
                String justNow$lambda$0;
                justNow$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.justNow$lambda$0();
                return justNow$lambda$0;
            }
        };
        private static final Function1<Duration, String> minutesAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                String minutesAgo$lambda$0;
                minutesAgo$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.minutesAgo$lambda$0((Duration) obj);
                return minutesAgo$lambda$0;
            }
        };
        private static final Function1<Duration, String> hoursAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                String hoursAgo$lambda$0;
                hoursAgo$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.hoursAgo$lambda$0((Duration) obj);
                return hoursAgo$lambda$0;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<DatePeriod, String> daysAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                String daysAgo$lambda$0;
                daysAgo$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.daysAgo$lambda$0((DatePeriod) obj);
                return daysAgo$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> pastThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                String pastThisYear$lambda$0;
                pastThisYear$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.pastThisYear$lambda$0((LocalDateTime) obj);
                return pastThisYear$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };
        private static final Function1<LocalTime, String> toady = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.toady$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> tomorrow = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.tomorrow$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalDateTime, String> futureThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String futureThisYear$lambda$0;
                futureThisYear$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.futureThisYear$lambda$0((LocalDateTime) obj);
                return futureThisYear$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> future = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseRelativeDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                String future$lambda$0;
                future$lambda$0 = LegacyDateTimeFormat.JapaneseRelativeDateTimeFormat.future$lambda$0((LocalDateTime) obj);
                return future$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof JapaneseRelativeDateTimeFormat) {
                JapaneseRelativeDateTimeFormat japaneseRelativeDateTimeFormat = (JapaneseRelativeDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1536765801;
        }

        public String toString() {
            return "JapaneseRelativeDateTimeFormat";
        }

        private JapaneseRelativeDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("月");
            $this$Format.dayOfMonth(Padding.NONE);
            $this$Format.chars("日");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("年");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("昨日");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastThisYearLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit todayLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("今日");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit tomorrowLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("明日");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureThisYearLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(monthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String justNow$lambda$0() {
            return "たった今";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function0<String> getJustNow() {
            return justNow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String minutesAgo$lambda$0(Duration it) {
            return Duration.getInWholeMinutes-impl(it.unbox-impl()) + "分前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getMinutesAgo() {
            return minutesAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String hoursAgo$lambda$0(Duration it) {
            return Duration.getInWholeHours-impl(it.unbox-impl()) + "時間前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getHoursAgo() {
            return hoursAgo;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<DatePeriod, String> getDaysAgo() {
            return daysAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String daysAgo$lambda$0(DatePeriod it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getDays() + "日前";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPastThisYear() {
            return pastThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String pastThisYear$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getToady() {
            return toady;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String toady$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getTomorrow() {
            return tomorrow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String tomorrow$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return tomorrowLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFutureThisYear() {
            return futureThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String futureThisYear$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return futureThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFuture() {
            return future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String future$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return futureLocalDateTimeFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R/\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR/\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR/\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR/\u0010$\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR/\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR/\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR \u00100\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR \u00102\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001e¨\u0006;"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$ThaiRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yesterdayLocalTimeFormat", "pastThisYearLocalDateTimeFormat", "Lkotlinx/datetime/LocalDateTime;", "pastLocalDateTimeFormat", "todayLocalTimeFormat", "tomorrowLocalTimeFormat", "futureThisYearLocalDateTimeFormat", "futureLocalDateTimeFormat", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "yesterday", "time", "getYesterday", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "pastThisYear", "getPastThisYear", "past", "getPast", "toady", "getToady", "tomorrow", "getTomorrow", "futureThisYear", "getFutureThisYear", "future", "getFuture", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ThaiRelativeDateTimeFormat implements RelativeDateTimeFormat {
        public static final ThaiRelativeDateTimeFormat INSTANCE = new ThaiRelativeDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> yesterdayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit yesterdayLocalTimeFormat$lambda$0;
                yesterdayLocalTimeFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.yesterdayLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayLocalTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit pastThisYearLocalDateTimeFormat$lambda$0;
                pastThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.pastThisYearLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastThisYearLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit pastLocalDateTimeFormat$lambda$0;
                pastLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.pastLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit unit;
                unit = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.todayLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return unit;
            }
        });
        private static final DateTimeFormat<LocalTime> tomorrowLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit unit;
                unit = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.tomorrowLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return unit;
            }
        });
        private static final DateTimeFormat<LocalDateTime> futureThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit futureThisYearLocalDateTimeFormat$lambda$0;
                futureThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.futureThisYearLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return futureThisYearLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> futureLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit futureLocalDateTimeFormat$lambda$0;
                futureLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.futureLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return futureLocalDateTimeFormat$lambda$0;
            }
        });
        private static final Function0<String> justNow = new Function0() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda11
            public final Object invoke() {
                String justNow$lambda$0;
                justNow$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.justNow$lambda$0();
                return justNow$lambda$0;
            }
        };
        private static final Function1<Duration, String> minutesAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                String minutesAgo$lambda$0;
                minutesAgo$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.minutesAgo$lambda$0((Duration) obj);
                return minutesAgo$lambda$0;
            }
        };
        private static final Function1<Duration, String> hoursAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                String hoursAgo$lambda$0;
                hoursAgo$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.hoursAgo$lambda$0((Duration) obj);
                return hoursAgo$lambda$0;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<DatePeriod, String> daysAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                String daysAgo$lambda$0;
                daysAgo$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.daysAgo$lambda$0((DatePeriod) obj);
                return daysAgo$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> pastThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                String pastThisYear$lambda$0;
                pastThisYear$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.pastThisYear$lambda$0((LocalDateTime) obj);
                return pastThisYear$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };
        private static final Function1<LocalTime, String> toady = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.toady$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> tomorrow = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.tomorrow$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalDateTime, String> futureThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String futureThisYear$lambda$0;
                futureThisYear$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.futureThisYear$lambda$0((LocalDateTime) obj);
                return futureThisYear$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> future = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiRelativeDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                String future$lambda$0;
                future$lambda$0 = LegacyDateTimeFormat.ThaiRelativeDateTimeFormat.future$lambda$0((LocalDateTime) obj);
                return future$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThaiRelativeDateTimeFormat) {
                ThaiRelativeDateTimeFormat thaiRelativeDateTimeFormat = (ThaiRelativeDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 70656066;
        }

        public String toString() {
            return "ThaiRelativeDateTimeFormat";
        }

        private ThaiRelativeDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("เมื่อวาน");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastThisYearLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit todayLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("วันนี้");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit tomorrowLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("พรุ่งนี้");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureThisYearLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(monthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String justNow$lambda$0() {
            return "เมื่อกี้";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function0<String> getJustNow() {
            return justNow;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getMinutesAgo() {
            return minutesAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String minutesAgo$lambda$0(Duration it) {
            return Duration.getInWholeMinutes-impl(it.unbox-impl()) + " นาทีก่อน";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String hoursAgo$lambda$0(Duration it) {
            return Duration.getInWholeHours-impl(it.unbox-impl()) + " ชั่วโมงก่อน";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getHoursAgo() {
            return hoursAgo;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<DatePeriod, String> getDaysAgo() {
            return daysAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String daysAgo$lambda$0(DatePeriod it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getDays() + " วันก่อน";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPastThisYear() {
            return pastThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String pastThisYear$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getToady() {
            return toady;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String toady$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getTomorrow() {
            return tomorrow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String tomorrow$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return tomorrowLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFutureThisYear() {
            return futureThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String futureThisYear$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return futureThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFuture() {
            return future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String future$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return futureLocalDateTimeFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0015H\u0002J\u0013\u00108\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0015HÖ\u0001J\t\u0010<\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR/\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R/\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R/\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R/\u0010(\u001a\u001d\u0012\u0013\u0012\u00110)¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R/\u00100\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R/\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"¨\u0006="}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$EnglishRelativeDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$RelativeDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yesterdayLocalTimeFormat", "pastThisYearLocalDateTimeFormat", "Lkotlinx/datetime/LocalDateTime;", "pastLocalDateTimeFormat", "todayLocalTimeFormat", "tomorrowLocalTimeFormat", "futureThisYearLocalDateTimeFormat", "futureLocalDateTimeFormat", "isPlural", "", "", "", "justNow", "Lkotlin/Function0;", "", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lkotlin/ParameterName;", "name", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "yesterday", "time", "getYesterday", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "pastThisYear", "getPastThisYear", "past", "getPast", "toady", "getToady", "tomorrow", "getTomorrow", "futureThisYear", "getFutureThisYear", "future", "getFuture", "equals", "other", "", "hashCode", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EnglishRelativeDateTimeFormat implements RelativeDateTimeFormat {
        public static final EnglishRelativeDateTimeFormat INSTANCE = new EnglishRelativeDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> yesterdayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit yesterdayLocalTimeFormat$lambda$0;
                yesterdayLocalTimeFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.yesterdayLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayLocalTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit pastThisYearLocalDateTimeFormat$lambda$0;
                pastThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.pastThisYearLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastThisYearLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit pastLocalDateTimeFormat$lambda$0;
                pastLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.pastLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit unit;
                unit = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.todayLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return unit;
            }
        });
        private static final DateTimeFormat<LocalTime> tomorrowLocalTimeFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit unit;
                unit = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.tomorrowLocalTimeFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return unit;
            }
        });
        private static final DateTimeFormat<LocalDateTime> futureThisYearLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit futureThisYearLocalDateTimeFormat$lambda$0;
                futureThisYearLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.futureThisYearLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return futureThisYearLocalDateTimeFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> futureLocalDateTimeFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                Unit futureLocalDateTimeFormat$lambda$0;
                futureLocalDateTimeFormat$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.futureLocalDateTimeFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return futureLocalDateTimeFormat$lambda$0;
            }
        });
        private static final Function0<String> justNow = new Function0() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda11
            public final Object invoke() {
                String justNow$lambda$0;
                justNow$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.justNow$lambda$0();
                return justNow$lambda$0;
            }
        };
        private static final Function1<Duration, String> minutesAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                String minutesAgo$lambda$0;
                minutesAgo$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.minutesAgo$lambda$0((Duration) obj);
                return minutesAgo$lambda$0;
            }
        };
        private static final Function1<Duration, String> hoursAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                String hoursAgo$lambda$0;
                hoursAgo$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.hoursAgo$lambda$0((Duration) obj);
                return hoursAgo$lambda$0;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<DatePeriod, String> daysAgo = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                String daysAgo$lambda$0;
                daysAgo$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.daysAgo$lambda$0((DatePeriod) obj);
                return daysAgo$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> pastThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                String pastThisYear$lambda$0;
                pastThisYear$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.pastThisYear$lambda$0((LocalDateTime) obj);
                return pastThisYear$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };
        private static final Function1<LocalTime, String> toady = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.toady$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> tomorrow = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.tomorrow$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalDateTime, String> futureThisYear = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String futureThisYear$lambda$0;
                futureThisYear$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.futureThisYear$lambda$0((LocalDateTime) obj);
                return futureThisYear$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> future = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishRelativeDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                String future$lambda$0;
                future$lambda$0 = LegacyDateTimeFormat.EnglishRelativeDateTimeFormat.future$lambda$0((LocalDateTime) obj);
                return future$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnglishRelativeDateTimeFormat) {
                EnglishRelativeDateTimeFormat englishRelativeDateTimeFormat = (EnglishRelativeDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -937031482;
        }

        public String toString() {
            return "EnglishRelativeDateTimeFormat";
        }

        private EnglishRelativeDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("Yesterday");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastThisYearLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit todayLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("Today");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit tomorrowLocalTimeFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("Tomorrow");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureThisYearLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(monthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit futureLocalDateTimeFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        private final boolean isPlural(long $this$isPlural) {
            return $this$isPlural != 1;
        }

        private final boolean isPlural(int $this$isPlural) {
            return $this$isPlural != 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String justNow$lambda$0() {
            return "Just now";
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function0<String> getJustNow() {
            return justNow;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getMinutesAgo() {
            return minutesAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String minutesAgo$lambda$0(Duration duration) {
            StringBuilder append;
            String str;
            long it = Duration.getInWholeMinutes-impl(duration.unbox-impl());
            if (INSTANCE.isPlural(it)) {
                append = new StringBuilder().append(it);
                str = " mins ago";
            } else {
                append = new StringBuilder().append(it);
                str = " min ago";
            }
            return append.append(str).toString();
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<Duration, String> getHoursAgo() {
            return hoursAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String hoursAgo$lambda$0(Duration duration) {
            StringBuilder append;
            String str;
            long it = Duration.getInWholeHours-impl(duration.unbox-impl());
            if (INSTANCE.isPlural(it)) {
                append = new StringBuilder().append(it);
                str = " hrs ago";
            } else {
                append = new StringBuilder().append(it);
                str = " hr ago";
            }
            return append.append(str).toString();
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<DatePeriod, String> getDaysAgo() {
            return daysAgo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String daysAgo$lambda$0(DatePeriod period) {
            StringBuilder append;
            String str;
            Intrinsics.checkNotNullParameter(period, "period");
            int it = period.getDays();
            if (INSTANCE.isPlural(it)) {
                append = new StringBuilder().append(it);
                str = " days ago";
            } else {
                append = new StringBuilder().append(it);
                str = " day ago";
            }
            return append.append(str).toString();
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPastThisYear() {
            return pastThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String pastThisYear$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getToady() {
            return toady;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String toady$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalTime, String> getTomorrow() {
            return tomorrow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String tomorrow$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return tomorrowLocalTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFutureThisYear() {
            return futureThisYear;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String futureThisYear$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return futureThisYearLocalDateTimeFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.RelativeDateTimeFormat
        public Function1<LocalDateTime, String> getFuture() {
            return future;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String future$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return futureLocalDateTimeFormat.format(it);
        }
    }

    private final AbsoluteDateTimeFormat getDefaultAbsoluteDateTimeFormat() {
        Locale current = Localization.INSTANCE.getCurrent();
        return Intrinsics.areEqual(current, Locale.Companion.getENGLISH()) ? EnglishAbsoluteDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getJAPANESE()) ? JapaneseAbsoluteDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getTHAI()) ? ThaiAbsoluteDateTimeFormat.INSTANCE : ChineseAbsoluteDateTimeFormat.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yearMonthDayHourMinuteFormat", "Lkotlinx/datetime/LocalDateTime;", "yearMonthDayHourMinute", "Lkotlin/Function1;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ChineseAbsoluteDateTimeFormat implements AbsoluteDateTimeFormat {
        public static final ChineseAbsoluteDateTimeFormat INSTANCE = new ChineseAbsoluteDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ChineseAbsoluteDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.ChineseAbsoluteDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.ChineseAbsoluteDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> yearMonthDayHourMinuteFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yearMonthDayHourMinuteFormat$lambda$0;
                yearMonthDayHourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ChineseAbsoluteDateTimeFormat.yearMonthDayHourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return yearMonthDayHourMinuteFormat$lambda$0;
            }
        });
        private static final Function1<LocalDateTime, String> yearMonthDayHourMinute = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseAbsoluteDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                String yearMonthDayHourMinute$lambda$0;
                yearMonthDayHourMinute$lambda$0 = LegacyDateTimeFormat.ChineseAbsoluteDateTimeFormat.yearMonthDayHourMinute$lambda$0((LocalDateTime) obj);
                return yearMonthDayHourMinute$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChineseAbsoluteDateTimeFormat) {
                ChineseAbsoluteDateTimeFormat chineseAbsoluteDateTimeFormat = (ChineseAbsoluteDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1208719634;
        }

        public String toString() {
            return "ChineseAbsoluteDateTimeFormat";
        }

        private ChineseAbsoluteDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("月");
            $this$Format.dayOfMonth(Padding.NONE);
            $this$Format.chars("日");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("年");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayHourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.AbsoluteDateTimeFormat
        public Function1<LocalDateTime, String> getYearMonthDayHourMinute() {
            return yearMonthDayHourMinute;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yearMonthDayHourMinute$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yearMonthDayHourMinuteFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yearMonthDayHourMinuteFormat", "Lkotlinx/datetime/LocalDateTime;", "yearMonthDayHourMinute", "Lkotlin/Function1;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class JapaneseAbsoluteDateTimeFormat implements AbsoluteDateTimeFormat {
        public static final JapaneseAbsoluteDateTimeFormat INSTANCE = new JapaneseAbsoluteDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.JapaneseAbsoluteDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseAbsoluteDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseAbsoluteDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> yearMonthDayHourMinuteFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yearMonthDayHourMinuteFormat$lambda$0;
                yearMonthDayHourMinuteFormat$lambda$0 = LegacyDateTimeFormat.JapaneseAbsoluteDateTimeFormat.yearMonthDayHourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return yearMonthDayHourMinuteFormat$lambda$0;
            }
        });
        private static final Function1<LocalDateTime, String> yearMonthDayHourMinute = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseAbsoluteDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                String yearMonthDayHourMinute$lambda$0;
                yearMonthDayHourMinute$lambda$0 = LegacyDateTimeFormat.JapaneseAbsoluteDateTimeFormat.yearMonthDayHourMinute$lambda$0((LocalDateTime) obj);
                return yearMonthDayHourMinute$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof JapaneseAbsoluteDateTimeFormat) {
                JapaneseAbsoluteDateTimeFormat japaneseAbsoluteDateTimeFormat = (JapaneseAbsoluteDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 79453186;
        }

        public String toString() {
            return "JapaneseAbsoluteDateTimeFormat";
        }

        private JapaneseAbsoluteDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("月");
            $this$Format.dayOfMonth(Padding.NONE);
            $this$Format.chars("日");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("年");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayHourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.AbsoluteDateTimeFormat
        public Function1<LocalDateTime, String> getYearMonthDayHourMinute() {
            return yearMonthDayHourMinute;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yearMonthDayHourMinute$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yearMonthDayHourMinuteFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yearMonthDayHourMinuteFormat", "Lkotlinx/datetime/LocalDateTime;", "yearMonthDayHourMinute", "Lkotlin/Function1;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ThaiAbsoluteDateTimeFormat implements AbsoluteDateTimeFormat {
        public static final ThaiAbsoluteDateTimeFormat INSTANCE = new ThaiAbsoluteDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ThaiAbsoluteDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.ThaiAbsoluteDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.ThaiAbsoluteDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> yearMonthDayHourMinuteFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yearMonthDayHourMinuteFormat$lambda$0;
                yearMonthDayHourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ThaiAbsoluteDateTimeFormat.yearMonthDayHourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return yearMonthDayHourMinuteFormat$lambda$0;
            }
        });
        private static final Function1<LocalDateTime, String> yearMonthDayHourMinute = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiAbsoluteDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                String yearMonthDayHourMinute$lambda$0;
                yearMonthDayHourMinute$lambda$0 = LegacyDateTimeFormat.ThaiAbsoluteDateTimeFormat.yearMonthDayHourMinute$lambda$0((LocalDateTime) obj);
                return yearMonthDayHourMinute$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThaiAbsoluteDateTimeFormat) {
                ThaiAbsoluteDateTimeFormat thaiAbsoluteDateTimeFormat = (ThaiAbsoluteDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1686875053;
        }

        public String toString() {
            return "ThaiAbsoluteDateTimeFormat";
        }

        private ThaiAbsoluteDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayHourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.AbsoluteDateTimeFormat
        public Function1<LocalDateTime, String> getYearMonthDayHourMinute() {
            return yearMonthDayHourMinute;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yearMonthDayHourMinute$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yearMonthDayHourMinuteFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$AbsoluteDateTimeFormat;", "<init>", "()V", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "yearMonthDayHourMinuteFormat", "Lkotlinx/datetime/LocalDateTime;", "yearMonthDayHourMinute", "Lkotlin/Function1;", "", "getYearMonthDayHourMinute", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EnglishAbsoluteDateTimeFormat implements AbsoluteDateTimeFormat {
        public static final EnglishAbsoluteDateTimeFormat INSTANCE = new EnglishAbsoluteDateTimeFormat();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.EnglishAbsoluteDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.EnglishAbsoluteDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.EnglishAbsoluteDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> yearMonthDayHourMinuteFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yearMonthDayHourMinuteFormat$lambda$0;
                yearMonthDayHourMinuteFormat$lambda$0 = LegacyDateTimeFormat.EnglishAbsoluteDateTimeFormat.yearMonthDayHourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return yearMonthDayHourMinuteFormat$lambda$0;
            }
        });
        private static final Function1<LocalDateTime, String> yearMonthDayHourMinute = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishAbsoluteDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                String yearMonthDayHourMinute$lambda$0;
                yearMonthDayHourMinute$lambda$0 = LegacyDateTimeFormat.EnglishAbsoluteDateTimeFormat.yearMonthDayHourMinute$lambda$0((LocalDateTime) obj);
                return yearMonthDayHourMinute$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnglishAbsoluteDateTimeFormat) {
                EnglishAbsoluteDateTimeFormat englishAbsoluteDateTimeFormat = (EnglishAbsoluteDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 679187505;
        }

        public String toString() {
            return "EnglishAbsoluteDateTimeFormat";
        }

        private EnglishAbsoluteDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayHourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.AbsoluteDateTimeFormat
        public Function1<LocalDateTime, String> getYearMonthDayHourMinute() {
            return yearMonthDayHourMinute;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yearMonthDayHourMinute$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yearMonthDayHourMinuteFormat.format(it);
        }
    }

    private final IMDateTimeFormat getDefaultImDateTimeFormat() {
        Locale current = Localization.INSTANCE.getCurrent();
        return Intrinsics.areEqual(current, Locale.Companion.getTRADITIONAL_CHINESE()) ? TraditionalChineseIMDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getENGLISH()) ? EnglishIMDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getJAPANESE()) ? JapaneseIMDateTimeFormat.INSTANCE : Intrinsics.areEqual(current, Locale.Companion.getTHAI()) ? ThaiIMDateTimeFormat.INSTANCE : ChineseIMDateTimeFormat.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$ChineseIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "<init>", "()V", "dayOfWeekNames", "Lkotlinx/datetime/format/DayOfWeekNames;", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "todayFormat", "yesterdayFormat", "pastFormat", "Lkotlinx/datetime/LocalDateTime;", "thisWeekFormat", "today", "Lkotlin/Function1;", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "getThisWeek", "past", "getPast", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ChineseIMDateTimeFormat implements IMDateTimeFormat {
        public static final ChineseIMDateTimeFormat INSTANCE = new ChineseIMDateTimeFormat();
        private static final DayOfWeekNames dayOfWeekNames = new DayOfWeekNames("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日");
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayFormat = hourMinuteFormat;
        private static final DateTimeFormat<LocalTime> yesterdayFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yesterdayFormat$lambda$0;
                yesterdayFormat$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.yesterdayFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit pastFormat$lambda$0;
                pastFormat$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.pastFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> thisWeekFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit thisWeekFormat$lambda$0;
                thisWeekFormat$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.thisWeekFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return thisWeekFormat$lambda$0;
            }
        });
        private static final Function1<LocalTime, String> today = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.ChineseIMDateTimeFormat.today$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> thisWeek = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                String thisWeek$lambda$0;
                thisWeek$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.thisWeek$lambda$0((LocalDateTime) obj);
                return thisWeek$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ChineseIMDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.ChineseIMDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChineseIMDateTimeFormat) {
                ChineseIMDateTimeFormat chineseIMDateTimeFormat = (ChineseIMDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -201626757;
        }

        public String toString() {
            return "ChineseIMDateTimeFormat";
        }

        private ChineseIMDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("昨天");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit thisWeekFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.dayOfWeek(dayOfWeekNames);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getToday() {
            return today;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String today$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getThisWeek() {
            return thisWeek;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String thisWeek$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return thisWeekFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$EnglishIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "<init>", "()V", "dayOfWeekNames", "Lkotlinx/datetime/format/DayOfWeekNames;", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "todayFormat", "yesterdayFormat", "pastFormat", "Lkotlinx/datetime/LocalDateTime;", "thisWeekFormat", "today", "Lkotlin/Function1;", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "getThisWeek", "past", "getPast", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EnglishIMDateTimeFormat implements IMDateTimeFormat {
        public static final EnglishIMDateTimeFormat INSTANCE = new EnglishIMDateTimeFormat();
        private static final DayOfWeekNames dayOfWeekNames = DayOfWeekNames.Companion.getENGLISH_ABBREVIATED();
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayFormat = hourMinuteFormat;
        private static final DateTimeFormat<LocalTime> yesterdayFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yesterdayFormat$lambda$0;
                yesterdayFormat$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.yesterdayFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit pastFormat$lambda$0;
                pastFormat$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.pastFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> thisWeekFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit thisWeekFormat$lambda$0;
                thisWeekFormat$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.thisWeekFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return thisWeekFormat$lambda$0;
            }
        });
        private static final Function1<LocalTime, String> today = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.EnglishIMDateTimeFormat.today$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> thisWeek = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                String thisWeek$lambda$0;
                thisWeek$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.thisWeek$lambda$0((LocalDateTime) obj);
                return thisWeek$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$EnglishIMDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.EnglishIMDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnglishIMDateTimeFormat) {
                EnglishIMDateTimeFormat englishIMDateTimeFormat = (EnglishIMDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -273512706;
        }

        public String toString() {
            return "EnglishIMDateTimeFormat";
        }

        private EnglishIMDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("Yesterday");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit thisWeekFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.dayOfWeek(dayOfWeekNames);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getToday() {
            return today;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String today$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getThisWeek() {
            return thisWeek;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String thisWeek$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return thisWeekFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "<init>", "()V", "dayOfWeekNames", "Lkotlinx/datetime/format/DayOfWeekNames;", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "todayFormat", "yesterdayFormat", "pastFormat", "Lkotlinx/datetime/LocalDateTime;", "thisWeekFormat", "today", "Lkotlin/Function1;", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "getThisWeek", "past", "getPast", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TraditionalChineseIMDateTimeFormat implements IMDateTimeFormat {
        public static final TraditionalChineseIMDateTimeFormat INSTANCE = new TraditionalChineseIMDateTimeFormat();
        private static final DayOfWeekNames dayOfWeekNames = new DayOfWeekNames("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日");
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayFormat = hourMinuteFormat;
        private static final DateTimeFormat<LocalTime> yesterdayFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yesterdayFormat$lambda$0;
                yesterdayFormat$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.yesterdayFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit pastFormat$lambda$0;
                pastFormat$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.pastFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> thisWeekFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit thisWeekFormat$lambda$0;
                thisWeekFormat$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.thisWeekFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return thisWeekFormat$lambda$0;
            }
        });
        private static final Function1<LocalTime, String> today = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.today$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> thisWeek = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                String thisWeek$lambda$0;
                thisWeek$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.thisWeek$lambda$0((LocalDateTime) obj);
                return thisWeek$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$TraditionalChineseIMDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.TraditionalChineseIMDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TraditionalChineseIMDateTimeFormat) {
                TraditionalChineseIMDateTimeFormat traditionalChineseIMDateTimeFormat = (TraditionalChineseIMDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1432931620;
        }

        public String toString() {
            return "TraditionalChineseIMDateTimeFormat";
        }

        private TraditionalChineseIMDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("昨天");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit thisWeekFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.dayOfWeek(dayOfWeekNames);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getToday() {
            return today;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String today$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getThisWeek() {
            return thisWeek;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String thisWeek$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return thisWeekFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$JapaneseIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "<init>", "()V", "dayOfWeekNames", "Lkotlinx/datetime/format/DayOfWeekNames;", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "todayFormat", "yesterdayFormat", "pastFormat", "Lkotlinx/datetime/LocalDateTime;", "thisWeekFormat", "today", "Lkotlin/Function1;", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "getThisWeek", "past", "getPast", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class JapaneseIMDateTimeFormat implements IMDateTimeFormat {
        public static final JapaneseIMDateTimeFormat INSTANCE = new JapaneseIMDateTimeFormat();
        private static final DayOfWeekNames dayOfWeekNames = new DayOfWeekNames("月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日");
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayFormat = hourMinuteFormat;
        private static final DateTimeFormat<LocalTime> yesterdayFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yesterdayFormat$lambda$0;
                yesterdayFormat$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.yesterdayFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit pastFormat$lambda$0;
                pastFormat$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.pastFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> thisWeekFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit thisWeekFormat$lambda$0;
                thisWeekFormat$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.thisWeekFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return thisWeekFormat$lambda$0;
            }
        });
        private static final Function1<LocalTime, String> today = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.today$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> thisWeek = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                String thisWeek$lambda$0;
                thisWeek$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.thisWeek$lambda$0((LocalDateTime) obj);
                return thisWeek$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$JapaneseIMDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.JapaneseIMDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof JapaneseIMDateTimeFormat) {
                JapaneseIMDateTimeFormat japaneseIMDateTimeFormat = (JapaneseIMDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1630158961;
        }

        public String toString() {
            return "JapaneseIMDateTimeFormat";
        }

        private JapaneseIMDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("昨日");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit thisWeekFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.dayOfWeek(dayOfWeekNames);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getToday() {
            return today;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String today$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getThisWeek() {
            return thisWeek;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String thisWeek$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return thisWeekFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastFormat.format(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LegacyDateTimeFormat.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006#"}, d2 = {"Lkntr/base/localization/preview/LegacyDateTimeFormat$ThaiIMDateTimeFormat;", "Lkntr/base/localization/preview/LegacyDateTimeFormat$IMDateTimeFormat;", "<init>", "()V", "dayOfWeekNames", "Lkotlinx/datetime/format/DayOfWeekNames;", "hourMinuteFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "monthDayFormat", "Lkotlinx/datetime/LocalDate;", "yearMonthDayFormat", "todayFormat", "yesterdayFormat", "pastFormat", "Lkotlinx/datetime/LocalDateTime;", "thisWeekFormat", "today", "Lkotlin/Function1;", "", "getToday", "()Lkotlin/jvm/functions/Function1;", "yesterday", "getYesterday", "thisWeek", "getThisWeek", "past", "getPast", "equals", "", "other", "", "hashCode", "", "toString", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ThaiIMDateTimeFormat implements IMDateTimeFormat {
        public static final ThaiIMDateTimeFormat INSTANCE = new ThaiIMDateTimeFormat();
        private static final DayOfWeekNames dayOfWeekNames = new DayOfWeekNames("จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์", "เสาร์", "อาทิตย์");
        private static final DateTimeFormat<LocalTime> hourMinuteFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit hourMinuteFormat$lambda$0;
                hourMinuteFormat$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.hourMinuteFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return hourMinuteFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> monthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit monthDayFormat$lambda$0;
                monthDayFormat$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.monthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return monthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDate> yearMonthDayFormat = LocalDate.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit yearMonthDayFormat$lambda$0;
                yearMonthDayFormat$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.yearMonthDayFormat$lambda$0((DateTimeFormatBuilder.WithDate) obj);
                return yearMonthDayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalTime> todayFormat = hourMinuteFormat;
        private static final DateTimeFormat<LocalTime> yesterdayFormat = LocalTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit yesterdayFormat$lambda$0;
                yesterdayFormat$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.yesterdayFormat$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return yesterdayFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> pastFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit pastFormat$lambda$0;
                pastFormat$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.pastFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return pastFormat$lambda$0;
            }
        });
        private static final DateTimeFormat<LocalDateTime> thisWeekFormat = LocalDateTime.Companion.Format(new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit thisWeekFormat$lambda$0;
                thisWeekFormat$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.thisWeekFormat$lambda$0((DateTimeFormatBuilder.WithDateTime) obj);
                return thisWeekFormat$lambda$0;
            }
        });
        private static final Function1<LocalTime, String> today = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                String str;
                str = LegacyDateTimeFormat.ThaiIMDateTimeFormat.today$lambda$0((LocalTime) obj);
                return str;
            }
        };
        private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                String yesterday$lambda$0;
                yesterday$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
                return yesterday$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> thisWeek = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                String thisWeek$lambda$0;
                thisWeek$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.thisWeek$lambda$0((LocalDateTime) obj);
                return thisWeek$lambda$0;
            }
        };
        private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.preview.LegacyDateTimeFormat$ThaiIMDateTimeFormat$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                String past$lambda$0;
                past$lambda$0 = LegacyDateTimeFormat.ThaiIMDateTimeFormat.past$lambda$0((LocalDateTime) obj);
                return past$lambda$0;
            }
        };

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThaiIMDateTimeFormat) {
                ThaiIMDateTimeFormat thaiIMDateTimeFormat = (ThaiIMDateTimeFormat) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 563669882;
        }

        public String toString() {
            return "ThaiIMDateTimeFormat";
        }

        private ThaiIMDateTimeFormat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit hourMinuteFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars(":");
            DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default($this$Format, (Padding) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit monthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.monthNumber(Padding.NONE);
            $this$Format.chars("-");
            $this$Format.dayOfMonth(Padding.NONE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yearMonthDayFormat$lambda$0(DateTimeFormatBuilder.WithDate $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            DateTimeFormatBuilder.WithDate.DefaultImpls.year$default($this$Format, (Padding) null, 1, (Object) null);
            $this$Format.chars("-");
            $this$Format.date(monthDayFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit yesterdayFormat$lambda$0(DateTimeFormatBuilder.WithTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.chars("เมื่อวาน");
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit pastFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.date(yearMonthDayFormat);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit thisWeekFormat$lambda$0(DateTimeFormatBuilder.WithDateTime $this$Format) {
            Intrinsics.checkNotNullParameter($this$Format, "$this$Format");
            $this$Format.dayOfWeek(dayOfWeekNames);
            $this$Format.chars(" ");
            $this$Format.time(hourMinuteFormat);
            return Unit.INSTANCE;
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getToday() {
            return today;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String today$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return todayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalTime, String> getYesterday() {
            return yesterday;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String yesterday$lambda$0(LocalTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return yesterdayFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getThisWeek() {
            return thisWeek;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String thisWeek$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return thisWeekFormat.format(it);
        }

        @Override // kntr.base.localization.preview.LegacyDateTimeFormat.IMDateTimeFormat
        public Function1<LocalDateTime, String> getPast() {
            return past;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String past$lambda$0(LocalDateTime it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return pastFormat.format(it);
        }
    }
}