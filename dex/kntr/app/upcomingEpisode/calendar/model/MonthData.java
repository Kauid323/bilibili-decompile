package kntr.app.upcomingEpisode.calendar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.datetime.LocalDate;

/* compiled from: MonthData.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\t\u0010\u001d\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÂ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÂ\u0003J'\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/MonthData;", "", "month", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "inDays", "", "outDays", "<init>", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;II)V", "totalDays", "getTotalDays", "()I", "firstDay", "Lkotlinx/datetime/LocalDate;", "getFirstDay", "()Lkotlinx/datetime/LocalDate;", "lastDay", "getLastDay", "rows", "", "previousMonth", "nextMonth", "calendarMonth", "Lkntr/app/upcomingEpisode/calendar/model/Month;", "getCalendarMonth", "()Lkntr/app/upcomingEpisode/calendar/model/Month;", "getDay", "Lkntr/app/upcomingEpisode/calendar/model/Day;", "dayOffset", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MonthData {
    public static final int $stable = 8;
    private final Month calendarMonth;
    private final LocalDate firstDay;
    private final int inDays;
    private final LocalDate lastDay;
    private final YearMonth month;
    private final YearMonth nextMonth;
    private final int outDays;
    private final YearMonth previousMonth;
    private final List<List<Integer>> rows;
    private final int totalDays;

    private final YearMonth component1() {
        return this.month;
    }

    private final int component2() {
        return this.inDays;
    }

    private final int component3() {
        return this.outDays;
    }

    public static /* synthetic */ MonthData copy$default(MonthData monthData, YearMonth yearMonth, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            yearMonth = monthData.month;
        }
        if ((i3 & 2) != 0) {
            i = monthData.inDays;
        }
        if ((i3 & 4) != 0) {
            i2 = monthData.outDays;
        }
        return monthData.copy(yearMonth, i, i2);
    }

    public final MonthData copy(YearMonth yearMonth, int i, int i2) {
        Intrinsics.checkNotNullParameter(yearMonth, "month");
        return new MonthData(yearMonth, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MonthData) {
            MonthData monthData = (MonthData) obj;
            return Intrinsics.areEqual(this.month, monthData.month) && this.inDays == monthData.inDays && this.outDays == monthData.outDays;
        }
        return false;
    }

    public int hashCode() {
        return (((this.month.hashCode() * 31) + this.inDays) * 31) + this.outDays;
    }

    public String toString() {
        YearMonth yearMonth = this.month;
        int i = this.inDays;
        return "MonthData(month=" + yearMonth + ", inDays=" + i + ", outDays=" + this.outDays + ")";
    }

    public MonthData(YearMonth month, int inDays, int outDays) {
        Intrinsics.checkNotNullParameter(month, "month");
        this.month = month;
        this.inDays = inDays;
        this.outDays = outDays;
        this.totalDays = this.inDays + YearMonthKt.lengthOfMonth(this.month) + this.outDays;
        this.firstDay = BiliCalendarExtensionsKt.minusDays(YearMonthKt.atStartOfMonth(this.month), this.inDays);
        this.lastDay = BiliCalendarExtensionsKt.plusDays(YearMonthKt.atEndOfMonth(this.month), this.outDays);
        this.rows = CollectionsKt.chunked(RangesKt.until(0, this.totalDays), 7);
        this.previousMonth = YearMonthKt.minusMonths(this.month, 1);
        this.nextMonth = YearMonthKt.plusMonths(this.month, 1);
        YearMonth yearMonth = this.month;
        Iterable $this$map$iv = this.rows;
        int i = 10;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Iterable week = (List) item$iv$iv;
            Iterable $this$map$iv2 = week;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, i));
            for (Object item$iv$iv2 : $this$map$iv2) {
                int dayOffset = ((Number) item$iv$iv2).intValue();
                destination$iv$iv2.add(getDay(dayOffset));
            }
            destination$iv$iv.add((List) destination$iv$iv2);
            i = 10;
        }
        this.calendarMonth = new Month(yearMonth, (List) destination$iv$iv);
    }

    public final int getTotalDays() {
        return this.totalDays;
    }

    public final LocalDate getFirstDay() {
        return this.firstDay;
    }

    public final LocalDate getLastDay() {
        return this.lastDay;
    }

    public final Month getCalendarMonth() {
        return this.calendarMonth;
    }

    private final Day getDay(int dayOffset) {
        DayPosition position;
        LocalDate date = BiliCalendarExtensionsKt.plusDays(this.firstDay, dayOffset);
        YearMonth yearMonth = BiliCalendarExtensionsKt.getYearMonth(date);
        if (Intrinsics.areEqual(yearMonth, this.month)) {
            position = DayPosition.MonthDate;
        } else if (Intrinsics.areEqual(yearMonth, this.previousMonth)) {
            position = DayPosition.InDate;
        } else if (!Intrinsics.areEqual(yearMonth, this.nextMonth)) {
            throw new IllegalArgumentException("Invalid date: " + date + " in month: " + this.month);
        } else {
            position = DayPosition.OutDate;
        }
        return new Day(date, position, null, 4, null);
    }
}