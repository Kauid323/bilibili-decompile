package io.grpc.internal;

/* JADX INFO: Access modifiers changed from: package-private */
public final class LongCounterFactory {
    LongCounterFactory() {
    }

    public static LongCounter create() {
        if (ReflectionLongAdderCounter.isAvailable()) {
            return new ReflectionLongAdderCounter();
        }
        return new AtomicLongCounter();
    }
}