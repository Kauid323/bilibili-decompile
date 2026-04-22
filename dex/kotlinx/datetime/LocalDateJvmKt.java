package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;

/* compiled from: LocalDate.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0007\u001a!\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0007\u001a!\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\n\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0011\u001a\u0019\u0010\u0013\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0019\u0010\u001a\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lkotlinx/datetime/LocalDate;", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "unit", "plus", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/DateTimeUnit$DateBased;)Lkotlinx/datetime/LocalDate;", "", "value", "(Lkotlinx/datetime/LocalDate;ILkotlinx/datetime/DateTimeUnit$DateBased;)Lkotlinx/datetime/LocalDate;", "minus", "", "(Lkotlinx/datetime/LocalDate;JLkotlinx/datetime/DateTimeUnit$DateBased;)Lkotlinx/datetime/LocalDate;", "epochDay", "j$/time/LocalDate", "ofEpochDayChecked", "(J)Lj$/time/LocalDate;", "Lkotlinx/datetime/DatePeriod;", "period", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/DatePeriod;)Lkotlinx/datetime/LocalDate;", "other", "periodUntil", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;)Lkotlinx/datetime/DatePeriod;", "until", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/DateTimeUnit$DateBased;)I", "daysUntil", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;)I", "monthsUntil", "yearsUntil", "minEpochDay", "J", "maxEpochDay", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocalDateJvmKt {
    private static final long minEpochDay = j$.time.LocalDate.MIN.toEpochDay();
    private static final long maxEpochDay = j$.time.LocalDate.MAX.toEpochDay();

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit)", imports = {}))
    public static final LocalDate plus(LocalDate $this$plus, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus($this$plus, 1L, unit);
    }

    public static final LocalDate plus(LocalDate $this$plus, int value, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus($this$plus, value, unit);
    }

    public static final LocalDate minus(LocalDate $this$minus, int value, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus($this$minus, -value, unit);
    }

    public static final LocalDate plus(LocalDate $this$plus, long value, DateTimeUnit.DateBased unit) {
        j$.time.LocalDate plusMonths;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            if (unit instanceof DateTimeUnit.DayBased) {
                long addDays = MathJvmKt.safeMultiply(value, ((DateTimeUnit.DayBased) unit).getDays());
                plusMonths = ofEpochDayChecked(MathJvmKt.safeAdd($this$plus.getValue$kotlinx_datetime().toEpochDay(), addDays));
            } else if (unit instanceof DateTimeUnit.MonthBased) {
                plusMonths = $this$plus.getValue$kotlinx_datetime().plusMonths(MathJvmKt.safeMultiply(value, ((DateTimeUnit.MonthBased) unit).getMonths()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            j$.time.LocalDate p0 = plusMonths;
            return new LocalDate(p0);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                throw new DateTimeArithmeticException("The result of adding " + value + " of " + unit + " to " + $this$plus + " is out of LocalDate range.", e);
            }
            throw e;
        }
    }

    private static final j$.time.LocalDate ofEpochDayChecked(long epochDay) {
        long j = minEpochDay;
        boolean z = false;
        if (epochDay <= maxEpochDay && j <= epochDay) {
            z = true;
        }
        if (!z) {
            throw new DateTimeException("The resulting day " + epochDay + " is out of supported LocalDate range.");
        }
        j$.time.LocalDate ofEpochDay = j$.time.LocalDate.ofEpochDay(epochDay);
        Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
        return ofEpochDay;
    }

    public static final LocalDate plus(LocalDate $this$plus, DatePeriod period) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        try {
            j$.time.LocalDate $this$plus_u24lambda_u242_u24lambda_u240 = $this$plus.getValue$kotlinx_datetime();
            if (period.getTotalMonths$kotlinx_datetime() != 0) {
                $this$plus_u24lambda_u242_u24lambda_u240 = $this$plus_u24lambda_u242_u24lambda_u240.plusMonths(period.getTotalMonths$kotlinx_datetime());
            }
            if (period.getDays() != 0) {
                $this$plus_u24lambda_u242_u24lambda_u240 = $this$plus_u24lambda_u242_u24lambda_u240.plusDays(period.getDays());
            }
            j$.time.LocalDate p0 = $this$plus_u24lambda_u242_u24lambda_u240;
            return new LocalDate(p0);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException("The result of adding " + $this$plus.getValue$kotlinx_datetime() + " to " + $this$plus + " is out of LocalDate range.");
        }
    }

    public static final DatePeriod periodUntil(LocalDate $this$periodUntil, LocalDate other) {
        Intrinsics.checkNotNullParameter($this$periodUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        j$.time.LocalDate startD = $this$periodUntil.getValue$kotlinx_datetime();
        Temporal value$kotlinx_datetime = other.getValue$kotlinx_datetime();
        long months = startD.until(value$kotlinx_datetime, ChronoUnit.MONTHS);
        j$.time.LocalDate startD2 = startD.plusMonths(months);
        Intrinsics.checkNotNullExpressionValue(startD2, "plusMonths(...)");
        long days = startD2.until(value$kotlinx_datetime, ChronoUnit.DAYS);
        if (months > 2147483647L || months < -2147483648L) {
            throw new DateTimeArithmeticException("The number of months between " + $this$periodUntil + " and " + other + " does not fit in an Int");
        }
        return new DatePeriod((int) months, (int) days);
    }

    public static final int until(LocalDate $this$until, LocalDate other, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter($this$until, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit instanceof DateTimeUnit.MonthBased) {
            return MathKt.clampToInt($this$until.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths());
        }
        if (unit instanceof DateTimeUnit.DayBased) {
            return MathKt.clampToInt($this$until.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int daysUntil(LocalDate $this$daysUntil, LocalDate other) {
        Intrinsics.checkNotNullParameter($this$daysUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt($this$daysUntil.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.DAYS));
    }

    public static final int monthsUntil(LocalDate $this$monthsUntil, LocalDate other) {
        Intrinsics.checkNotNullParameter($this$monthsUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt($this$monthsUntil.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.MONTHS));
    }

    public static final int yearsUntil(LocalDate $this$yearsUntil, LocalDate other) {
        Intrinsics.checkNotNullParameter($this$yearsUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt($this$yearsUntil.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.YEARS));
    }
}