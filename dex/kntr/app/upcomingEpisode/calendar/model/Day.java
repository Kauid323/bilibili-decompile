package kntr.app.upcomingEpisode.calendar.model;

import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: Day.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/Day;", "", "date", "Lkotlinx/datetime/LocalDate;", "position", "Lkntr/app/upcomingEpisode/calendar/model/DayPosition;", "pointType", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "<init>", "(Lkotlinx/datetime/LocalDate;Lkntr/app/upcomingEpisode/calendar/model/DayPosition;Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;)V", "getDate", "()Lkotlinx/datetime/LocalDate;", "getPosition", "()Lkntr/app/upcomingEpisode/calendar/model/DayPosition;", "getPointType", "()Lcom/bapis/bilibili/community/interfacess/watch/v1/KCalendarPointType;", "copyWithPointType", "newType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Day {
    public static final int $stable = 0;
    private final LocalDate date;
    private final KCalendarPointType pointType;
    private final DayPosition position;

    public static /* synthetic */ Day copy$default(Day day, LocalDate localDate, DayPosition dayPosition, KCalendarPointType kCalendarPointType, int i, Object obj) {
        if ((i & 1) != 0) {
            localDate = day.date;
        }
        if ((i & 2) != 0) {
            dayPosition = day.position;
        }
        if ((i & 4) != 0) {
            kCalendarPointType = day.pointType;
        }
        return day.copy(localDate, dayPosition, kCalendarPointType);
    }

    public final LocalDate component1() {
        return this.date;
    }

    public final DayPosition component2() {
        return this.position;
    }

    public final KCalendarPointType component3() {
        return this.pointType;
    }

    public final Day copy(LocalDate localDate, DayPosition dayPosition, KCalendarPointType kCalendarPointType) {
        Intrinsics.checkNotNullParameter(localDate, "date");
        Intrinsics.checkNotNullParameter(dayPosition, "position");
        Intrinsics.checkNotNullParameter(kCalendarPointType, "pointType");
        return new Day(localDate, dayPosition, kCalendarPointType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Day) {
            Day day = (Day) obj;
            return Intrinsics.areEqual(this.date, day.date) && this.position == day.position && Intrinsics.areEqual(this.pointType, day.pointType);
        }
        return false;
    }

    public int hashCode() {
        return (((this.date.hashCode() * 31) + this.position.hashCode()) * 31) + this.pointType.hashCode();
    }

    public String toString() {
        LocalDate localDate = this.date;
        DayPosition dayPosition = this.position;
        return "Day(date=" + localDate + ", position=" + dayPosition + ", pointType=" + this.pointType + ")";
    }

    public Day(LocalDate date, DayPosition position, KCalendarPointType pointType) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(pointType, "pointType");
        this.date = date;
        this.position = position;
        this.pointType = pointType;
    }

    public /* synthetic */ Day(LocalDate localDate, DayPosition dayPosition, KCalendarPointType kCalendarPointType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(localDate, dayPosition, (i & 4) != 0 ? (KCalendarPointType) KCalendarPointType.CALENDAR_POINT_TYPE_DEFAULT.INSTANCE : kCalendarPointType);
    }

    public final LocalDate getDate() {
        return this.date;
    }

    public final DayPosition getPosition() {
        return this.position;
    }

    public final KCalendarPointType getPointType() {
        return this.pointType;
    }

    public final Day copyWithPointType(KCalendarPointType newType) {
        Intrinsics.checkNotNullParameter(newType, "newType");
        return copy$default(this, null, null, newType, 3, null);
    }
}