package kotlinx.datetime;

import kotlin.Metadata;

@Metadata(d1 = {"kotlinx/datetime/TimeZoneKt__TimeZoneJvmKt", "kotlinx/datetime/TimeZoneKt__TimeZoneKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class TimeZoneKt {
    public static final Instant atStartOfDayIn(LocalDate $this$atStartOfDayIn, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.atStartOfDayIn($this$atStartOfDayIn, timeZone);
    }

    public static final UtcOffset offsetAt(TimeZone $this$offsetAt, Instant instant) {
        return TimeZoneKt__TimeZoneJvmKt.offsetAt($this$offsetAt, instant);
    }

    public static final UtcOffset offsetIn(Instant $this$offsetIn, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneKt.offsetIn($this$offsetIn, timeZone);
    }

    public static final Instant toInstant(LocalDateTime $this$toInstant, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.toInstant($this$toInstant, timeZone);
    }

    public static final Instant toInstant(LocalDateTime $this$toInstant, UtcOffset offset) {
        return TimeZoneKt__TimeZoneJvmKt.toInstant($this$toInstant, offset);
    }

    public static final LocalDateTime toLocalDateTime(Instant $this$toLocalDateTime, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.toLocalDateTime($this$toLocalDateTime, timeZone);
    }

    public static final LocalDateTime toLocalDateTime(Instant $this$toLocalDateTime, UtcOffset offset) {
        return TimeZoneKt__TimeZoneJvmKt.toLocalDateTime($this$toLocalDateTime, offset);
    }
}