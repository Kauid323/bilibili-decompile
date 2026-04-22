package j$.time;

import j$.time.format.DateTimeParseException;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.util.DesugarCalendar;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static class Lazy {
        static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

        private Lazy() {
        }
    }

    public static Duration ofDays(long days) {
        return create(Duration$$ExternalSyntheticBackport7.m(days, 86400), 0);
    }

    public static Duration ofHours(long hours) {
        return create(Duration$$ExternalSyntheticBackport8.m(hours, 3600), 0);
    }

    public static Duration ofMinutes(long minutes) {
        return create(Duration$$ExternalSyntheticBackport9.m(minutes, 60), 0);
    }

    public static Duration ofSeconds(long seconds) {
        return create(seconds, 0);
    }

    public static Duration ofSeconds(long seconds, long nanoAdjustment) {
        long secs = Clock$OffsetClock$$ExternalSyntheticBackport0.m(seconds, DesugarLocalDate$$ExternalSyntheticBackport0.m(nanoAdjustment, 1000000000L));
        int nos = (int) Clock$TickClock$$ExternalSyntheticBackport0.m(nanoAdjustment, 1000000000L);
        return create(secs, nos);
    }

    public static Duration ofMillis(long millis) {
        long secs = millis / 1000;
        int mos = (int) (millis % 1000);
        if (mos < 0) {
            mos += 1000;
            secs--;
        }
        return create(secs, 1000000 * mos);
    }

    public static Duration ofNanos(long nanos) {
        long secs = nanos / 1000000000;
        int nos = (int) (nanos % 1000000000);
        if (nos < 0) {
            nos = (int) (nos + 1000000000);
            secs--;
        }
        return create(secs, nos);
    }

    public static Duration of(long amount, TemporalUnit unit) {
        return ZERO.plus(amount, unit);
    }

    public static Duration from(TemporalAmount amount) {
        Objects.requireNonNull(amount, "amount");
        Duration duration = ZERO;
        for (TemporalUnit unit : amount.getUnits()) {
            duration = duration.plus(amount.get(unit), unit);
        }
        return duration;
    }

    public static Duration parse(CharSequence text) {
        int fractionStart;
        Objects.requireNonNull(text, "text");
        Matcher matcher = Lazy.PATTERN.matcher(text);
        if (matcher.matches()) {
            if (!charMatch(text, matcher.start(3), matcher.end(3), 'T')) {
                boolean negate = charMatch(text, matcher.start(1), matcher.end(1), '-');
                int dayStart = matcher.start(2);
                int dayEnd = matcher.end(2);
                int hourStart = matcher.start(4);
                int hourEnd = matcher.end(4);
                int minuteStart = matcher.start(5);
                int minuteEnd = matcher.end(5);
                int secondStart = matcher.start(6);
                int secondEnd = matcher.end(6);
                int fractionStart2 = matcher.start(7);
                int fractionEnd = matcher.end(7);
                if (dayStart >= 0 || hourStart >= 0 || minuteStart >= 0 || secondStart >= 0) {
                    long daysAsSecs = parseNumber(text, dayStart, dayEnd, 86400, "days");
                    long hoursAsSecs = parseNumber(text, hourStart, hourEnd, 3600, "hours");
                    long minsAsSecs = parseNumber(text, minuteStart, minuteEnd, 60, "minutes");
                    long seconds = parseNumber(text, secondStart, secondEnd, 1, "seconds");
                    boolean negativeSecs = secondStart >= 0 && text.charAt(secondStart) == '-';
                    int nanos = parseFraction(text, fractionStart2, fractionEnd, negativeSecs ? -1 : 1);
                    try {
                        return create(negate, daysAsSecs, hoursAsSecs, minsAsSecs, seconds, nanos);
                    } catch (ArithmeticException ex) {
                        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", text, 0).initCause(ex));
                    }
                }
                fractionStart = 0;
            } else {
                fractionStart = 0;
            }
        } else {
            fractionStart = 0;
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", text, fractionStart);
    }

    private static boolean charMatch(CharSequence text, int start, int end, char c) {
        return start >= 0 && end == start + 1 && text.charAt(start) == c;
    }

    private static long parseNumber(CharSequence text, int start, int end, int multiplier, String errorText) {
        if (start < 0 || end < 0) {
            return 0L;
        }
        try {
            long val = Duration$$ExternalSyntheticBackport5.m(text, start, end, 10);
            return Duration$$ExternalSyntheticBackport6.m(val, multiplier);
        } catch (ArithmeticException | NumberFormatException ex) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + errorText, text, 0).initCause(ex));
        }
    }

    private static int parseFraction(CharSequence text, int start, int end, int negate) {
        if (start < 0 || end < 0 || end - start == 0) {
            return 0;
        }
        try {
            int fraction = Duration$$ExternalSyntheticBackport4.m(text, start, end, 10);
            for (int i = end - start; i < 9; i++) {
                fraction *= 10;
            }
            int i2 = fraction * negate;
            return i2;
        } catch (ArithmeticException | NumberFormatException ex) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", text, 0).initCause(ex));
        }
    }

    private static Duration create(boolean negate, long daysAsSecs, long hoursAsSecs, long minsAsSecs, long secs, int nanos) {
        long seconds = Clock$OffsetClock$$ExternalSyntheticBackport0.m(daysAsSecs, Clock$OffsetClock$$ExternalSyntheticBackport0.m(hoursAsSecs, Clock$OffsetClock$$ExternalSyntheticBackport0.m(minsAsSecs, secs)));
        if (negate) {
            return ofSeconds(seconds, nanos).negated();
        }
        return ofSeconds(seconds, nanos);
    }

    public static Duration between(Temporal startInclusive, Temporal endExclusive) {
        long nanos;
        try {
            return ofNanos(startInclusive.until(endExclusive, ChronoUnit.NANOS));
        } catch (DateTimeException | ArithmeticException e) {
            long secs = startInclusive.until(endExclusive, ChronoUnit.SECONDS);
            try {
                nanos = endExclusive.getLong(ChronoField.NANO_OF_SECOND) - startInclusive.getLong(ChronoField.NANO_OF_SECOND);
                if (secs > 0 && nanos < 0) {
                    secs++;
                } else if (secs < 0 && nanos > 0) {
                    secs--;
                }
            } catch (DateTimeException e2) {
                nanos = 0;
            }
            return ofSeconds(secs, nanos);
        }
    }

    private static Duration create(long seconds, int nanoAdjustment) {
        if ((nanoAdjustment | seconds) == 0) {
            return ZERO;
        }
        return new Duration(seconds, nanoAdjustment);
    }

    private Duration(long seconds, int nanos) {
        this.seconds = seconds;
        this.nanos = nanos;
    }

    @Override // j$.time.temporal.TemporalAmount
    public long get(TemporalUnit unit) {
        if (unit == ChronoUnit.SECONDS) {
            return this.seconds;
        }
        if (unit == ChronoUnit.NANOS) {
            return this.nanos;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + unit);
    }

    @Override // j$.time.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return DurationUnits.UNITS;
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    private static class DurationUnits {
        static final List<TemporalUnit> UNITS = Duration$DurationUnits$$ExternalSyntheticBackport1.m(ChronoUnit.SECONDS, ChronoUnit.NANOS);

        private DurationUnits() {
        }
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int getNano() {
        return this.nanos;
    }

    public Duration withSeconds(long seconds) {
        return create(seconds, this.nanos);
    }

    public Duration withNanos(int nanoOfSecond) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(nanoOfSecond);
        return create(this.seconds, nanoOfSecond);
    }

    public Duration plus(Duration duration) {
        return plus(duration.getSeconds(), duration.getNano());
    }

    public Duration plus(long amountToAdd, TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit");
        if (unit == ChronoUnit.DAYS) {
            return plus(Duration$$ExternalSyntheticBackport0.m(amountToAdd, 86400), 0L);
        }
        if (unit.isDurationEstimated()) {
            throw new UnsupportedTemporalTypeException("Unit must not have an estimated duration");
        }
        if (amountToAdd == 0) {
            return this;
        }
        if (unit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) unit).ordinal()]) {
                case 1:
                    return plusNanos(amountToAdd);
                case DesugarCalendar.LONG_FORMAT /* 2 */:
                    return plusSeconds((amountToAdd / 1000000000) * 1000).plusNanos((amountToAdd % 1000000000) * 1000);
                case 3:
                    return plusMillis(amountToAdd);
                case 4:
                    return plusSeconds(amountToAdd);
                default:
                    return plusSeconds(Duration$$ExternalSyntheticBackport1.m(unit.getDuration().seconds, amountToAdd));
            }
        }
        Duration duration = unit.getDuration().multipliedBy(amountToAdd);
        return plusSeconds(duration.getSeconds()).plusNanos(duration.getNano());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.Duration$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit = new int[ChronoUnit.values().length];

        static {
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public Duration plusDays(long daysToAdd) {
        return plus(Duration$$ExternalSyntheticBackport3.m(daysToAdd, 86400), 0L);
    }

    public Duration plusHours(long hoursToAdd) {
        return plus(Duration$$ExternalSyntheticBackport2.m(hoursToAdd, 3600), 0L);
    }

    public Duration plusMinutes(long minutesToAdd) {
        return plus(Duration$$ExternalSyntheticBackport10.m(minutesToAdd, 60), 0L);
    }

    public Duration plusSeconds(long secondsToAdd) {
        return plus(secondsToAdd, 0L);
    }

    public Duration plusMillis(long millisToAdd) {
        return plus(millisToAdd / 1000, (millisToAdd % 1000) * 1000000);
    }

    public Duration plusNanos(long nanosToAdd) {
        return plus(0L, nanosToAdd);
    }

    private Duration plus(long secondsToAdd, long nanosToAdd) {
        if ((secondsToAdd | nanosToAdd) == 0) {
            return this;
        }
        long epochSec = Clock$OffsetClock$$ExternalSyntheticBackport0.m(this.seconds, secondsToAdd);
        long epochSec2 = Clock$OffsetClock$$ExternalSyntheticBackport0.m(epochSec, nanosToAdd / 1000000000);
        long nanoAdjustment = this.nanos + (nanosToAdd % 1000000000);
        return ofSeconds(epochSec2, nanoAdjustment);
    }

    public Duration minus(Duration duration) {
        long secsToSubtract = duration.getSeconds();
        int nanosToSubtract = duration.getNano();
        if (secsToSubtract == Long.MIN_VALUE) {
            return plus(Long.MAX_VALUE, -nanosToSubtract).plus(1L, 0L);
        }
        return plus(-secsToSubtract, -nanosToSubtract);
    }

    public Duration minus(long amountToSubtract, TemporalUnit unit) {
        return amountToSubtract == Long.MIN_VALUE ? plus(Long.MAX_VALUE, unit).plus(1L, unit) : plus(-amountToSubtract, unit);
    }

    public Duration minusDays(long daysToSubtract) {
        return daysToSubtract == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-daysToSubtract);
    }

    public Duration minusHours(long hoursToSubtract) {
        return hoursToSubtract == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-hoursToSubtract);
    }

    public Duration minusMinutes(long minutesToSubtract) {
        return minutesToSubtract == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-minutesToSubtract);
    }

    public Duration minusSeconds(long secondsToSubtract) {
        return secondsToSubtract == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-secondsToSubtract);
    }

    public Duration minusMillis(long millisToSubtract) {
        return millisToSubtract == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1L) : plusMillis(-millisToSubtract);
    }

    public Duration minusNanos(long nanosToSubtract) {
        return nanosToSubtract == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-nanosToSubtract);
    }

    public Duration multipliedBy(long multiplicand) {
        if (multiplicand == 0) {
            return ZERO;
        }
        if (multiplicand == 1) {
            return this;
        }
        return create(toBigDecimalSeconds().multiply(BigDecimal.valueOf(multiplicand)));
    }

    public Duration dividedBy(long divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        if (divisor == 1) {
            return this;
        }
        return create(toBigDecimalSeconds().divide(BigDecimal.valueOf(divisor), RoundingMode.DOWN));
    }

    public long dividedBy(Duration divisor) {
        Objects.requireNonNull(divisor, "divisor");
        BigDecimal dividendBigD = toBigDecimalSeconds();
        BigDecimal divisorBigD = divisor.toBigDecimalSeconds();
        return dividendBigD.divideToIntegralValue(divisorBigD).longValueExact();
    }

    private BigDecimal toBigDecimalSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    private static Duration create(BigDecimal seconds) {
        BigInteger nanos = seconds.movePointRight(9).toBigIntegerExact();
        BigInteger[] divRem = nanos.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (divRem[0].bitLength() > 63) {
            throw new ArithmeticException("Exceeds capacity of Duration: " + nanos);
        }
        return ofSeconds(divRem[0].longValue(), divRem[1].intValue());
    }

    public Duration negated() {
        return multipliedBy(-1L);
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        if (this.seconds != 0) {
            temporal = temporal.plus(this.seconds, ChronoUnit.SECONDS);
        }
        if (this.nanos != 0) {
            return temporal.plus(this.nanos, ChronoUnit.NANOS);
        }
        return temporal;
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        if (this.seconds != 0) {
            temporal = temporal.minus(this.seconds, ChronoUnit.SECONDS);
        }
        if (this.nanos != 0) {
            return temporal.minus(this.nanos, ChronoUnit.NANOS);
        }
        return temporal;
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public long toSeconds() {
        return this.seconds;
    }

    public long toMillis() {
        long tempSeconds = this.seconds;
        long tempNanos = this.nanos;
        if (tempSeconds < 0) {
            tempSeconds++;
            tempNanos -= 1000000000;
        }
        long millis = Duration$$ExternalSyntheticBackport11.m(tempSeconds, 1000);
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(millis, tempNanos / 1000000);
    }

    public long toNanos() {
        long tempSeconds = this.seconds;
        long tempNanos = this.nanos;
        if (tempSeconds < 0) {
            tempSeconds++;
            tempNanos -= 1000000000;
        }
        long totalNanos = Duration$$ExternalSyntheticBackport1.m(tempSeconds, 1000000000L);
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(totalNanos, tempNanos);
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public int toMillisPart() {
        return this.nanos / 1000000;
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public Duration truncatedTo(TemporalUnit unit) {
        Objects.requireNonNull(unit, "unit");
        if (unit == ChronoUnit.SECONDS && (this.seconds >= 0 || this.nanos == 0)) {
            return new Duration(this.seconds, 0);
        }
        if (unit == ChronoUnit.NANOS) {
            return this;
        }
        Duration unitDur = unit.getDuration();
        if (unitDur.getSeconds() > 86400) {
            throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
        }
        long dur = unitDur.toNanos();
        if (86400000000000L % dur != 0) {
            throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
        }
        long nod = ((this.seconds % 86400) * 1000000000) + this.nanos;
        long result = (nod / dur) * dur;
        return plusNanos(result - nod);
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration otherDuration) {
        int cmp = Long.compare(this.seconds, otherDuration.seconds);
        if (cmp != 0) {
            return cmp;
        }
        return this.nanos - otherDuration.nanos;
    }

    public boolean equals(Object otherDuration) {
        if (this == otherDuration) {
            return true;
        }
        if (otherDuration instanceof Duration) {
            Duration other = (Duration) otherDuration;
            return this.seconds == other.seconds && this.nanos == other.nanos;
        }
        return false;
    }

    public int hashCode() {
        return ((int) (this.seconds ^ (this.seconds >>> 32))) + (this.nanos * 51);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long effectiveTotalSecs = this.seconds;
        if (this.seconds < 0 && this.nanos > 0) {
            effectiveTotalSecs++;
        }
        long hours = effectiveTotalSecs / 3600;
        int minutes = (int) ((effectiveTotalSecs % 3600) / 60);
        int secs = (int) (effectiveTotalSecs % 60);
        StringBuilder buf = new StringBuilder(24);
        buf.append("PT");
        if (hours != 0) {
            buf.append(hours).append('H');
        }
        if (minutes != 0) {
            buf.append(minutes).append('M');
        }
        if (secs == 0 && this.nanos == 0 && buf.length() > 2) {
            return buf.toString();
        }
        if (this.seconds < 0 && this.nanos > 0) {
            if (secs == 0) {
                buf.append("-0");
            } else {
                buf.append(secs);
            }
        } else {
            buf.append(secs);
        }
        if (this.nanos > 0) {
            int pos = buf.length();
            if (this.seconds < 0) {
                buf.append(2000000000 - this.nanos);
            } else {
                buf.append(this.nanos + 1000000000);
            }
            while (buf.charAt(buf.length() - 1) == '0') {
                buf.setLength(buf.length() - 1);
            }
            buf.setCharAt(pos, '.');
        }
        buf.append('S');
        return buf.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    private void readObject(ObjectInputStream s) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) {
        out.writeLong(this.seconds);
        out.writeInt(this.nanos);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Duration readExternal(DataInput in) {
        long seconds = in.readLong();
        int nanos = in.readInt();
        return ofSeconds(seconds, nanos);
    }
}