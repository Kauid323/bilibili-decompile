package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
public final class AtomicLongCounter implements LongCounter {
    private final AtomicLong counter = new AtomicLong();

    @Override // io.grpc.internal.LongCounter
    public void add(long delta) {
        this.counter.getAndAdd(delta);
    }

    @Override // io.grpc.internal.LongCounter
    public long value() {
        return this.counter.get();
    }
}