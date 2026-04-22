package kotlinx.datetime;

import j$.time.Period;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Converters.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0006*\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\f*\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\u0012*\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u001a\u001a\u00020\u0019*\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u0018*\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0011\u0010 \u001a\u00020\u001f*\u00020\u001e¢\u0006\u0004\b \u0010!\u001a\u0011\u0010\"\u001a\u00020\u001e*\u00020\u001f¢\u0006\u0004\b\"\u0010#\u001a\u0011\u0010&\u001a\u00020%*\u00020$¢\u0006\u0004\b&\u0010'\u001a\u0011\u0010(\u001a\u00020$*\u00020%¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010*\u001a\u00020$*\u00020%H\u0007¢\u0006\u0004\b*\u0010)\u001a\u0011\u0010&\u001a\u00020%*\u00020+¢\u0006\u0004\b&\u0010,\u001a\u0011\u0010-\u001a\u00020+*\u00020%¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lkotlinx/datetime/Instant;", "j$/time/Instant", "toJavaInstant", "(Lkotlinx/datetime/Instant;)Lj$/time/Instant;", "toKotlinInstant", "(Lj$/time/Instant;)Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/LocalDateTime;", "j$/time/LocalDateTime", "toJavaLocalDateTime", "(Lkotlinx/datetime/LocalDateTime;)Lj$/time/LocalDateTime;", "toKotlinLocalDateTime", "(Lj$/time/LocalDateTime;)Lkotlinx/datetime/LocalDateTime;", "Lkotlinx/datetime/LocalTime;", "j$/time/LocalTime", "toJavaLocalTime", "(Lkotlinx/datetime/LocalTime;)Lj$/time/LocalTime;", "toKotlinLocalTime", "(Lj$/time/LocalTime;)Lkotlinx/datetime/LocalTime;", "Lkotlinx/datetime/LocalDate;", "j$/time/LocalDate", "toJavaLocalDate", "(Lkotlinx/datetime/LocalDate;)Lj$/time/LocalDate;", "toKotlinLocalDate", "(Lj$/time/LocalDate;)Lkotlinx/datetime/LocalDate;", "Lkotlinx/datetime/DatePeriod;", "j$/time/Period", "toJavaPeriod", "(Lkotlinx/datetime/DatePeriod;)Lj$/time/Period;", "toKotlinDatePeriod", "(Lj$/time/Period;)Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/TimeZone;", "j$/time/ZoneId", "toJavaZoneId", "(Lkotlinx/datetime/TimeZone;)Lj$/time/ZoneId;", "toKotlinTimeZone", "(Lj$/time/ZoneId;)Lkotlinx/datetime/TimeZone;", "Lkotlinx/datetime/FixedOffsetTimeZone;", "j$/time/ZoneOffset", "toJavaZoneOffset", "(Lkotlinx/datetime/FixedOffsetTimeZone;)Lj$/time/ZoneOffset;", "toKotlinFixedOffsetTimeZone", "(Lj$/time/ZoneOffset;)Lkotlinx/datetime/FixedOffsetTimeZone;", "toKotlinZoneOffset", "Lkotlinx/datetime/UtcOffset;", "(Lkotlinx/datetime/UtcOffset;)Lj$/time/ZoneOffset;", "toKotlinUtcOffset", "(Lj$/time/ZoneOffset;)Lkotlinx/datetime/UtcOffset;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ConvertersKt {
    public static final j$.time.Instant toJavaInstant(Instant $this$toJavaInstant) {
        Intrinsics.checkNotNullParameter($this$toJavaInstant, "<this>");
        return $this$toJavaInstant.getValue$kotlinx_datetime();
    }

    public static final Instant toKotlinInstant(j$.time.Instant $this$toKotlinInstant) {
        Intrinsics.checkNotNullParameter($this$toKotlinInstant, "<this>");
        return new Instant($this$toKotlinInstant);
    }

    public static final j$.time.LocalDateTime toJavaLocalDateTime(LocalDateTime $this$toJavaLocalDateTime) {
        Intrinsics.checkNotNullParameter($this$toJavaLocalDateTime, "<this>");
        return $this$toJavaLocalDateTime.getValue$kotlinx_datetime();
    }

    public static final LocalDateTime toKotlinLocalDateTime(j$.time.LocalDateTime $this$toKotlinLocalDateTime) {
        Intrinsics.checkNotNullParameter($this$toKotlinLocalDateTime, "<this>");
        return new LocalDateTime($this$toKotlinLocalDateTime);
    }

    public static final j$.time.LocalTime toJavaLocalTime(LocalTime $this$toJavaLocalTime) {
        Intrinsics.checkNotNullParameter($this$toJavaLocalTime, "<this>");
        return $this$toJavaLocalTime.getValue$kotlinx_datetime();
    }

    public static final LocalTime toKotlinLocalTime(j$.time.LocalTime $this$toKotlinLocalTime) {
        Intrinsics.checkNotNullParameter($this$toKotlinLocalTime, "<this>");
        return new LocalTime($this$toKotlinLocalTime);
    }

    public static final j$.time.LocalDate toJavaLocalDate(LocalDate $this$toJavaLocalDate) {
        Intrinsics.checkNotNullParameter($this$toJavaLocalDate, "<this>");
        return $this$toJavaLocalDate.getValue$kotlinx_datetime();
    }

    public static final LocalDate toKotlinLocalDate(j$.time.LocalDate $this$toKotlinLocalDate) {
        Intrinsics.checkNotNullParameter($this$toKotlinLocalDate, "<this>");
        return new LocalDate($this$toKotlinLocalDate);
    }

    public static final Period toJavaPeriod(DatePeriod $this$toJavaPeriod) {
        Intrinsics.checkNotNullParameter($this$toJavaPeriod, "<this>");
        Period of = Period.of($this$toJavaPeriod.getYears(), $this$toJavaPeriod.getMonths(), $this$toJavaPeriod.getDays());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public static final DatePeriod toKotlinDatePeriod(Period $this$toKotlinDatePeriod) {
        Intrinsics.checkNotNullParameter($this$toKotlinDatePeriod, "<this>");
        return new DatePeriod($this$toKotlinDatePeriod.getYears(), $this$toKotlinDatePeriod.getMonths(), $this$toKotlinDatePeriod.getDays());
    }

    public static final ZoneId toJavaZoneId(TimeZone $this$toJavaZoneId) {
        Intrinsics.checkNotNullParameter($this$toJavaZoneId, "<this>");
        return $this$toJavaZoneId.getZoneId$kotlinx_datetime();
    }

    public static final TimeZone toKotlinTimeZone(ZoneId $this$toKotlinTimeZone) {
        Intrinsics.checkNotNullParameter($this$toKotlinTimeZone, "<this>");
        return TimeZone.Companion.ofZone$kotlinx_datetime($this$toKotlinTimeZone);
    }

    public static final ZoneOffset toJavaZoneOffset(FixedOffsetTimeZone $this$toJavaZoneOffset) {
        Intrinsics.checkNotNullParameter($this$toJavaZoneOffset, "<this>");
        return $this$toJavaZoneOffset.getOffset().getZoneOffset$kotlinx_datetime();
    }

    public static final FixedOffsetTimeZone toKotlinFixedOffsetTimeZone(ZoneOffset $this$toKotlinFixedOffsetTimeZone) {
        Intrinsics.checkNotNullParameter($this$toKotlinFixedOffsetTimeZone, "<this>");
        return new FixedOffsetTimeZone(new UtcOffset($this$toKotlinFixedOffsetTimeZone));
    }

    @Deprecated(message = "Use toKotlinFixedOffsetTimeZone() instead.", replaceWith = @ReplaceWith(expression = "this.toKotlinFixedOffsetTimeZone()", imports = {}))
    public static final FixedOffsetTimeZone toKotlinZoneOffset(ZoneOffset $this$toKotlinZoneOffset) {
        Intrinsics.checkNotNullParameter($this$toKotlinZoneOffset, "<this>");
        return toKotlinFixedOffsetTimeZone($this$toKotlinZoneOffset);
    }

    public static final ZoneOffset toJavaZoneOffset(UtcOffset $this$toJavaZoneOffset) {
        Intrinsics.checkNotNullParameter($this$toJavaZoneOffset, "<this>");
        return $this$toJavaZoneOffset.getZoneOffset$kotlinx_datetime();
    }

    public static final UtcOffset toKotlinUtcOffset(ZoneOffset $this$toKotlinUtcOffset) {
        Intrinsics.checkNotNullParameter($this$toKotlinUtcOffset, "<this>");
        return new UtcOffset($this$toKotlinUtcOffset);
    }
}