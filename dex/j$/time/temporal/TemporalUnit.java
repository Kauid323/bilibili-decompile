package j$.time.temporal;

import j$.time.Duration;
import j$.time.LocalTime;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.ChronoZonedDateTime;

public interface TemporalUnit {
    <R extends Temporal> R addTo(R r, long j);

    long between(Temporal temporal, Temporal temporal2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(Temporal temporal);

    boolean isTimeBased();

    String toString();

    /* renamed from: j$.time.temporal.TemporalUnit$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$isSupportedBy(TemporalUnit _this, Temporal temporal) {
            if (temporal instanceof LocalTime) {
                return _this.isTimeBased();
            }
            if (temporal instanceof ChronoLocalDate) {
                return _this.isDateBased();
            }
            if ((temporal instanceof ChronoLocalDateTime) || (temporal instanceof ChronoZonedDateTime)) {
                return true;
            }
            try {
                temporal.plus(1L, _this);
                return true;
            } catch (UnsupportedTemporalTypeException e) {
                return false;
            } catch (RuntimeException e2) {
                try {
                    temporal.plus(-1L, _this);
                    return true;
                } catch (RuntimeException e3) {
                    return false;
                }
            }
        }
    }
}