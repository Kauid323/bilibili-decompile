package kntr.app.upcomingEpisode.calendar.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.MonthKt;

/* compiled from: YearMonth.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u001a\u001a\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r\u001a\u001a\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u0012\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u0012\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u0012\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"atStartOfMonth", "Lkotlinx/datetime/LocalDate;", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "atEndOfMonth", "atDay", "day", "", "lengthOfMonth", "monthsUntil", "other", "plus", "value", "unit", "Lkotlinx/datetime/DateTimeUnit$MonthBased;", "minus", "plusMonths", "minusMonths", "plusYears", "minusYears", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class YearMonthKt {
    public static final LocalDate atStartOfMonth(YearMonth $this$atStartOfMonth) {
        Intrinsics.checkNotNullParameter($this$atStartOfMonth, "<this>");
        return atDay($this$atStartOfMonth, 1);
    }

    public static final LocalDate atEndOfMonth(YearMonth $this$atEndOfMonth) {
        Intrinsics.checkNotNullParameter($this$atEndOfMonth, "<this>");
        return atDay($this$atEndOfMonth, lengthOfMonth($this$atEndOfMonth));
    }

    public static final LocalDate atDay(YearMonth $this$atDay, int day) {
        Intrinsics.checkNotNullParameter($this$atDay, "<this>");
        return new LocalDate($this$atDay.getYear(), $this$atDay.getMonth(), day);
    }

    public static final int lengthOfMonth(YearMonth $this$lengthOfMonth) {
        Intrinsics.checkNotNullParameter($this$lengthOfMonth, "<this>");
        switch (MonthKt.getNumber($this$lengthOfMonth.getMonth())) {
            case 2:
                return Year.Companion.isLeap($this$lengthOfMonth.getYear()) ? 29 : 28;
            case 4:
            case 6:
            case ConstantsKt.SPACER_9 /* 9 */:
            case MediaAttrUtils.TYPE_MENU /* 11 */:
                return 30;
            default:
                return 31;
        }
    }

    public static final int monthsUntil(YearMonth $this$monthsUntil, YearMonth other) {
        Intrinsics.checkNotNullParameter($this$monthsUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return LocalDateJvmKt.monthsUntil(atStartOfMonth($this$monthsUntil), atStartOfMonth(other));
    }

    public static final YearMonth plus(YearMonth $this$plus, int value, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return BiliCalendarExtensionsKt.getYearMonth(LocalDateJvmKt.plus(atStartOfMonth($this$plus), value, (DateTimeUnit.DateBased) unit));
    }

    public static final YearMonth minus(YearMonth $this$minus, int value, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return BiliCalendarExtensionsKt.getYearMonth(LocalDateJvmKt.minus(atStartOfMonth($this$minus), value, (DateTimeUnit.DateBased) unit));
    }

    public static final YearMonth plusMonths(YearMonth $this$plusMonths, int value) {
        Intrinsics.checkNotNullParameter($this$plusMonths, "<this>");
        return plus($this$plusMonths, value, DateTimeUnit.Companion.getMONTH());
    }

    public static final YearMonth minusMonths(YearMonth $this$minusMonths, int value) {
        Intrinsics.checkNotNullParameter($this$minusMonths, "<this>");
        return minus($this$minusMonths, value, DateTimeUnit.Companion.getMONTH());
    }

    public static final YearMonth plusYears(YearMonth $this$plusYears, int value) {
        Intrinsics.checkNotNullParameter($this$plusYears, "<this>");
        return plus($this$plusYears, value, DateTimeUnit.Companion.getYEAR());
    }

    public static final YearMonth minusYears(YearMonth $this$minusYears, int value) {
        Intrinsics.checkNotNullParameter($this$minusYears, "<this>");
        return minus($this$minusYears, value, DateTimeUnit.Companion.getYEAR());
    }
}