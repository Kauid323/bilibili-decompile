package kntr.app.upcomingEpisode.calendar.model;

import j$.time.DayOfWeek;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CalendarInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÂ\u0003J%\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/CalendarInfo;", "", "indexCount", "", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "<init>", "(ILjava/time/DayOfWeek;)V", "getIndexCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CalendarInfo {
    public static final int $stable = 0;
    private final DayOfWeek firstDayOfWeek;
    private final int indexCount;

    private final DayOfWeek component2() {
        return this.firstDayOfWeek;
    }

    public static /* synthetic */ CalendarInfo copy$default(CalendarInfo calendarInfo, int i, DayOfWeek dayOfWeek, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = calendarInfo.indexCount;
        }
        if ((i2 & 2) != 0) {
            dayOfWeek = calendarInfo.firstDayOfWeek;
        }
        return calendarInfo.copy(i, dayOfWeek);
    }

    public final int component1() {
        return this.indexCount;
    }

    public final CalendarInfo copy(int i, DayOfWeek dayOfWeek) {
        return new CalendarInfo(i, dayOfWeek);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarInfo) {
            CalendarInfo calendarInfo = (CalendarInfo) obj;
            return this.indexCount == calendarInfo.indexCount && this.firstDayOfWeek == calendarInfo.firstDayOfWeek;
        }
        return false;
    }

    public int hashCode() {
        return (this.indexCount * 31) + (this.firstDayOfWeek == null ? 0 : this.firstDayOfWeek.hashCode());
    }

    public String toString() {
        int i = this.indexCount;
        return "CalendarInfo(indexCount=" + i + ", firstDayOfWeek=" + this.firstDayOfWeek + ")";
    }

    public CalendarInfo(int indexCount, DayOfWeek firstDayOfWeek) {
        this.indexCount = indexCount;
        this.firstDayOfWeek = firstDayOfWeek;
    }

    public /* synthetic */ CalendarInfo(int i, DayOfWeek dayOfWeek, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : dayOfWeek);
    }

    public final int getIndexCount() {
        return this.indexCount;
    }
}