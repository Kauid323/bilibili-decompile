package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeZoneJvm.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\b\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u000e\u001a\u0019\u0010\u0010\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0016\u001a\u00020\u0013*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/TimeZone;", "Lkotlinx/datetime/Instant;", "instant", "Lkotlinx/datetime/UtcOffset;", "offsetAt", "(Lkotlinx/datetime/TimeZone;Lkotlinx/datetime/Instant;)Lkotlinx/datetime/UtcOffset;", "timeZone", "Lkotlinx/datetime/LocalDateTime;", "toLocalDateTime", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/LocalDateTime;", "offset", "(Lkotlinx/datetime/Instant;Lkotlinx/datetime/UtcOffset;)Lkotlinx/datetime/LocalDateTime;", "toInstant", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/Instant;", "(Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/UtcOffset;)Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/LocalDate;", "atStartOfDayIn", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/TimeZone;)Lkotlinx/datetime/Instant;", "j$/time/ZoneId", "", "isFixedOffset$TimeZoneKt__TimeZoneJvmKt", "(Lj$/time/ZoneId;)Z", "isFixedOffset", "kotlinx-datetime"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/datetime/TimeZoneKt")
public final /* synthetic */ class TimeZoneKt__TimeZoneJvmKt {
    public static final boolean isFixedOffset$TimeZoneKt__TimeZoneJvmKt(ZoneId $this$isFixedOffset) {
        try {
            return $this$isFixedOffset.getRules().isFixedOffset();
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static final UtcOffset offsetAt(TimeZone $this$offsetAt, Instant instant) {
        Intrinsics.checkNotNullParameter($this$offsetAt, "<this>");
        Intrinsics.checkNotNullParameter(instant, "instant");
        ZoneOffset p0 = $this$offsetAt.getZoneId$kotlinx_datetime().getRules().getOffset(instant.getValue$kotlinx_datetime());
        return new UtcOffset(p0);
    }

    public static final LocalDateTime toLocalDateTime(Instant $this$toLocalDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$toLocalDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            j$.time.LocalDateTime p0 = j$.time.LocalDateTime.ofInstant($this$toLocalDateTime.getValue$kotlinx_datetime(), timeZone.getZoneId$kotlinx_datetime());
            return new LocalDateTime(p0);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final LocalDateTime toLocalDateTime(Instant $this$toLocalDateTime, UtcOffset offset) {
        Intrinsics.checkNotNullParameter($this$toLocalDateTime, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        try {
            j$.time.LocalDateTime p0 = j$.time.LocalDateTime.ofInstant($this$toLocalDateTime.getValue$kotlinx_datetime(), offset.getZoneOffset$kotlinx_datetime());
            return new LocalDateTime(p0);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant toInstant(LocalDateTime $this$toInstant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$toInstant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        j$.time.Instant p0 = $this$toInstant.getValue$kotlinx_datetime().atZone(timeZone.getZoneId$kotlinx_datetime()).toInstant();
        return new Instant(p0);
    }

    public static final Instant toInstant(LocalDateTime $this$toInstant, UtcOffset offset) {
        Intrinsics.checkNotNullParameter($this$toInstant, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        j$.time.Instant p0 = $this$toInstant.getValue$kotlinx_datetime().toInstant(offset.getZoneOffset$kotlinx_datetime());
        return new Instant(p0);
    }

    public static final Instant atStartOfDayIn(LocalDate $this$atStartOfDayIn, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter($this$atStartOfDayIn, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        j$.time.Instant p0 = $this$atStartOfDayIn.getValue$kotlinx_datetime().atStartOfDay(timeZone.getZoneId$kotlinx_datetime()).toInstant();
        return new Instant(p0);
    }
}