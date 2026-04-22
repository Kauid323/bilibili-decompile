package kntr.app.upcomingEpisode.calendar.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.calendar.utils.BiliCalendarExtensionsKt;
import kntr.app.upcomingEpisode.calendar.utils.DateFormatExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.MonthKt;
import kotlinx.datetime.TimeZone;

/* compiled from: YearMonth.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\nJ\u0011\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\r\u0010\u0015\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "", "year", "", "month", "Ljava/time/Month;", "Lkotlinx/datetime/Month;", "<init>", "(ILjava/time/Month;)V", "monthNumber", "(II)V", "getYear", "()I", "getMonth", "()Ljava/time/Month;", "getMonthNumber", "compareTo", "other", "toString", "", "component1", "component2", "copy", "equals", "", "", "hashCode", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class YearMonth implements Comparable<YearMonth> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final j$.time.Month month;
    private final int year;

    public static /* synthetic */ YearMonth copy$default(YearMonth yearMonth, int i, j$.time.Month month, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yearMonth.year;
        }
        if ((i2 & 2) != 0) {
            month = yearMonth.month;
        }
        return yearMonth.copy(i, month);
    }

    public final int component1() {
        return this.year;
    }

    public final j$.time.Month component2() {
        return this.month;
    }

    public final YearMonth copy(int i, j$.time.Month month) {
        Intrinsics.checkNotNullParameter(month, "month");
        return new YearMonth(i, month);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YearMonth) {
            YearMonth yearMonth = (YearMonth) obj;
            return this.year == yearMonth.year && this.month == yearMonth.month;
        }
        return false;
    }

    public int hashCode() {
        return (this.year * 31) + this.month.hashCode();
    }

    public YearMonth(int year, j$.time.Month month) {
        Intrinsics.checkNotNullParameter(month, "month");
        this.year = year;
        this.month = month;
        try {
            YearMonthKt.atStartOfMonth(this);
        } catch (IllegalArgumentException e) {
            int number = MonthKt.getNumber(this.month);
            throw new IllegalArgumentException("YearMonth value " + number + "-" + this.year + " is out of range", e);
        }
    }

    public final int getYear() {
        return this.year;
    }

    public final j$.time.Month getMonth() {
        return this.month;
    }

    public YearMonth(int year, int monthNumber) {
        this(year, MonthKt.Month(monthNumber));
    }

    public final int getMonthNumber() {
        return MonthKt.getNumber(this.month);
    }

    @Override // java.lang.Comparable
    public int compareTo(YearMonth other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int cmp = this.year - other.year;
        if (cmp == 0) {
            return MonthKt.getNumber(this.month) - MonthKt.getNumber(other.month);
        }
        return cmp;
    }

    /* compiled from: YearMonth.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/YearMonth$Companion;", "", "<init>", "()V", "now", "Lkntr/app/upcomingEpisode/calendar/model/YearMonth;", "clock", "Lkotlinx/datetime/Clock;", "timeZone", "Lkotlinx/datetime/TimeZone;", "parseIso8601", "string", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ YearMonth now$default(Companion companion, Clock clock, TimeZone timeZone, int i, Object obj) {
            if ((i & 1) != 0) {
                clock = (Clock) Clock.System.INSTANCE;
            }
            if ((i & 2) != 0) {
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.now(clock, timeZone);
        }

        public final YearMonth now(Clock clock, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(clock, "clock");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            return BiliCalendarExtensionsKt.getYearMonth(BiliCalendarExtensionsKt.now(LocalDate.Companion, clock, timeZone));
        }

        public final YearMonth parseIso8601(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            try {
                return DateFormatExtentionsKt.fromIso8601YearMonth(string);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid YearMonth value " + string, e);
            }
        }
    }

    public String toString() {
        return DateFormatExtentionsKt.toIso8601String(this);
    }
}