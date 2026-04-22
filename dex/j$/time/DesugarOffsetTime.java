package j$.time;

import j$.util.Objects;

public final class DesugarOffsetTime {
    private DesugarOffsetTime() {
    }

    public static long toEpochSecond(OffsetTime receiver, LocalDate date) {
        Objects.requireNonNull(date, "date");
        long epochDay = date.toEpochDay();
        LocalTime time = receiver.toLocalTime();
        long secs = (86400 * epochDay) + time.toSecondOfDay();
        ZoneOffset offset = receiver.getOffset();
        return secs - offset.getTotalSeconds();
    }
}