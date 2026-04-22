package j$.time;

import j$.time.zone.ZoneRules;
import j$.util.Objects;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.function.LongFunction;

public final class DesugarLocalDate {
    public static final LocalDate EPOCH = LocalDate.of(1970, 1, 1);
    private static final int SECONDS_PER_DAY = 86400;

    private DesugarLocalDate() {
    }

    public static Stream<LocalDate> datesUntil(LocalDate receiver, LocalDate endExclusive) {
        long end = endExclusive.toEpochDay();
        long start = receiver.toEpochDay();
        if (end < start) {
            throw new IllegalArgumentException(endExclusive + " < " + receiver);
        }
        return LongStream.CC.range(start, end).mapToObj(new DesugarLocalDate$$ExternalSyntheticLambda2());
    }

    public static Stream<LocalDate> datesUntil(final LocalDate receiver, LocalDate endExclusive, Period step) {
        long steps;
        if (step.isZero()) {
            throw new IllegalArgumentException("step is zero");
        }
        long end = endExclusive.toEpochDay();
        final long start = receiver.toEpochDay();
        long until = end - start;
        final long months = step.toTotalMonths();
        final long days = step.getDays();
        if ((months < 0 && days > 0) || (months > 0 && days < 0)) {
            throw new IllegalArgumentException("period months and days are of opposite sign");
        }
        if (until == 0) {
            return Stream.CC.empty();
        }
        int sign = (months > 0 || days > 0) ? 1 : -1;
        if (!((sign < 0) ^ (until < 0))) {
            if (months == 0) {
                return LongStream.CC.rangeClosed(0L, (until - sign) / days).mapToObj(new LongFunction() { // from class: j$.time.DesugarLocalDate$$ExternalSyntheticLambda3
                    @Override // java.util.function.LongFunction
                    public final Object apply(long j) {
                        LocalDate ofEpochDay;
                        ofEpochDay = LocalDate.ofEpochDay((j * days) + start);
                        return ofEpochDay;
                    }
                });
            }
            long steps2 = ((until * 1600) / ((48699 * months) + (1600 * days))) + 1;
            long addMonths = months * steps2;
            long addDays = days * steps2;
            long maxAddMonths = months > 0 ? getProlepticMonth(LocalDate.MAX) - getProlepticMonth(receiver) : getProlepticMonth(receiver) - getProlepticMonth(LocalDate.MIN);
            if (sign * addMonths <= maxAddMonths && (receiver.plusMonths(addMonths).toEpochDay() + addDays) * sign < sign * end) {
                steps = steps2;
                return LongStream.CC.rangeClosed(0L, steps).mapToObj(new LongFunction() { // from class: j$.time.DesugarLocalDate$$ExternalSyntheticLambda4
                    @Override // java.util.function.LongFunction
                    public final Object apply(long j) {
                        LocalDate plusDays;
                        plusDays = LocalDate.this.plusMonths(months * j).plusDays(days * j);
                        return plusDays;
                    }
                });
            }
            long steps3 = steps2 - 1;
            long addMonths2 = addMonths - months;
            steps = (((long) sign) * addMonths2 > maxAddMonths || (receiver.plusMonths(addMonths2).toEpochDay() + (addDays - days)) * ((long) sign) >= ((long) sign) * end) ? steps3 - 1 : steps3;
            return LongStream.CC.rangeClosed(0L, steps).mapToObj(new LongFunction() { // from class: j$.time.DesugarLocalDate$$ExternalSyntheticLambda4
                @Override // java.util.function.LongFunction
                public final Object apply(long j) {
                    LocalDate plusDays;
                    plusDays = LocalDate.this.plusMonths(months * j).plusDays(days * j);
                    return plusDays;
                }
            });
        }
        throw new IllegalArgumentException(endExclusive + (sign < 0 ? " > " : " < ") + receiver);
    }

    public static long toEpochSecond(LocalDate receiver, LocalTime time, ZoneOffset offset) {
        Objects.requireNonNull(time, "time");
        Objects.requireNonNull(offset, "offset");
        long secs = (receiver.toEpochDay() * 86400) + time.toSecondOfDay();
        return secs - offset.getTotalSeconds();
    }

    public static LocalDate ofInstant(Instant instant, ZoneId zone) {
        long localEpochDay;
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zone, "zone");
        ZoneRules rules = zone.getRules();
        ZoneOffset offset = rules.getOffset(instant);
        long localSecond = instant.getEpochSecond() + offset.getTotalSeconds();
        localEpochDay = DesugarLocalDate$$ExternalSyntheticBackport0.m(localSecond, SECONDS_PER_DAY);
        return LocalDate.ofEpochDay(localEpochDay);
    }

    private static long getProlepticMonth(LocalDate receiver) {
        int year = receiver.getYear();
        int month = receiver.getMonthValue();
        return ((year * 12) + month) - 1;
    }
}