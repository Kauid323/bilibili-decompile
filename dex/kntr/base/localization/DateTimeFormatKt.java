package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0001\u0019\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\b\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a$\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000fH\u0002\u001a8\u0010\u0004\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u0012H\u0002\u001a(\u0010\u0016\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a(\u0010\u0017\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0082\u0004¢\u0006\u0004\b\u001b\u0010\u001c\"\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001d"}, d2 = {"formatRelativeDateTime", "", "", "formatAbsoluteDateTime", "formatIMDateTime", "formatRelativeDateTimeFromSeconds", "formatAbsoluteDateTimeFromSeconds", "formatIMDateTimeFromSeconds", "Lkotlinx/datetime/Instant;", "target", "current", "timeZone", "Lkotlinx/datetime/TimeZone;", "format", "Lkntr/base/localization/RelativeDateTimeFormat;", "Lkntr/base/localization/AbsoluteDateTimeFormat;", "showThisWeek", "", "Lkntr/base/localization/IMDateTimeFormat;", "TimeTolerance", "Lkotlin/time/Duration;", "J", "formatRelativePastDateTime", "formatRelativeFutureDateTime", "until", "kntr/base/localization/DateTimeFormatKt$until$1", "other", "until-QTBD994", "(JJ)Lkntr/base/localization/DateTimeFormatKt$until$1;", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateTimeFormatKt {
    private static final long TimeTolerance;

    public static final String formatRelativeDateTime(long $this$formatRelativeDateTime) {
        return formatRelativeDateTime$default(Instant.Companion.fromEpochMilliseconds($this$formatRelativeDateTime), null, null, null, 14, null);
    }

    public static final String formatAbsoluteDateTime(long $this$formatAbsoluteDateTime) {
        return formatAbsoluteDateTime$default(Instant.Companion.fromEpochMilliseconds($this$formatAbsoluteDateTime), null, null, 6, null);
    }

    public static final String formatIMDateTime(long $this$formatIMDateTime) {
        return formatIMDateTime$default(Instant.Companion.fromEpochMilliseconds($this$formatIMDateTime), null, null, false, null, 30, null);
    }

    public static final String formatRelativeDateTimeFromSeconds(long $this$formatRelativeDateTimeFromSeconds) {
        return formatRelativeDateTime$default(Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$formatRelativeDateTimeFromSeconds, 0L, 2, (Object) null), null, null, null, 14, null);
    }

    public static final String formatAbsoluteDateTimeFromSeconds(long $this$formatAbsoluteDateTimeFromSeconds) {
        return formatAbsoluteDateTime$default(Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$formatAbsoluteDateTimeFromSeconds, 0L, 2, (Object) null), null, null, 6, null);
    }

    public static final String formatIMDateTimeFromSeconds(long $this$formatIMDateTimeFromSeconds) {
        return formatIMDateTime$default(Instant.Companion.fromEpochSeconds$default(Instant.Companion, $this$formatIMDateTimeFromSeconds, 0L, 2, (Object) null), null, null, false, null, 30, null);
    }

    public static final String formatIMDateTime(Instant $this$formatIMDateTime) {
        Intrinsics.checkNotNullParameter($this$formatIMDateTime, "<this>");
        return formatIMDateTime$default($this$formatIMDateTime, null, null, false, null, 30, null);
    }

    static /* synthetic */ String formatRelativeDateTime$default(Instant instant, Instant instant2, TimeZone timeZone, RelativeDateTimeFormat relativeDateTimeFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            instant2 = Clock.System.INSTANCE.now();
        }
        if ((i & 4) != 0) {
            timeZone = Localization_androidKt.getSystemTimeZone();
        }
        if ((i & 8) != 0) {
            relativeDateTimeFormat = DefaultRelativeDateTimeFormat.INSTANCE;
        }
        return formatRelativeDateTime(instant, instant2, timeZone, relativeDateTimeFormat);
    }

    private static final String formatRelativeDateTime(Instant target, Instant current, TimeZone timeZone, RelativeDateTimeFormat format) {
        if (current.plus-LRDsOJo(TimeTolerance).compareTo(target) >= 0) {
            return formatRelativePastDateTime(current, target, timeZone, format);
        }
        return formatRelativeFutureDateTime(current, target, timeZone, format);
    }

    static /* synthetic */ String formatAbsoluteDateTime$default(Instant instant, TimeZone timeZone, AbsoluteDateTimeFormat absoluteDateTimeFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = Localization_androidKt.getSystemTimeZone();
        }
        if ((i & 4) != 0) {
            absoluteDateTimeFormat = DefaultAbsoluteDateTimeFormat.INSTANCE;
        }
        return formatAbsoluteDateTime(instant, timeZone, absoluteDateTimeFormat);
    }

    private static final String formatAbsoluteDateTime(Instant target, TimeZone timeZone, AbsoluteDateTimeFormat format) {
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(target, timeZone);
        return (String) format.getYearMonthDayHourMinute().invoke(targetDateTime);
    }

    static /* synthetic */ String formatIMDateTime$default(Instant instant, Instant instant2, TimeZone timeZone, boolean z, IMDateTimeFormat iMDateTimeFormat, int i, Object obj) {
        if ((i & 2) != 0) {
            instant2 = Clock.System.INSTANCE.now();
        }
        if ((i & 4) != 0) {
            timeZone = Localization_androidKt.getSystemTimeZone();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            iMDateTimeFormat = DefaultIMDateTimeFormat.INSTANCE;
        }
        return formatIMDateTime(instant, instant2, timeZone, z, iMDateTimeFormat);
    }

    private static final String formatIMDateTime(Instant target, Instant current, TimeZone timeZone, boolean showThisWeek, IMDateTimeFormat format) {
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

    static {
        Duration.Companion companion = Duration.Companion;
        TimeTolerance = DurationKt.toDuration(10, DurationUnit.SECONDS);
    }

    private static final String formatRelativePastDateTime(Instant current, Instant target, TimeZone timeZone, RelativeDateTimeFormat format) {
        long duration = current.minus-5sfh64U(target);
        long j = Duration.unaryMinus-UwyO8pc(TimeTolerance);
        Duration.Companion companion = Duration.Companion;
        if (m1596untilQTBD994(j, DurationKt.toDuration(1, DurationUnit.MINUTES)).contains(Duration.box-impl(duration))) {
            return (String) format.getJustNow().invoke();
        }
        Duration.Companion companion2 = Duration.Companion;
        long duration2 = DurationKt.toDuration(1, DurationUnit.MINUTES);
        Duration.Companion companion3 = Duration.Companion;
        if (m1596untilQTBD994(duration2, DurationKt.toDuration(1, DurationUnit.HOURS)).contains(Duration.box-impl(duration))) {
            return (String) format.getMinutesAgo().invoke(Duration.box-impl(duration));
        }
        Duration.Companion companion4 = Duration.Companion;
        long duration3 = DurationKt.toDuration(1, DurationUnit.HOURS);
        Duration.Companion companion5 = Duration.Companion;
        if (m1596untilQTBD994(duration3, DurationKt.toDuration(24, DurationUnit.HOURS)).contains(Duration.box-impl(duration))) {
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
        return target.compareTo(today.minus-LRDsOJo(DurationKt.toDuration(3, DurationUnit.DAYS))) >= 0 ? (String) format.getDaysAgo().invoke(LocalDateKt.minus(currentDateTime.getDate(), targetDateTime.getDate())) : targetDateTime.getYear() == currentDateTime.getYear() ? (String) format.getPastThisYear().invoke(targetDateTime) : (String) format.getPast().invoke(targetDateTime);
    }

    private static final String formatRelativeFutureDateTime(Instant current, Instant target, TimeZone timeZone, RelativeDateTimeFormat format) {
        LocalDateTime currentDateTime = TimeZoneKt.toLocalDateTime(current, timeZone);
        LocalDateTime targetDateTime = TimeZoneKt.toLocalDateTime(target, timeZone);
        if (Intrinsics.areEqual(targetDateTime.getDate(), currentDateTime.getDate())) {
            return (String) format.getToday().invoke(targetDateTime.getTime());
        }
        if (Intrinsics.areEqual(targetDateTime.getDate(), LocalDateJvmKt.plus(currentDateTime.getDate(), 1, DateTimeUnit.Companion.getDAY()))) {
            return (String) format.getTomorrow().invoke(targetDateTime.getTime());
        }
        return targetDateTime.getYear() == currentDateTime.getYear() ? (String) format.getFutureThisYear().invoke(targetDateTime) : (String) format.getFuture().invoke(targetDateTime);
    }

    /* renamed from: until-QTBD994  reason: not valid java name */
    private static final DateTimeFormatKt$until$1 m1596untilQTBD994(long j, long j2) {
        return new DateTimeFormatKt$until$1(j, j2);
    }
}