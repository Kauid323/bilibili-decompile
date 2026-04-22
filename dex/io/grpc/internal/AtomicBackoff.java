package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AtomicBackoff {
    private static final Logger log = Logger.getLogger(AtomicBackoff.class.getName());
    private final String name;
    private final AtomicLong value = new AtomicLong();

    public AtomicBackoff(String name, long value) {
        Preconditions.checkArgument(value > 0, "value must be positive");
        this.name = name;
        this.value.set(value);
    }

    public State getState() {
        return new State(this.value.get());
    }

    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long savedValue;

        private State(long value) {
            this.savedValue = value;
        }

        public long get() {
            return this.savedValue;
        }

        public void backoff() {
            long newValue = Math.max(this.savedValue * 2, this.savedValue);
            boolean swapped = AtomicBackoff.this.value.compareAndSet(this.savedValue, newValue);
            if (AtomicBackoff.this.value.get() < newValue) {
                throw new AssertionError();
            }
            if (swapped) {
                AtomicBackoff.log.log(Level.WARNING, "Increased {0} to {1}", new Object[]{AtomicBackoff.this.name, Long.valueOf(newValue)});
            }
        }
    }
}