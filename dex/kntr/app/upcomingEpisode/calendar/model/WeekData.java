package kntr.app.upcomingEpisode.calendar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.datetime.LocalDate;

/* compiled from: WeekData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/WeekData;", "", "firstDayInWeek", "Lkotlinx/datetime/LocalDate;", "desiredStartDate", "desiredEndDate", "<init>", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;)V", "week", "Lkntr/app/upcomingEpisode/calendar/model/Week;", "getWeek", "()Lkntr/app/upcomingEpisode/calendar/model/Week;", "getDay", "Lkntr/app/upcomingEpisode/calendar/model/WeekDay;", "dayOffset", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WeekData {
    public static final int $stable = 8;
    private final LocalDate desiredEndDate;
    private final LocalDate desiredStartDate;
    private final LocalDate firstDayInWeek;
    private final Week week;

    private final LocalDate component1() {
        return this.firstDayInWeek;
    }

    private final LocalDate component2() {
        return this.desiredStartDate;
    }

    private final LocalDate component3() {
        return this.desiredEndDate;
    }

    public static /* synthetic */ WeekData copy$default(WeekData weekData, LocalDate localDate, LocalDate localDate2, LocalDate localDate3, int i, Object obj) {
        if ((i & 1) != 0) {
            localDate = weekData.firstDayInWeek;
        }
        if ((i & 2) != 0) {
            localDate2 = weekData.desiredStartDate;
        }
        if ((i & 4) != 0) {
            localDate3 = weekData.desiredEndDate;
        }
        return weekData.copy(localDate, localDate2, localDate3);
    }

    public final WeekData copy(LocalDate localDate, LocalDate localDate2, LocalDate localDate3) {
        Intrinsics.checkNotNullParameter(localDate, "firstDayInWeek");
        Intrinsics.checkNotNullParameter(localDate2, "desiredStartDate");
        Intrinsics.checkNotNullParameter(localDate3, "desiredEndDate");
        return new WeekData(localDate, localDate2, localDate3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WeekData) {
            WeekData weekData = (WeekData) obj;
            return Intrinsics.areEqual(this.firstDayInWeek, weekData.firstDayInWeek) && Intrinsics.areEqual(this.desiredStartDate, weekData.desiredStartDate) && Intrinsics.areEqual(this.desiredEndDate, weekData.desiredEndDate);
        }
        return false;
    }

    public int hashCode() {
        return (((this.firstDayInWeek.hashCode() * 31) + this.desiredStartDate.hashCode()) * 31) + this.desiredEndDate.hashCode();
    }

    public String toString() {
        LocalDate localDate = this.firstDayInWeek;
        LocalDate localDate2 = this.desiredStartDate;
        return "WeekData(firstDayInWeek=" + localDate + ", desiredStartDate=" + localDate2 + ", desiredEndDate=" + this.desiredEndDate + ")";
    }

    public WeekData(LocalDate firstDayInWeek, LocalDate desiredStartDate, LocalDate desiredEndDate) {
        Intrinsics.checkNotNullParameter(firstDayInWeek, "firstDayInWeek");
        Intrinsics.checkNotNullParameter(desiredStartDate, "desiredStartDate");
        Intrinsics.checkNotNullParameter(desiredEndDate, "desiredEndDate");
        this.firstDayInWeek = firstDayInWeek;
        this.desiredStartDate = desiredStartDate;
        this.desiredEndDate = desiredEndDate;
        Iterable $this$map$iv = RangesKt.until(0, 7);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        IntIterator it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int item$iv$iv = it.nextInt();
            destination$iv$iv.add(getDay(item$iv$iv));
        }
        this.week = new Week((List) destination$iv$iv);
    }

    public final Week getWeek() {
        return this.week;
    }

    private final WeekDay getDay(int dayOffset) {
        WeekDayPosition position;
        LocalDate date = BiliCalendarExtensionsKt.plusDays(this.firstDayInWeek, dayOffset);
        if (date.compareTo(this.desiredStartDate) < 0) {
            position = WeekDayPosition.InDate;
        } else {
            position = date.compareTo(this.desiredEndDate) > 0 ? WeekDayPosition.OutDate : WeekDayPosition.RangeDate;
        }
        return new WeekDay(date, position, null, 4, null);
    }
}