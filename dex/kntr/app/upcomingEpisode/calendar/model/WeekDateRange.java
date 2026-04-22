package kntr.app.upcomingEpisode.calendar.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: WeekData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/WeekDateRange;", "", "startDateAdjusted", "Lkotlinx/datetime/LocalDate;", "endDateAdjusted", "<init>", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;)V", "getStartDateAdjusted", "()Lkotlinx/datetime/LocalDate;", "getEndDateAdjusted", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WeekDateRange {
    public static final int $stable = 8;
    private final LocalDate endDateAdjusted;
    private final LocalDate startDateAdjusted;

    public static /* synthetic */ WeekDateRange copy$default(WeekDateRange weekDateRange, LocalDate localDate, LocalDate localDate2, int i, Object obj) {
        if ((i & 1) != 0) {
            localDate = weekDateRange.startDateAdjusted;
        }
        if ((i & 2) != 0) {
            localDate2 = weekDateRange.endDateAdjusted;
        }
        return weekDateRange.copy(localDate, localDate2);
    }

    public final LocalDate component1() {
        return this.startDateAdjusted;
    }

    public final LocalDate component2() {
        return this.endDateAdjusted;
    }

    public final WeekDateRange copy(LocalDate localDate, LocalDate localDate2) {
        Intrinsics.checkNotNullParameter(localDate, "startDateAdjusted");
        Intrinsics.checkNotNullParameter(localDate2, "endDateAdjusted");
        return new WeekDateRange(localDate, localDate2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WeekDateRange) {
            WeekDateRange weekDateRange = (WeekDateRange) obj;
            return Intrinsics.areEqual(this.startDateAdjusted, weekDateRange.startDateAdjusted) && Intrinsics.areEqual(this.endDateAdjusted, weekDateRange.endDateAdjusted);
        }
        return false;
    }

    public int hashCode() {
        return (this.startDateAdjusted.hashCode() * 31) + this.endDateAdjusted.hashCode();
    }

    public String toString() {
        LocalDate localDate = this.startDateAdjusted;
        return "WeekDateRange(startDateAdjusted=" + localDate + ", endDateAdjusted=" + this.endDateAdjusted + ")";
    }

    public WeekDateRange(LocalDate startDateAdjusted, LocalDate endDateAdjusted) {
        Intrinsics.checkNotNullParameter(startDateAdjusted, "startDateAdjusted");
        Intrinsics.checkNotNullParameter(endDateAdjusted, "endDateAdjusted");
        this.startDateAdjusted = startDateAdjusted;
        this.endDateAdjusted = endDateAdjusted;
    }

    public final LocalDate getStartDateAdjusted() {
        return this.startDateAdjusted;
    }

    public final LocalDate getEndDateAdjusted() {
        return this.endDateAdjusted;
    }
}