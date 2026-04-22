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

/* compiled from: Year.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/Year;", "", "value", "", "<init>", "(I)V", "getValue", "()I", "year", "getYear$main_debug", "compareTo", "other", "toString", "", "component1", "copy", "equals", "", "", "hashCode", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Year implements Comparable<Year> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int value;
    private final int year;

    public static /* synthetic */ Year copy$default(Year year, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = year.value;
        }
        return year.copy(i);
    }

    public final int component1() {
        return this.value;
    }

    public final Year copy(int i) {
        return new Year(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.value == ((Year) obj).value;
    }

    public int hashCode() {
        return this.value;
    }

    public Year(int value) {
        this.value = value;
        this.year = this.value;
        try {
            YearMonthKt.atStartOfMonth(YearKt.atMonth(this, MonthKt.Month(1)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Year value " + this.value + " is out of range", e);
        }
    }

    public final int getValue() {
        return this.value;
    }

    public final int getYear$main_debug() {
        return this.year;
    }

    @Override // java.lang.Comparable
    public int compareTo(Year other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value - other.value;
    }

    public String toString() {
        return DateFormatExtentionsKt.toIso8601String(this);
    }

    /* compiled from: Year.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lkntr/app/upcomingEpisode/calendar/model/Year$Companion;", "", "<init>", "()V", "now", "Lkntr/app/upcomingEpisode/calendar/model/Year;", "clock", "Lkotlinx/datetime/Clock;", "timeZone", "Lkotlinx/datetime/TimeZone;", "isLeap", "", "year", "", "parseIso8601", "string", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Year now$default(Companion companion, Clock clock, TimeZone timeZone, int i, Object obj) {
            if ((i & 1) != 0) {
                clock = (Clock) Clock.System.INSTANCE;
            }
            if ((i & 2) != 0) {
                timeZone = TimeZone.Companion.currentSystemDefault();
            }
            return companion.now(clock, timeZone);
        }

        public final Year now(Clock clock, TimeZone timeZone) {
            Intrinsics.checkNotNullParameter(clock, "clock");
            Intrinsics.checkNotNullParameter(timeZone, "timeZone");
            return new Year(BiliCalendarExtensionsKt.now(LocalDate.Companion, clock, timeZone).getYear());
        }

        public final boolean isLeap(int year) {
            long prolepticYear = year;
            return (3 & prolepticYear) == 0 && (prolepticYear % ((long) 100) != 0 || prolepticYear % ((long) ConstantsKt.UPCOMING_EP_LIST_DIALOG_DEFAULT_MIN_HEIGHT) == 0);
        }

        public final Year parseIso8601(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            try {
                return DateFormatExtentionsKt.fromIso8601Year(string);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid Year value " + string, e);
            }
        }
    }
}