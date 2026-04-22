package kntr.app.upcomingEpisode.calendar.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Week.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/Week;", "", "days", "", "Lkntr/app/upcomingEpisode/calendar/model/WeekDay;", "<init>", "(Ljava/util/List;)V", "getDays", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Week {
    public static final int $stable = 0;
    private final List<WeekDay> days;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Week copy$default(Week week, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = week.days;
        }
        return week.copy(list);
    }

    public final List<WeekDay> component1() {
        return this.days;
    }

    public final Week copy(List<WeekDay> list) {
        Intrinsics.checkNotNullParameter(list, "days");
        return new Week(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Week) && Intrinsics.areEqual(this.days, ((Week) obj).days);
    }

    public int hashCode() {
        return this.days.hashCode();
    }

    public String toString() {
        return "Week(days=" + this.days + ")";
    }

    public Week(List<WeekDay> list) {
        Intrinsics.checkNotNullParameter(list, "days");
        this.days = list;
    }

    public final List<WeekDay> getDays() {
        return this.days;
    }
}