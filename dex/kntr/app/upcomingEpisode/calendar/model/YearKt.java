package kntr.app.upcomingEpisode.calendar.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: Year.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004\u001a\u001a\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004\u001a\u001e\u0010\b\u001a\u00020\u0006*\u00020\u00022\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\n\u001a\u00020\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\n\u0010\u000b\u001a\u00060\fj\u0002`\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004\u001a\u0012\u0010\u0010\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004\u001a\u0012\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004¨\u0006\u0015"}, d2 = {"isLeap", "", "Lkntr/app/upcomingEpisode/calendar/model/Year;", "length", "", "atDay", "Lkotlinx/datetime/LocalDate;", "dayOfYear", "atMonthDay", "monthNumber", "day", "month", "Ljava/time/Month;", "Lkotlinx/datetime/Month;", "atMonth", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "yearsUntil", "other", "plusYears", "value", "minusYears", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class YearKt {

    /* compiled from: Year.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<j$.time.Month> entries$0 = EnumEntriesKt.enumEntries(j$.time.Month.values());
    }

    public static final boolean isLeap(Year $this$isLeap) {
        Intrinsics.checkNotNullParameter($this$isLeap, "<this>");
        return Year.Companion.isLeap($this$isLeap.getYear$main_debug());
    }

    public static final int length(Year $this$length) {
        Intrinsics.checkNotNullParameter($this$length, "<this>");
        return isLeap($this$length) ? 366 : 365;
    }

    public static final LocalDate atDay(Year $this$atDay, int dayOfYear) {
        Intrinsics.checkNotNullParameter($this$atDay, "<this>");
        if (!(dayOfYear >= 1 && (dayOfYear <= 365 || (isLeap($this$atDay) && dayOfYear <= 366)))) {
            throw new IllegalArgumentException(("Invalid dayOfYear value '" + dayOfYear + "' for year '" + $this$atDay.getYear$main_debug()).toString());
        }
        for (j$.time.Month month : EntriesMappings.entries$0) {
            YearMonth yearMonth = atMonth($this$atDay, month);
            if (YearMonthKt.atEndOfMonth(yearMonth).getDayOfYear() >= dayOfYear) {
                return YearMonthKt.atDay(yearMonth, (dayOfYear - YearMonthKt.atStartOfMonth(yearMonth).getDayOfYear()) + 1);
            }
        }
        throw new IllegalArgumentException("Invalid dayOfYear value '" + dayOfYear + "' for year '" + $this$atDay.getYear$main_debug());
    }

    public static final LocalDate atMonthDay(Year $this$atMonthDay, int monthNumber, int day) {
        Intrinsics.checkNotNullParameter($this$atMonthDay, "<this>");
        return new LocalDate($this$atMonthDay.getYear$main_debug(), monthNumber, day);
    }

    public static final LocalDate atMonthDay(Year $this$atMonthDay, j$.time.Month month, int day) {
        Intrinsics.checkNotNullParameter($this$atMonthDay, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDate($this$atMonthDay.getYear$main_debug(), month, day);
    }

    public static final YearMonth atMonth(Year $this$atMonth, j$.time.Month month) {
        Intrinsics.checkNotNullParameter($this$atMonth, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return new YearMonth($this$atMonth.getYear$main_debug(), month);
    }

    public static final YearMonth atMonth(Year $this$atMonth, int monthNumber) {
        Intrinsics.checkNotNullParameter($this$atMonth, "<this>");
        return new YearMonth($this$atMonth.getYear$main_debug(), monthNumber);
    }

    public static final int yearsUntil(Year $this$yearsUntil, Year other) {
        Intrinsics.checkNotNullParameter($this$yearsUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.getYear$main_debug() - $this$yearsUntil.getYear$main_debug();
    }

    public static final Year plusYears(Year $this$plusYears, int value) {
        Intrinsics.checkNotNullParameter($this$plusYears, "<this>");
        return new Year($this$plusYears.getYear$main_debug() + value);
    }

    public static final Year minusYears(Year $this$minusYears, int value) {
        Intrinsics.checkNotNullParameter($this$minusYears, "<this>");
        return new Year($this$minusYears.getYear$main_debug() - value);
    }
}