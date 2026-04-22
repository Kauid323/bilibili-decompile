package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.util.Objects;
import java.math.BigDecimal;

public final class DesugarDuration {
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_MINUTE = 60;

    public static long dividedBy(Duration receiver, Duration divisor) {
        Objects.requireNonNull(divisor, "divisor");
        BigDecimal dividendBigD = toBigDecimalSeconds(receiver);
        BigDecimal divisorBigD = toBigDecimalSeconds(divisor);
        return dividendBigD.divideToIntegralValue(divisorBigD).longValueExact();
    }

    public static long toSeconds(Duration receiver) {
        return receiver.getSeconds();
    }

    public static long toDaysPart(Duration receiver) {
        long seconds = receiver.getSeconds();
        return seconds / 86400;
    }

    public static int toHoursPart(Duration receiver) {
        return (int) (receiver.toHours() % 24);
    }

    public static int toMinutesPart(Duration receiver) {
        return (int) (receiver.toMinutes() % 60);
    }

    public static int toSecondsPart(Duration receiver) {
        long seconds = receiver.getSeconds();
        return (int) (seconds % 60);
    }

    public static int toMillisPart(Duration receiver) {
        int nanos = receiver.getNano();
        return nanos / 1000000;
    }

    public static int toNanosPart(Duration receiver) {
        int nanos = receiver.getNano();
        return nanos;
    }

    public static Duration truncatedTo(Duration receiver, TemporalUnit unit) {
        long seconds = receiver.getSeconds();
        int nanos = receiver.getNano();
        Objects.requireNonNull(unit, "unit");
        if (unit == ChronoUnit.SECONDS && (seconds >= 0 || nanos == 0)) {
            return Duration.ofSeconds(seconds);
        }
        if (unit == ChronoUnit.NANOS) {
            return receiver;
        }
        Duration unitDur = unit.getDuration();
        if (unitDur.getSeconds() > 86400) {
            throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
        }
        long dur = unitDur.toNanos();
        if (NANOS_PER_DAY % dur != 0) {
            throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
        }
        long nod = ((seconds % 86400) * 1000000000) + nanos;
        long result = (nod / dur) * dur;
        return receiver.plusNanos(result - nod);
    }

    private static BigDecimal toBigDecimalSeconds(Duration receiver) {
        long seconds = receiver.getSeconds();
        int nanos = receiver.getNano();
        return BigDecimal.valueOf(seconds).add(BigDecimal.valueOf(nanos, 9));
    }
}