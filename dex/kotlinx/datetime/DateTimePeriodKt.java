package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;

/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n\u001a$\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a(\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\u0002\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0007\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0012H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"DateTimePeriod", "Lkotlinx/datetime/DateTimePeriod;", "years", "", "months", "days", "hours", "minutes", "seconds", "nanoseconds", "", "buildDateTimePeriod", "totalMonths", "totalNanoseconds", "plus", "Lkotlinx/datetime/DatePeriod;", "other", "toDatePeriod", "", "toDateTimePeriod", "Lkotlin/time/Duration;", "toDateTimePeriod-LRDsOJo", "(J)Lkotlinx/datetime/DateTimePeriod;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DateTimePeriodKt {
    public static final /* synthetic */ int access$totalMonths(int years, int months) {
        return totalMonths(years, months);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "DateTimePeriod.parse(this)", imports = {}))
    public static final DateTimePeriod toDateTimePeriod(String $this$toDateTimePeriod) {
        Intrinsics.checkNotNullParameter($this$toDateTimePeriod, "<this>");
        return DateTimePeriod.Companion.parse($this$toDateTimePeriod);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "DatePeriod.parse(this)", imports = {}))
    public static final DatePeriod toDatePeriod(String $this$toDatePeriod) {
        Intrinsics.checkNotNullParameter($this$toDatePeriod, "<this>");
        return DatePeriod.Companion.parse($this$toDatePeriod);
    }

    public static final int totalMonths(int years, int months) {
        long totalMonths = (years * 12) + months;
        boolean z = false;
        if (-2147483648L <= totalMonths && totalMonths <= 2147483647L) {
            z = true;
        }
        if (z) {
            return (int) totalMonths;
        }
        throw new IllegalArgumentException("The total number of months in " + years + " years and " + months + " months overflows an Int");
    }

    private static final long totalNanoseconds(int hours, int minutes, int seconds, long nanoseconds) {
        long j = 60;
        long totalMinutes = (hours * j) + minutes;
        long totalMinutesAsSeconds = j * totalMinutes;
        long j2 = 1000000000;
        long minutesAndNanosecondsAsSeconds = (nanoseconds / j2) + totalMinutesAsSeconds;
        long totalSeconds = seconds + minutesAndNanosecondsAsSeconds;
        try {
            return MathKt.multiplyAndAdd(totalSeconds, 1000000000L, nanoseconds % j2);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("The total number of nanoseconds in " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds, and " + nanoseconds + " nanoseconds overflows a Long");
        }
    }

    public static /* synthetic */ DateTimePeriod buildDateTimePeriod$default(int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return buildDateTimePeriod(i, i2, j);
    }

    public static final DateTimePeriod buildDateTimePeriod(int totalMonths, int days, long totalNanoseconds) {
        if (totalNanoseconds != 0) {
            return new DateTimePeriodImpl(totalMonths, days, totalNanoseconds);
        }
        return new DatePeriod(totalMonths, days);
    }

    public static /* synthetic */ DateTimePeriod DateTimePeriod$default(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = 0;
        }
        if ((i7 & 2) != 0) {
            i2 = 0;
        }
        if ((i7 & 4) != 0) {
            i3 = 0;
        }
        if ((i7 & 8) != 0) {
            i4 = 0;
        }
        if ((i7 & 16) != 0) {
            i5 = 0;
        }
        if ((i7 & 32) != 0) {
            i6 = 0;
        }
        if ((i7 & 64) != 0) {
            j = 0;
        }
        return DateTimePeriod(i, i2, i3, i4, i5, i6, j);
    }

    public static final DateTimePeriod DateTimePeriod(int years, int months, int days, int hours, int minutes, int seconds, long nanoseconds) {
        return buildDateTimePeriod(totalMonths(years, months), days, totalNanoseconds(hours, minutes, seconds, nanoseconds));
    }

    /* renamed from: toDateTimePeriod-LRDsOJo */
    public static final DateTimePeriod m1476toDateTimePeriodLRDsOJo(long $this$toDateTimePeriod_u2dLRDsOJo) {
        return buildDateTimePeriod$default(0, 0, Duration.m1258getInWholeNanosecondsimpl($this$toDateTimePeriod_u2dLRDsOJo), 3, null);
    }

    public static final DateTimePeriod plus(DateTimePeriod $this$plus, DateTimePeriod other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return buildDateTimePeriod(MathJvmKt.safeAdd($this$plus.getTotalMonths$kotlinx_datetime(), other.getTotalMonths$kotlinx_datetime()), MathJvmKt.safeAdd($this$plus.getDays(), other.getDays()), MathJvmKt.safeAdd($this$plus.getTotalNanoseconds$kotlinx_datetime(), other.getTotalNanoseconds$kotlinx_datetime()));
    }

    public static final DatePeriod plus(DatePeriod $this$plus, DatePeriod other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new DatePeriod(MathJvmKt.safeAdd($this$plus.getTotalMonths$kotlinx_datetime(), other.getTotalMonths$kotlinx_datetime()), MathJvmKt.safeAdd($this$plus.getDays(), other.getDays()));
    }
}