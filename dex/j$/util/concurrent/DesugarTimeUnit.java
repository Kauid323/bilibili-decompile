package j$.util.concurrent;

import j$.time.Duration;
import j$.time.temporal.ChronoUnit;
import j$.util.DesugarCalendar;
import j$.util.Objects;
import java.util.concurrent.TimeUnit;

public class DesugarTimeUnit {
    private static final long DAY_SCALE = 86400000000000L;
    private static final long HOUR_SCALE = 3600000000000L;
    private static final long MICRO_SCALE = 1000;
    private static final long MILLI_SCALE = 1000000;
    private static final long MINUTE_SCALE = 60000000000L;
    private static final long NANO_SCALE = 1;
    private static final long SECOND_SCALE = 1000000000;

    private DesugarTimeUnit() {
    }

    public static ChronoUnit toChronoUnit(TimeUnit timeUnit) {
        switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
            case 1:
                return ChronoUnit.NANOS;
            case DesugarCalendar.LONG_FORMAT /* 2 */:
                return ChronoUnit.MICROS;
            case 3:
                return ChronoUnit.MILLIS;
            case 4:
                return ChronoUnit.SECONDS;
            case 5:
                return ChronoUnit.MINUTES;
            case 6:
                return ChronoUnit.HOURS;
            case 7:
                return ChronoUnit.DAYS;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: j$.util.concurrent.DesugarTimeUnit$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit = new int[ChronoUnit.values().length];
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

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
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $SwitchMap$java$util$concurrent$TimeUnit = new int[TimeUnit.values().length];
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public static TimeUnit of(ChronoUnit chronoUnit) {
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) Objects.requireNonNull(chronoUnit, "chronoUnit")).ordinal()]) {
            case 1:
                return TimeUnit.NANOSECONDS;
            case DesugarCalendar.LONG_FORMAT /* 2 */:
                return TimeUnit.MICROSECONDS;
            case 3:
                return TimeUnit.MILLISECONDS;
            case 4:
                return TimeUnit.SECONDS;
            case 5:
                return TimeUnit.MINUTES;
            case 6:
                return TimeUnit.HOURS;
            case 7:
                return TimeUnit.DAYS;
            default:
                throw new IllegalArgumentException("No TimeUnit equivalent for " + chronoUnit);
        }
    }

    public static long convert(TimeUnit timeUnit, Duration duration) {
        return timeUnit.convert(duration.toNanos(), TimeUnit.NANOSECONDS);
    }
}