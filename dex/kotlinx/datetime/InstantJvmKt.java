package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZonedDateTime;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.DivRemResult;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;

/* compiled from: Instant.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\r\u001a)\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\u0010\u001a)\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0010\u001a)\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\u0013\u001a!\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0014¢\u0006\u0004\b\t\u0010\u0015\u001a!\u0010\u0017\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\u0019\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/TimeZone;", "zone", "j$/time/ZonedDateTime", "atZone", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/TimeZone;)Lj$/time/ZonedDateTime;", "Lkotlinx/datetime/DateTimePeriod;", "period", "timeZone", "plus", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/DateTimePeriod;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/DateTimeUnit;", "unit", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/DateTimeUnit;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/Instant;", "", "value", "(Lkotlinx/datetime/Instant;ILkotlinx/datetime/DateTimeUnit;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/Instant;", "minus", "", "(Lkotlinx/datetime/Instant;JLkotlinx/datetime/DateTimeUnit;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "(Lkotlinx/datetime/Instant;JLkotlinx/datetime/DateTimeUnit$TimeBased;)Lkotlinx/datetime/Instant;", "other", "periodUntil", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/DateTimePeriod;", "until", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkotlinx/datetime/DateTimeUnit;Lkotlinx/datetime/TimeZone;)J", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class InstantJvmKt {
    private static final ZonedDateTime atZone(Instant $this$atZone, TimeZone zone) {
        try {
            ZonedDateTime atZone = $this$atZone.getValue$kotlinx_datetime().atZone(zone.getZoneId$kotlinx_datetime());
            Intrinsics.checkNotNull(atZone);
            return atZone;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant plus(Instant $this$plus, DateTimePeriod period, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime thisZdt = atZone($this$plus, timeZone);
            ZonedDateTime $this$plus_u24lambda_u243_u24lambda_u240 = thisZdt;
            if (period.getTotalMonths$kotlinx_datetime() != 0) {
                $this$plus_u24lambda_u243_u24lambda_u240 = $this$plus_u24lambda_u243_u24lambda_u240.plusMonths(period.getTotalMonths$kotlinx_datetime());
            }
            if (period.getDays() != 0) {
                $this$plus_u24lambda_u243_u24lambda_u240 = $this$plus_u24lambda_u243_u24lambda_u240.plusDays(period.getDays());
            }
            if (period.getTotalNanoseconds$kotlinx_datetime() != 0) {
                $this$plus_u24lambda_u243_u24lambda_u240 = $this$plus_u24lambda_u243_u24lambda_u240.plusNanos(period.getTotalNanoseconds$kotlinx_datetime());
            }
            j$.time.Instant p0 = $this$plus_u24lambda_u243_u24lambda_u240.toInstant();
            return new Instant(p0);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit, timeZone)", imports = {}))
    public static final Instant plus(Instant $this$plus, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus($this$plus, 1L, unit, timeZone);
    }

    public static final Instant plus(Instant $this$plus, int value, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus($this$plus, value, unit, timeZone);
    }

    public static final Instant minus(Instant $this$minus, int value, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus($this$minus, -value, unit, timeZone);
    }

    public static final Instant plus(Instant $this$plus, long value, DateTimeUnit unit, TimeZone timeZone) {
        j$.time.Instant it;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime thisZdt = atZone($this$plus, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                it = plus($this$plus, value, (DateTimeUnit.TimeBased) unit).getValue$kotlinx_datetime();
                it.atZone(timeZone.getZoneId$kotlinx_datetime());
            } else if (unit instanceof DateTimeUnit.DayBased) {
                it = thisZdt.plusDays(MathJvmKt.safeMultiply(value, ((DateTimeUnit.DayBased) unit).getDays())).toInstant();
            } else if (unit instanceof DateTimeUnit.MonthBased) {
                it = thisZdt.plusMonths(MathJvmKt.safeMultiply(value, ((DateTimeUnit.MonthBased) unit).getMonths())).toInstant();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Instant(it);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                throw new DateTimeArithmeticException("Instant " + $this$plus + " cannot be represented as local date when adding " + value + ' ' + unit + " to it", e);
            }
            throw e;
        }
    }

    public static final Instant plus(Instant $this$plus, long value, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            DivRemResult multiplyAndDivide = MathKt.multiplyAndDivide(value, unit.getNanoseconds(), 1000000000L);
            long d = multiplyAndDivide.component1();
            long r = multiplyAndDivide.component2();
            j$.time.Instant plusNanos = $this$plus.getValue$kotlinx_datetime().plusSeconds(d).plusNanos(r);
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                return value > 0 ? Instant.Companion.getMAX$kotlinx_datetime() : Instant.Companion.getMIN$kotlinx_datetime();
            }
            throw e;
        }
    }

    public static final DateTimePeriod periodUntil(Instant $this$periodUntil, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$periodUntil, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        ZonedDateTime thisZdt = atZone($this$periodUntil, timeZone);
        Temporal atZone = atZone(other, timeZone);
        long months = thisZdt.until(atZone, ChronoUnit.MONTHS);
        ZonedDateTime thisZdt2 = thisZdt.plusMonths(months);
        Intrinsics.checkNotNullExpressionValue(thisZdt2, "plusMonths(...)");
        long days = thisZdt2.until(atZone, ChronoUnit.DAYS);
        ZonedDateTime thisZdt3 = thisZdt2.plusDays(days);
        Intrinsics.checkNotNullExpressionValue(thisZdt3, "plusDays(...)");
        long nanoseconds = thisZdt3.until(atZone, ChronoUnit.NANOS);
        if (months > 2147483647L || months < -2147483648L) {
            throw new DateTimeArithmeticException("The number of months between " + $this$periodUntil + " and " + other + " does not fit in an Int");
        }
        return DateTimePeriodKt.buildDateTimePeriod((int) months, (int) days, nanoseconds);
    }

    public static final long until(Instant $this$until, Instant other, DateTimeUnit unit, TimeZone timeZone) {
        long until;
        Intrinsics.checkNotNullParameter($this$until, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime thisZdt = atZone($this$until, timeZone);
            Temporal atZone = atZone(other, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                until = InstantKt.until($this$until, other, (DateTimeUnit.TimeBased) unit);
            } else if (unit instanceof DateTimeUnit.DayBased) {
                until = thisZdt.until(atZone, ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays();
            } else if (!(unit instanceof DateTimeUnit.MonthBased)) {
                throw new NoWhenBranchMatchedException();
            } else {
                until = thisZdt.until(atZone, ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths();
            }
            return until;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        } catch (ArithmeticException e2) {
            return $this$until.getValue$kotlinx_datetime().compareTo(other.getValue$kotlinx_datetime()) < 0 ? LongCompanionObject.MAX_VALUE : Long.MIN_VALUE;
        }
    }
}