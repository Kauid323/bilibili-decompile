package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\nHÖ\u0001R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R/\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R/\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R/\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R/\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0018¨\u00064"}, d2 = {"Lkntr/base/localization/DefaultRelativeDateTimeFormat;", "Lkntr/base/localization/RelativeDateTimeFormat;", "<init>", "()V", "hourMinute", "Lkotlin/Function1;", "Lkotlinx/datetime/LocalTime;", "Lkotlin/ParameterName;", "name", "time", "", "monthDay", "Lkotlinx/datetime/LocalDateTime;", "yearMonthDay", "monthDayHourMinute", "yearMonthDayHourMinute", "justNow", "Lkotlin/Function0;", "getJustNow", "()Lkotlin/jvm/functions/Function0;", "minutesAgo", "Lkotlin/time/Duration;", "duration", "getMinutesAgo", "()Lkotlin/jvm/functions/Function1;", "hoursAgo", "getHoursAgo", "daysAgo", "Lkotlinx/datetime/DatePeriod;", "period", "getDaysAgo", "yesterday", "getYesterday", "today", "getToday", "tomorrow", "getTomorrow", "past", "getPast", "future", "getFuture", "pastThisYear", "getPastThisYear", "futureThisYear", "getFutureThisYear", "equals", "", "other", "", "hashCode", "", "toString", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DefaultRelativeDateTimeFormat implements RelativeDateTimeFormat {
    public static final DefaultRelativeDateTimeFormat INSTANCE = new DefaultRelativeDateTimeFormat();
    private static final Function1<LocalTime, String> hourMinute = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            String hourMinute$lambda$0;
            hourMinute$lambda$0 = DefaultRelativeDateTimeFormat.hourMinute$lambda$0((LocalTime) obj);
            return hourMinute$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> monthDay = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda13
        public final Object invoke(Object obj) {
            String monthDay$lambda$0;
            monthDay$lambda$0 = DefaultRelativeDateTimeFormat.monthDay$lambda$0((LocalDateTime) obj);
            return monthDay$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> yearMonthDay = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda14
        public final Object invoke(Object obj) {
            String yearMonthDay$lambda$0;
            yearMonthDay$lambda$0 = DefaultRelativeDateTimeFormat.yearMonthDay$lambda$0((LocalDateTime) obj);
            return yearMonthDay$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> monthDayHourMinute = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda15
        public final Object invoke(Object obj) {
            String monthDayHourMinute$lambda$0;
            monthDayHourMinute$lambda$0 = DefaultRelativeDateTimeFormat.monthDayHourMinute$lambda$0((LocalDateTime) obj);
            return monthDayHourMinute$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> yearMonthDayHourMinute = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            String yearMonthDayHourMinute$lambda$0;
            yearMonthDayHourMinute$lambda$0 = DefaultRelativeDateTimeFormat.yearMonthDayHourMinute$lambda$0((LocalDateTime) obj);
            return yearMonthDayHourMinute$lambda$0;
        }
    };
    private static final Function0<String> justNow = new Function0() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda2
        public final Object invoke() {
            String justNow$lambda$0;
            justNow$lambda$0 = DefaultRelativeDateTimeFormat.justNow$lambda$0();
            return justNow$lambda$0;
        }
    };
    private static final Function1<Duration, String> minutesAgo = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            String minutesAgo$lambda$0;
            minutesAgo$lambda$0 = DefaultRelativeDateTimeFormat.minutesAgo$lambda$0((Duration) obj);
            return minutesAgo$lambda$0;
        }
    };
    private static final Function1<Duration, String> hoursAgo = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda4
        public final Object invoke(Object obj) {
            String hoursAgo$lambda$0;
            hoursAgo$lambda$0 = DefaultRelativeDateTimeFormat.hoursAgo$lambda$0((Duration) obj);
            return hoursAgo$lambda$0;
        }
    };
    private static final Function1<DatePeriod, String> daysAgo = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda5
        public final Object invoke(Object obj) {
            String daysAgo$lambda$0;
            daysAgo$lambda$0 = DefaultRelativeDateTimeFormat.daysAgo$lambda$0((DatePeriod) obj);
            return daysAgo$lambda$0;
        }
    };
    private static final Function1<LocalTime, String> yesterday = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda6
        public final Object invoke(Object obj) {
            String yesterday$lambda$0;
            yesterday$lambda$0 = DefaultRelativeDateTimeFormat.yesterday$lambda$0((LocalTime) obj);
            return yesterday$lambda$0;
        }
    };
    private static final Function1<LocalTime, String> today = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda7
        public final Object invoke(Object obj) {
            String str;
            str = DefaultRelativeDateTimeFormat.today$lambda$0((LocalTime) obj);
            return str;
        }
    };
    private static final Function1<LocalTime, String> tomorrow = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda8
        public final Object invoke(Object obj) {
            String str;
            str = DefaultRelativeDateTimeFormat.tomorrow$lambda$0((LocalTime) obj);
            return str;
        }
    };
    private static final Function1<LocalDateTime, String> past = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda9
        public final Object invoke(Object obj) {
            String past$lambda$0;
            past$lambda$0 = DefaultRelativeDateTimeFormat.past$lambda$0((LocalDateTime) obj);
            return past$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> future = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda10
        public final Object invoke(Object obj) {
            String future$lambda$0;
            future$lambda$0 = DefaultRelativeDateTimeFormat.future$lambda$0((LocalDateTime) obj);
            return future$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> pastThisYear = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda11
        public final Object invoke(Object obj) {
            String pastThisYear$lambda$0;
            pastThisYear$lambda$0 = DefaultRelativeDateTimeFormat.pastThisYear$lambda$0((LocalDateTime) obj);
            return pastThisYear$lambda$0;
        }
    };
    private static final Function1<LocalDateTime, String> futureThisYear = new Function1() { // from class: kntr.base.localization.DefaultRelativeDateTimeFormat$$ExternalSyntheticLambda12
        public final Object invoke(Object obj) {
            String futureThisYear$lambda$0;
            futureThisYear$lambda$0 = DefaultRelativeDateTimeFormat.futureThisYear$lambda$0((LocalDateTime) obj);
            return futureThisYear$lambda$0;
        }
    };

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultRelativeDateTimeFormat) {
            DefaultRelativeDateTimeFormat defaultRelativeDateTimeFormat = (DefaultRelativeDateTimeFormat) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return -467782982;
    }

    public String toString() {
        return "DefaultRelativeDateTimeFormat";
    }

    private DefaultRelativeDateTimeFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hourMinute$lambda$0(LocalTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.HourMinute, StringsKt.padStart(String.valueOf(it.getHour()), 2, '0'), StringsKt.padStart(String.valueOf(it.getMinute()), 2, '0'));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String monthDay$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.MonthDay, Integer.valueOf(it.getMonthNumber()), Integer.valueOf(it.getDayOfMonth()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yearMonthDay$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.YearMonthDay, Integer.valueOf(it.getYear()), Integer.valueOf(it.getMonthNumber()), Integer.valueOf(it.getDayOfMonth()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String monthDayHourMinute$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.MonthDayTime, Integer.valueOf(it.getMonthNumber()), Integer.valueOf(it.getDayOfMonth()), StringsKt.padStart(String.valueOf(it.getHour()), 2, '0'), StringsKt.padStart(String.valueOf(it.getMinute()), 2, '0'));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yearMonthDayHourMinute$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.YearMonthDayTime, Integer.valueOf(it.getYear()), Integer.valueOf(it.getMonthNumber()), Integer.valueOf(it.getDayOfMonth()), StringsKt.padStart(String.valueOf(it.getHour()), 2, '0'), StringsKt.padStart(String.valueOf(it.getMinute()), 2, '0'));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function0<String> getJustNow() {
        return justNow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String justNow$lambda$0() {
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.JustNow);
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<Duration, String> getMinutesAgo() {
        return minutesAgo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String minutesAgo$lambda$0(Duration it) {
        return DateTimeResource_androidKt.getDateTimeResource().getPluralString(DateTimePluralID.MinutesAgo, (int) Duration.getInWholeMinutes-impl(it.unbox-impl()), Long.valueOf(Duration.getInWholeMinutes-impl(it.unbox-impl())));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<Duration, String> getHoursAgo() {
        return hoursAgo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hoursAgo$lambda$0(Duration it) {
        return DateTimeResource_androidKt.getDateTimeResource().getPluralString(DateTimePluralID.HoursAgo, (int) Duration.getInWholeHours-impl(it.unbox-impl()), Long.valueOf(Duration.getInWholeHours-impl(it.unbox-impl())));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<DatePeriod, String> getDaysAgo() {
        return daysAgo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String daysAgo$lambda$0(DatePeriod it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getPluralString(DateTimePluralID.DaysAgo, it.getDays(), Integer.valueOf(it.getDays()));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalTime, String> getYesterday() {
        return yesterday;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yesterday$lambda$0(LocalTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.Yesterday, hourMinute.invoke(it));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalTime, String> getToday() {
        return today;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String today$lambda$0(LocalTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.Today, hourMinute.invoke(it));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalTime, String> getTomorrow() {
        return tomorrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String tomorrow$lambda$0(LocalTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DateTimeResource_androidKt.getDateTimeResource().getString(DateTimeStringID.Tomorrow, hourMinute.invoke(it));
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalDateTime, String> getPast() {
        return past;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String past$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) yearMonthDay.invoke(it);
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalDateTime, String> getFuture() {
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String future$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) yearMonthDayHourMinute.invoke(it);
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalDateTime, String> getPastThisYear() {
        return pastThisYear;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String pastThisYear$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) monthDay.invoke(it);
    }

    @Override // kntr.base.localization.RelativeDateTimeFormat
    public Function1<LocalDateTime, String> getFutureThisYear() {
        return futureThisYear;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String futureThisYear$lambda$0(LocalDateTime it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (String) monthDayHourMinute.invoke(it);
    }
}