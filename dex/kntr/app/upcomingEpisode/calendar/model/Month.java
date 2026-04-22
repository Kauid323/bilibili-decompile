package kntr.app.upcomingEpisode.calendar.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Month.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/Month;", "", "yearMonth", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "weekDays", "", "Lkntr/app/upcomingEpisode/calendar/model/Day;", "<init>", "(Lkntr/app/upcomingEpisode/calendar/model/YearMonth;Ljava/util/List;)V", "getYearMonth", "()Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "getWeekDays", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Month {
    public static final int $stable = 0;
    private final List<List<Day>> weekDays;
    private final YearMonth yearMonth;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Month copy$default(Month month, YearMonth yearMonth, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            yearMonth = month.yearMonth;
        }
        if ((i & 2) != 0) {
            list = month.weekDays;
        }
        return month.copy(yearMonth, list);
    }

    public final YearMonth component1() {
        return this.yearMonth;
    }

    public final List<List<Day>> component2() {
        return this.weekDays;
    }

    public final Month copy(YearMonth yearMonth, List<? extends List<Day>> list) {
        Intrinsics.checkNotNullParameter(yearMonth, "yearMonth");
        Intrinsics.checkNotNullParameter(list, "weekDays");
        return new Month(yearMonth, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Month) {
            Month month = (Month) obj;
            return Intrinsics.areEqual(this.yearMonth, month.yearMonth) && Intrinsics.areEqual(this.weekDays, month.weekDays);
        }
        return false;
    }

    public int hashCode() {
        return (this.yearMonth.hashCode() * 31) + this.weekDays.hashCode();
    }

    public String toString() {
        YearMonth yearMonth = this.yearMonth;
        return "Month(yearMonth=" + yearMonth + ", weekDays=" + this.weekDays + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Month(YearMonth yearMonth, List<? extends List<Day>> list) {
        Intrinsics.checkNotNullParameter(yearMonth, "yearMonth");
        Intrinsics.checkNotNullParameter(list, "weekDays");
        this.yearMonth = yearMonth;
        this.weekDays = list;
    }

    public final YearMonth getYearMonth() {
        return this.yearMonth;
    }

    public final List<List<Day>> getWeekDays() {
        return this.weekDays;
    }
}