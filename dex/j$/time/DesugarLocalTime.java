package j$.time;

import j$.util.Objects;

public final class DesugarLocalTime {
    static final long NANOS_PER_SECOND = 1000000000;
    static final int SECONDS_PER_DAY = 86400;

    private DesugarLocalTime() {
    }

    public static long toEpochSecond(LocalTime receiver, LocalDate date, ZoneOffset offset) {
        Objects.requireNonNull(date, "date");
        Objects.requireNonNull(offset, "offset");
        long epochDay = date.toEpochDay();
        long secs = (86400 * epochDay) + receiver.toSecondOfDay();
        return secs - offset.getTotalSeconds();
    }

    public static LocalTime ofInstant(Instant instant, ZoneId zone) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zone, "zone");
        ZoneOffset offset = zone.getRules().getOffset(instant);
        long localSecond = instant.getEpochSecond() + offset.getTotalSeconds();
        int secsOfDay = DesugarLocalTime$$ExternalSyntheticBackport0.m(localSecond, SECONDS_PER_DAY);
        return LocalTime.ofNanoOfDay((secsOfDay * NANOS_PER_SECOND) + instant.getNano());
    }
}