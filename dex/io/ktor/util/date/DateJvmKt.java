package io.ktor.util.date;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateJvm.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a=\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u0002*\u00020\u000e2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0012\u001a\u00020\u0011*\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u001c\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"", "timestamp", "Lio/ktor/util/date/GMTDate;", "GMTDate", "(Ljava/lang/Long;)Lio/ktor/util/date/GMTDate;", "", "seconds", "minutes", "hours", "dayOfMonth", "Lio/ktor/util/date/Month;", "month", "year", "(IIIILio/ktor/util/date/Month;I)Lio/ktor/util/date/GMTDate;", "Ljava/util/Calendar;", "toDate", "(Ljava/util/Calendar;Ljava/lang/Long;)Lio/ktor/util/date/GMTDate;", "Ljava/util/Date;", "toJvmDate", "(Lio/ktor/util/date/GMTDate;)Ljava/util/Date;", "getTimeMillis", "()J", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "GMT_TIMEZONE", "Ljava/util/TimeZone;", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DateJvmKt {
    private static final TimeZone GMT_TIMEZONE = DesugarTimeZone.getTimeZone("GMT");

    public static /* synthetic */ GMTDate GMTDate$default(Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return GMTDate(l);
    }

    public static final GMTDate GMTDate(Long timestamp) {
        Calendar calendar = Calendar.getInstance(GMT_TIMEZONE, Locale.ROOT);
        Intrinsics.checkNotNull(calendar);
        return toDate(calendar, timestamp);
    }

    public static final GMTDate GMTDate(int seconds, int minutes, int hours, int dayOfMonth, Month month, int year) {
        Intrinsics.checkNotNullParameter(month, "month");
        Calendar $this$GMTDate_u24lambda_u240 = Calendar.getInstance(GMT_TIMEZONE, Locale.ROOT);
        Intrinsics.checkNotNull($this$GMTDate_u24lambda_u240);
        $this$GMTDate_u24lambda_u240.set(1, year);
        $this$GMTDate_u24lambda_u240.set(2, month.ordinal());
        $this$GMTDate_u24lambda_u240.set(5, dayOfMonth);
        $this$GMTDate_u24lambda_u240.set(11, hours);
        $this$GMTDate_u24lambda_u240.set(12, minutes);
        $this$GMTDate_u24lambda_u240.set(13, seconds);
        $this$GMTDate_u24lambda_u240.set(14, 0);
        return toDate($this$GMTDate_u24lambda_u240, null);
    }

    public static final GMTDate toDate(Calendar $this$toDate, Long timestamp) {
        Intrinsics.checkNotNullParameter($this$toDate, "<this>");
        if (timestamp != null) {
            long it = timestamp.longValue();
            $this$toDate.setTimeInMillis(it);
        }
        int timeZoneOffset = $this$toDate.get(15) + $this$toDate.get(16);
        int seconds = $this$toDate.get(13);
        int minutes = $this$toDate.get(12);
        int hours = $this$toDate.get(11);
        int numberOfDay = (($this$toDate.get(7) + 7) - 2) % 7;
        WeekDay dayOfWeek = WeekDay.Companion.from(numberOfDay);
        int dayOfMonth = $this$toDate.get(5);
        int dayOfYear = $this$toDate.get(6);
        Month month = Month.Companion.from($this$toDate.get(2));
        int year = $this$toDate.get(1);
        return new GMTDate(seconds, minutes, hours, dayOfWeek, dayOfMonth, dayOfYear, month, year, $this$toDate.getTimeInMillis() + timeZoneOffset);
    }

    public static final Date toJvmDate(GMTDate $this$toJvmDate) {
        Intrinsics.checkNotNullParameter($this$toJvmDate, "<this>");
        return new Date($this$toJvmDate.getTimestamp());
    }

    public static final long getTimeMillis() {
        return System.currentTimeMillis();
    }
}