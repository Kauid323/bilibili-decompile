package j$.time;

import java.io.Serializable;

public abstract class DesugarClock {
    static final long NANOS_PER_MILLI = 1000000;

    private DesugarClock() {
    }

    public static Clock tickMillis(ZoneId zone) {
        return new DesugarTickClock(Clock.system(zone), NANOS_PER_MILLI);
    }

    /* loaded from: /data/np/file-convert/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f/20260223054853e3c40628-7775-4ab0-b76f-0da19168206f.dex */
    static final class DesugarTickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        DesugarTickClock(Clock baseClock, long tickNanos) {
            this.baseClock = baseClock;
            this.tickNanos = tickNanos;
        }

        @Override // j$.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // j$.time.Clock
        public Clock withZone(ZoneId zone) {
            if (zone.equals(this.baseClock.getZone())) {
                return this;
            }
            return new DesugarTickClock(this.baseClock.withZone(zone), this.tickNanos);
        }

        @Override // j$.time.Clock
        public long millis() {
            long millis = this.baseClock.millis();
            return millis - Clock$TickClock$$ExternalSyntheticBackport0.m(millis, this.tickNanos / DesugarClock.NANOS_PER_MILLI);
        }

        @Override // j$.time.Clock
        public Instant instant() {
            if (this.tickNanos % DesugarClock.NANOS_PER_MILLI == 0) {
                long millis = this.baseClock.millis();
                return Instant.ofEpochMilli(millis - Clock$TickClock$$ExternalSyntheticBackport0.m(millis, this.tickNanos / DesugarClock.NANOS_PER_MILLI));
            }
            Instant instant = this.baseClock.instant();
            long nanos = instant.getNano();
            long adjust = Clock$TickClock$$ExternalSyntheticBackport0.m(nanos, this.tickNanos);
            return instant.minusNanos(adjust);
        }

        @Override // j$.time.Clock
        public boolean equals(Object obj) {
            if (obj instanceof DesugarTickClock) {
                DesugarTickClock other = (DesugarTickClock) obj;
                return this.baseClock.equals(other.baseClock) && this.tickNanos == other.tickNanos;
            }
            return false;
        }

        @Override // j$.time.Clock
        public int hashCode() {
            return this.baseClock.hashCode() ^ ((int) (this.tickNanos ^ (this.tickNanos >>> 32)));
        }

        public String toString() {
            Clock clock = this.baseClock;
            return "DesugarTickClock[" + clock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }
    }
}